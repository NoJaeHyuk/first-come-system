package com.firstcomesystem.domain.users.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "MemberToken", timeToLive = 3600 * 24 * 14) // TTL: 14일
@AllArgsConstructor
@Getter
public class Redis {

    @Id
    private String email; // 로그인 아이디
    private String refreshToken; // Refresh Token
}
