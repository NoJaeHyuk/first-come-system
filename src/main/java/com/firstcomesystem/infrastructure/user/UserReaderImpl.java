package com.firstcomesystem.infrastructure.user;

import com.firstcomesystem.domain.users.repository.UserReader;
import com.firstcomesystem.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {
    private final UserRepository userRepository;

    @Override
    public Users gerUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException());
    }
}
