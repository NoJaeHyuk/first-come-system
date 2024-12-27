package com.firstcomesystem.infrastructure.user;

import com.firstcomesystem.domain.users.entity.Redis;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface RedisRepository extends CrudRepository<Redis, String> {
    // 기본적으로 email (key)로 데이터를 조회, 저장, 삭제 가능
}
