package com.zeus.loginservice2.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class JwtUtil {

    static void addAuthentication(HttpServletResponse response, String username){

        String token = Jwts.builder().setSubject(username)
                .signWith(SignatureAlgorithm.HS256,"1QaZ2WsX")
                .compact();

        response.addHeader("Authorization", "Bearer "  + token);

    }

    static Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");

        if(!StringUtils.isBlank(token)){
            String user = Jwts.parser()
                            .setSigningKey("1QaZ2WsX")
                            .parseClaimsJws(token.replace("Bearer",""))
                            .getBody()
                            .getSubject();

            return user !=null ? new UsernamePasswordAuthenticationToken(user,null,Collections.emptyList())
                    : null;
        }
        return null;
    }
}
