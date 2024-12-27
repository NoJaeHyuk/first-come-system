package com.firstcomesystem.interfaces.users;

import com.firstcomesystem.common.util.JwtTokenProvider;
import com.firstcomesystem.domain.users.service.RedisTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTokenService redisTokenService;

    public AuthController(JwtTokenProvider jwtTokenProvider, RedisTokenService redisTokenService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.redisTokenService = redisTokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String accessToken = jwtTokenProvider.createToken(request.getUsername());
        String refreshToken = jwtTokenProvider.createToken(request.getUsername());

        redisTokenService.saveRefreshToken(request.getUsername(), refreshToken);

        return ResponseEntity.ok(new TokenResponse(accessToken, refreshToken));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshRequest request) {
        String refreshToken = redisTokenService.getRefreshToken(request.getEmail());

        if (refreshToken == null || !refreshToken.equals(request.getRefreshToken())) {
            return ResponseEntity.status(401).body("Invalid refresh token");
        }

        // 새로운 Access Token 발급
        String newAccessToken = jwtTokenProvider.createToken(request.getEmail());

        return ResponseEntity.ok(new TokenResponse(newAccessToken, request.getRefreshToken()));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutRequest request) {
        redisTokenService.deleteRefreshToken(request.getEmail());
        return ResponseEntity.ok("Logged out successfully");
    }
}
