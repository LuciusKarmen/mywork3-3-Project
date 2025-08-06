package org.example.kkback.hander;

import org.example.kkback.dao.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatWebSocketHandler implements WebSocketHandler {

    // 存储用户ID -> WebSocketSession 的映射
    private static final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 从 URI 获取 userId，例如：ws://localhost:8080/ws/chat?userId=user1
        String uri = session.getUri().toString();
        String userId = extractUserId(uri);

        if (userId != null && !userId.isEmpty()) {
            sessions.put(userId, session);
            System.out.println("用户上线: " + userId + ", 当前在线: " + sessions.size());
        } else {
            session.close(CloseStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message.getPayloadLength() == 0) return;

        String payload = (String) message.getPayload();
        try {
            // 反序列化前端发来的消息
            Message msg = objectMapper.readValue(payload, Message.class);

            // 验证消息
            if (msg.getFrom_id() == null || msg.getTo_id() == null || msg.getContent() == null) {
                return;
            }

            // 设置默认值
            if (msg.getId() == null) {
                msg.setId(String.valueOf(System.currentTimeMillis()));
            }
            if (msg.getTime() == null) {
                msg.setTime(java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
            }
            if (msg.getRead() == null) {
                msg.setRead(false);
            }

            // 查找接收方 session
            WebSocketSession receiverSession = sessions.get(msg.getTo_id());

            if (receiverSession != null && receiverSession.isOpen()) {
                receiverSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(msg)));
                System.out.println("消息已发送给 " + msg.getTo_id());
            } else {
                // 用户不在线，可以存入离线消息（可扩展）
                System.out.println("用户不在线: " + msg.getTo_id());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("WebSocket 传输错误: " + exception.getMessage());
        session.close();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // 从 sessions 中移除
        sessions.entrySet().removeIf(entry -> entry.getValue().getId().equals(session.getId()));
        System.out.println("连接关闭，剩余在线: " + sessions.size());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    // 提取 userId 工具方法
    private String extractUserId(String uri) {
        if (uri == null) return null;
        String[] parts = uri.split("\\?");
        if (parts.length < 2) return null;

        String query = parts[1];
        String[] params = query.split("&");
        for (String param : params) {
            if (param.startsWith("userId=")) {
                return param.substring("userId=".length());
            }
        }
        return null;
    }
    public Map<String, WebSocketSession> getSessions() {
        return sessions;
    }
}