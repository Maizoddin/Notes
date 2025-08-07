package com.example.authentication.controller;

import com.example.authentication.dto.LoginRequest;
import com.example.authentication.dto.LoginResponse;
import com.example.authentication.dto.RefreshTokenResponse;
import com.example.authentication.dto.SignupRequest;
import com.example.authentication.service.AuthService;
import com.example.authentication.service.RefreshTokenService;
import com.example.authentication.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private UserService userService;
    private AuthService authService;
    private RefreshTokenService refreshTokenService;

    public AuthController(UserService userService, AuthService authService, RefreshTokenService refreshTokenService){
        this.userService = userService;
        this.authService = authService;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request){
        userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        Map<String, String> tokens = authService.login(request);
        LoginResponse response = new LoginResponse(request.getUsername(), tokens.get("accessToken"));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.SET_COOKIE, createRefreshCookie(tokens.get("refreshToken")).toString())
                .body(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@CookieValue(name = "refreshToken") String token){
        authService.logout(token);
        return ResponseEntity.
                status(HttpStatus.OK)
                .header(HttpHeaders.SET_COOKIE, createExpiredCookie().toString())
                .body("Logout successful");
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponse> refreshToken(@CookieValue(name = "refreshToken") String refreshToken){
        RefreshTokenResponse response = refreshTokenService.refreshToken(refreshToken);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


//    ROLE BASED AUTHORIZATION
  /*
  @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers(){
        return null;
    }
    */

    private ResponseCookie createRefreshCookie(String token){
        return ResponseCookie.from("refreshToken", token)
                .httpOnly(true)
                .secure(true)
                .path("api/v1/auth")
                .maxAge(Duration.ofDays(30))
                .sameSite("Strict")
                .build();
    }

    private ResponseCookie createExpiredCookie(){
        return ResponseCookie.from("refreshToken", "")
                .httpOnly(true)
                .secure(true)
                .path("api/v1/auth")
                .maxAge(0)
                .sameSite("Strict")
                .build();
    }
}
