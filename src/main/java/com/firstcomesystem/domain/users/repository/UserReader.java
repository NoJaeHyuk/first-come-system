package com.firstcomesystem.domain.users.repository;

import com.firstcomesystem.domain.users.entity.Users;

public interface UserReader {
    public Users gerUser(Long userId);

    boolean existsByEmail(String email);
}
