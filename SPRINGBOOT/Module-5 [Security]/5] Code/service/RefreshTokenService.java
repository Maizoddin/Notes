package com.example.authentication.service;

import com.example.authentication.dto.RefreshTokenResponse;
import com.example.authentication.entity.RefreshToken;
import com.example.authentication.entity.User;
import com.example.authentication.exception.InvalidTokenException;
import com.example.authentication.repository.RefreshTokenRepository;
import com.example.authentication.security.CustomUserDetails;
import com.example.authentication.security.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private RefreshTokenRepository refreshTokenRepository;
    private final long refreshExpirationMs;
    private JwtService jwtService;

    public RefreshTokenService(
            @Value("${app.jwt.refresh-expiration-ms}") long refreshExpirationMs,
            RefreshTokenRepository refreshTokenRepository,
            JwtService jwtService
    ){
        this.refreshExpirationMs = refreshExpirationMs;
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtService = jwtService;
    }

    @Transactional
    public RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshExpirationMs));
        refreshToken.setRevoked(false);

        return refreshTokenRepository.save(refreshToken);
    }

    @Transactional
    public void revokeToken(String token){
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow();
        refreshToken.setRevoked(true);
        refreshTokenRepository.save(refreshToken);
    }

    public RefreshTokenResponse refreshToken(String token){
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow();

        if(! validateRefreshToken(refreshToken))    {
            throw new InvalidTokenException("Invalid Token");
        }

        UserDetails userDetails = CustomUserDetails.build(refreshToken.getUser());

        String accessToken = jwtService.generateAccessToken(userDetails);
        RefreshTokenResponse response = new RefreshTokenResponse(accessToken);
        return response;

    }

    public boolean validateRefreshToken(RefreshToken token){
        return !token.isRevoked() && token.getExpiryDate().compareTo(Instant.now()) >= 0;
    }
}
