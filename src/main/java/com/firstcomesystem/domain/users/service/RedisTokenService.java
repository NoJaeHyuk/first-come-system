package com.firstcomesystem.domain.users.service;

import com.firstcomesystem.domain.users.entity.Redis;
import com.firstcomesystem.infrastructure.user.RedisRepository;
import org.springframework.stereotype.Service;

@Service
public class RedisTokenService {

    private final RedisRepository redisRepository;

    public RedisTokenService(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    // RefreshToken 저장
    public void saveRefreshToken(String email, String refreshToken) {
        Redis redis = new Redis(email, refreshToken);
        redisRepository.save(redis);
    }

    // RefreshToken 조회
    public String getRefreshToken(String email) {
        return redisRepository.findById(email)
                .map(Redis::getRefreshToken)
                .orElse(null);
    }

    // RefreshToken 삭제
    public void deleteRefreshToken(String email) {
        redisRepository.deleteById(email);
    }
}
