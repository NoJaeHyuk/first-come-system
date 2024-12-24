package com.firstcomesystem.domain.users.service;

import com.firstcomesystem.common.exception.DuplicateEntityException;
import com.firstcomesystem.domain.users.dto.UserCommand;
import com.firstcomesystem.domain.users.dto.UserInfo;
import com.firstcomesystem.domain.users.entity.Users;
import com.firstcomesystem.domain.users.policy.EncryptionPolicy;
import com.firstcomesystem.domain.users.repository.UserReader;
import com.firstcomesystem.domain.users.repository.UserStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserStore userStore;
    private final UserReader userReader;
    private final EncryptionPolicy policy;

    @Override
    @Transactional
    public UserInfo registerUser(UserCommand command) {
        Users initUser = command.toEntity(policy);
        Users user = userStore.store(initUser);
        return new UserInfo(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserInfo getUserInfo(Long userId) {
        Users user = userReader.gerUser(userId);
        return new UserInfo(user, policy);
    }

    @Override
    @Transactional(readOnly = true)
    public void checkEmailAvailability(String email) {
        if (userReader.existsByEmail(email)) {
            throw new DuplicateEntityException("해당 이메일은 가입되어 있습니다.");
        }
    }
}
