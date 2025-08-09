package org.example.kkback.config;

import org.example.kkback.handler.ChatWebSocketHandler;
import org.example.kkback.interceptor.CustomHandshakeInterceptor; // 修正：引用正确的类名
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatWebSocketHandler webSocketHandler;

    public WebSocketConfig(ChatWebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/ws/chat")
                .addInterceptors(CustomHandshakeInterceptor.createHandshakeInterceptor()) // 无需强制转换
                .setAllowedOriginPatterns("*");
    }
}