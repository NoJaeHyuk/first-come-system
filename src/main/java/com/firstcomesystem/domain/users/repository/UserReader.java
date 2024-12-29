package com.firstcomesystem.domain.users.repository;

import com.firstcomesystem.domain.users.entity.Users;

public interface UserReader {
    Users getUser(Long userId);

    boolean existsByEmail(String email);

    Users getUserByEmail(String email);
}
