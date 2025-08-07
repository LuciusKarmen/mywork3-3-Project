package org.example.kkback.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class CustomHandshakeInterceptor implements HandshakeInterceptor {
    public static CustomHandshakeInterceptor createHandshakeInterceptor() {
        return new CustomHandshakeInterceptor();
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            String userid = servletRequest.getServletRequest().getParameter("userid");
            String friendid = servletRequest.getServletRequest().getParameter("friendid");

            if (userid != null) {
                attributes.put("userid", userid);
            }
            if (friendid != null) {
                attributes.put("friendid", friendid);
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception exception) {
        // 无需实现
    }
}