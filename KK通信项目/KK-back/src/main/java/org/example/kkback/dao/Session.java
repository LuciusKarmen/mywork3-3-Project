package org.example.kkback.dao;

import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

@Data
public class Session {
    private String userid;
    private String friendid;
    private WebSocketSession session;
}
