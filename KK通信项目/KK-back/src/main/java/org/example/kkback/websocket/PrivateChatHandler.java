package org.example.kkback.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kkback.dao.Message;
import org.example.kkback.dao.Session;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 私聊消息处理器
 */
public class PrivateChatHandler extends TextWebSocketHandler {

    // 保存所有在线用户的会话信息，key: userid，value: Session对象
    private static final Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    // 用于消息序列化/反序列化
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 当用户连接时
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 假设前端连接格式为：/chat/{userId}/{friendId}
        String uri = session.getUri().toString();
        String[] uriParts = uri.split("/");
        String userId = uriParts[uriParts.length - 2]; // 当前用户ID
        String friendId = uriParts[uriParts.length - 1]; // 要聊天的好友ID

        Session userSession = new Session();
        userSession.setUserid(userId);
        userSession.setFriendid(friendId);
        userSession.setSession(session);

        onlineSessions.put(userId, userSession);
        System.out.println("用户上线: " + userId);
    }

    /**
     * 接收到客户端发送的消息
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Message msg = objectMapper.readValue(payload, Message.class);

        // 设置发送时间（示例）
        msg.setTime(new Date().toString());

        // 查找接收方是否在线
        Session receiverSession = onlineSessions.get(msg.getTo_id());

        // 构造返回消息
        String response = String.format("[私聊] %s: %s", msg.getFrom_id(), msg.getContent());

        // 如果接收方在线，转发消息
        if (receiverSession != null && receiverSession.getSession().isOpen()) {
            receiverSession.getSession().sendMessage(new TextMessage(response));
        } else {
            // 接收方不在线，可以保存为离线消息（示例）
            System.out.println("用户 " + msg.getTo_id() + " 不在线，消息暂未送达");
            // todo: 保存到数据库作为离线消息
        }

        // 可以回传消息给自己（确认发送成功）
        session.sendMessage(new TextMessage("[已发送] " + msg.getContent()));
    }

    /**
     * 连接断开时移除会话
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        // 遍历查找并移除
        onlineSessions.entrySet().removeIf(entry -> {
            return entry.getValue().getSession().getId().equals(session.getId());
        });
        System.out.println("用户下线");
    }

    /**
     * 获取当前所有在线用户
     */
    public static Collection<Session> getOnlineSessions() {
        return onlineSessions.values();
    }

    /**
     * 判断用户是否在线
     */
    public static boolean isOnline(String userId) {
        return onlineSessions.containsKey(userId);
    }
}