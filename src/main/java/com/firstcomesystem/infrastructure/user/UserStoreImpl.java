package com.firstcomesystem.infrastructure.user;

import com.firstcomesystem.domain.users.entity.Users;
import com.firstcomesystem.domain.users.repository.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {
    private final UserRepository userRepository;

    @Override
    public Users store(Users initUser) {
        return userRepository.save(initUser);
    }
}
