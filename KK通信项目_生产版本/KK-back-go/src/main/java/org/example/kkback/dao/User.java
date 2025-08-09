package org.example.kkback.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private String username;
    @JsonIgnore
    private String password;
    private String id;
    private String pic;

}
