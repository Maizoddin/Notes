package com.example.authentication.security;

import com.example.authentication.entity.User;
import com.example.authentication.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private final String secrete;
    private final long accessExpirationMs;
    private final Key key;
    private UserService userService;

    public JwtService(
            @Value("${app.jwt-access-expiration-ms}") long accessExpirationMs,
            @Value("${app.jwt.secrete}") String secrete,
            UserService userService
            ){
        this.accessExpirationMs = accessExpirationMs;
        this.secrete = secrete;
        this.key = Keys.hmacShaKeyFor(secrete.getBytes(StandardCharsets.UTF_8));
        this.userService = userService;
    }

    public String generateAccessToken(UserDetails userDetails){
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateAccessToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Authentication getAuthentication(String token){
        String username = getUsernameFromClaims(getClaimsFromToken(token));
        User user = userService.findByEmail(username);
        UserDetails userDetails = CustomUserDetails.build(user);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    public Claims getClaimsFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromClaims(Claims claims){
        return claims.getSubject();
    }


}
