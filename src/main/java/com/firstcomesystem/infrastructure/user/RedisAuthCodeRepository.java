package com.firstcomesystem.infrastructure.user;

import com.firstcomesystem.domain.users.repository.AuthCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class RedisAuthCodeRepository implements AuthCodeRepository {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void saveAuthCode(String email, String authCode, long expirationTime) {
        redisTemplate.opsForValue().set(email, authCode, expirationTime, TimeUnit.SECONDS);
    }

    @Override
    public String getAuthCode(String email) {
        return redisTemplate.opsForValue().get(email);
    }

    @Override
    public void deleteAuthCode(String email) {
        redisTemplate.delete(email);
    }
}
