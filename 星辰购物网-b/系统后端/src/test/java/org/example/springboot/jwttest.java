package org.example.springboot;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class jwttest {
    @Test
    public void testGen(){
        Map<String,Object> clarms= new HashMap<>();
        clarms.put("username","karmen");
        String token = JWT.create().withClaim("username",clarms)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24*7))
                .sign(Algorithm.HMAC256("xgm"));
        System.out.println(token);

    }
    @Test
    public void testVerify(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6eyJ1c2VybmFtZSI6Imthcm1lbiJ9LCJleHAiOjE3NDkxNzg0MjJ9.7P2QGN2vymCRjIAod5DhkSsjnm_wPOhNATvu3NX_jBQ";

         JWTVerifier jwtVerify=JWT.require(Algorithm.HMAC256("xgm")).build();

        DecodedJWT decodeJWT = jwtVerify.verify(token);
        Map<String,Object> map = decodeJWT.getClaim("username").asMap();
        System.out.println(map);

    }


}
