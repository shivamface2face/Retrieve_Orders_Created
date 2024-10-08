package com.RetrieveOrders.Retrieve.Orders.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtUtils {

    private static final String SECRET_KEY = "your_secret_key_here";

    public static String getRoleFromToken(String token) {
        // Decode JWT and extract user role
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
            return claims.get("role", String.class);
        } catch (Exception e) {
            // Handle token parsing exceptions (e.g., expired token, invalid signature)
            return null; // Or throw an appropriate exception
        }
    }


    public static String getUserIdFromToken(String token) {
        // Decode JWT and extract user ID
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
            return claims.getSubject(); // assuming the userId is the subject
        } catch (Exception e) {
            // Handle token parsing exceptions
            return null; // Or throw an appropriate exception
        }
    }





    }


