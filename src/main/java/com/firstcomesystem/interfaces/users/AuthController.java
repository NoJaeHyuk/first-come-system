package com.firstcomesystem.interfaces.users;

import com.firstcomesystem.common.util.JwtTokenProvider;
import com.firstcomesystem.domain.users.service.RedisTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtTokenProvider jwtTokenProvider,
                          RefreshTokenService refreshTokenService,
                          PasswordEncoder passwordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.refreshTokenService = refreshTokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // 이메일과 패스워드 검증 (DB 조회 필요)
        if (!"jaehyuk7700@gmail.com".equals(request.getUsername()) || !passwordEncoder.matches(request.getPassword(), passwordEncoder.encode("123456"))) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String accessToken = jwtTokenProvider.createAccessToken(request.getUsername());
        String refreshToken = jwtTokenProvider.createRefreshToken();
        refreshTokenService.saveRefreshToken(request.getUsername(), refreshToken);

        return ResponseEntity.ok(new TokenResponse(accessToken, refreshToken));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshRequest request) {
        if (!refreshTokenService.validateRefreshToken(request.getEmail(), request.getRefreshToken())) {
            return ResponseEntity.status(401).body("Invalid or expired refresh token");
        }

        // 새로운 Access Token 발급
        String newAccessToken = jwtTokenProvider.createAccessToken(request.getRefreshToken());

        return ResponseEntity.ok(new TokenResponse(newAccessToken, request.getRefreshToken()));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutRequest request) {
        refreshTokenService.deleteRefreshToken(request.getEmail());
        return ResponseEntity.ok("Logged out successfully");
    }
}
