package org.example.kkback.handler;

import org.example.kkback.dao.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kkback.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String userid = getSessionParameter(session, "userid");
        if (userid != null) {
            userSessions.put(userid, session);
            System.out.println("用户 " + userid + " 已连接");
        } else {
            session.close(CloseStatus.NOT_ACCEPTABLE.withReason("Missing userid parameter"));
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try {
            Message msg = objectMapper.readValue(message.getPayload(), Message.class);

            if (msg.getFrom_id() == null || msg.getTo_id() == null || msg.getContent() == null) {
                sendError(session, "Invalid message format");
                return;
            }

            WebSocketSession toSession = userSessions.get(msg.getTo_id());

            if (toSession != null && toSession.isOpen()) {
                String response = objectMapper.writeValueAsString(msg);
                toSession.sendMessage(new TextMessage(response));
                System.out.println("消息已发送: " + msg.getFrom_id() + " -> " + msg.getTo_id());
            } else {
                sendError(session, "Recipient is not online");
            }
            
            // 设置统一格式的时间
            msg.setTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            // 为消息设置唯一ID
            msg.setId(java.util.UUID.randomUUID().toString());
            // 保存消息到数据库
            messageMapper.add(msg);

        } catch (Exception e) {
            sendError(session, "Message processing failed: " + e.getMessage());
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String userid = getSessionParameter(session, "userid");
        if (userid != null) {
            userSessions.remove(userid);
            System.out.println("用户 " + userid + " 已断开");
        }
    }

    private String getSessionParameter(WebSocketSession session, String paramName) {
        Object param = session.getAttributes().get(paramName);
        return param != null ? param.toString() : null;
    }

    private void sendError(WebSocketSession session, String errorMessage) throws IOException {
        Message error = new Message();
        error.setContent("ERROR: " + errorMessage);
        error.setFrom_id("system");
        error.setTo_id(getSessionParameter(session, "userid"));
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(error)));
    }
}