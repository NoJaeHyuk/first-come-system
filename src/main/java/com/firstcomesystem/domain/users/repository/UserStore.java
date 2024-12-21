package com.firstcomesystem.domain.users.repository;

import com.firstcomesystem.domain.users.entity.Users;

public interface UserStore {
    Users store(Users initUser);
}
