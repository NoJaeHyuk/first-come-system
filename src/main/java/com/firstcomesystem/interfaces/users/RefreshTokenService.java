package com.firstcomesystem.interfaces.users;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RefreshTokenService {

    private final RedisTemplate<String, String> redisTemplate;

    public RefreshTokenService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveRefreshToken(String email, String refreshToken) {
        redisTemplate.opsForValue().set(email, refreshToken, 24, TimeUnit.HOURS);
    }

    public boolean validateRefreshToken(String email, String refreshToken) {
        String storedToken = redisTemplate.opsForValue().get(email);
        return storedToken != null && storedToken.equals(refreshToken);
    }

    public void deleteRefreshToken(String email) {
        redisTemplate.delete(email);
    }
}
