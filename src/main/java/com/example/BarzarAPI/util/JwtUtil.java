package com.example.BarzarAPI.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
  public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
  private static final long EXPIRATION_TIME = 30 * 60 * 1000; // 30 minutes

  public String generateToken(String userName) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, userName);
  }

  private String createToken(Map<String, Object> claims, String userName) {
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(userName)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(getSignKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  private Key getSignKey() {
    byte[] keyBytes = SECRET.getBytes();
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String extractUsername(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(getSignKey())
        .parseClaimsJws(token)
        .getBody();

    return claims.getSubject();
  }

  public boolean isTokenExpired(String token) {
    Date expirationDate = Jwts.parser()
        .setSigningKey(getSignKey())
        .parseClaimsJws(token)
        .getBody()
        .getExpiration();

    return expirationDate.before(new Date());
  }

  public boolean validateToken(String token, UserDetails userDetails) {
    String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }
}