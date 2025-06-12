package org.example.springboot.utils;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;


import java.util.Date;
import java.util.Map;

public class JWTUTIL {
    private static final String key = "karmen";
    //秘钥是karmen注意不可以外泄
    //创建token,JWT令牌生成
    public static String genToken(Map<String,Object> claims){
        return com.auth0.jwt.JWT.create()
                .withClaim( "user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24*7))
                .sign(Algorithm.HMAC256(key));
    }

    //解析token
    public static Map<String,Object> parseToken(String token){
        return com.auth0.jwt.JWT.require(Algorithm.HMAC256(key))
                .build()
                .verify(token).
                getClaim("user")
                .asMap();
    }







}
