package com.RetrieveOrders.Retrieve.Orders.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUtils {

    private static final String SECRET_KEY = "";

    public  static String getRoleFromToken(String token) {

        log.info("Decode JWT and extract user ");
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
            return claims.get("role", String.class);
        } catch (Exception e) {
            log.error("token parsing exceptions (e.g., expired token, invalid signature)\n");
            System.err.println("Failed to parse token for role: " + e.getMessage());
            return null; // Or throw a custom exception
        }
    }


    public static String getUserIdFromToken(String token) {
        log.info("Decode JWT and extract user ");
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
            return claims.getSubject(); // assuming the userId is the subject
        } catch (Exception e) {

            log.error("token parsing exceptions");
            System.err.println("Failed to parse token for user ID: " + e.getMessage());
            return null;
        }
    }







    }


