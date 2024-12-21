package com.firstcomesystem.domain.users.service;

import com.firstcomesystem.domain.users.dto.UserCommand;
import com.firstcomesystem.domain.users.dto.UserInfo;

public interface UserService {
    UserInfo registerUser(UserCommand command);
    UserInfo getUserInfo(Long userId);
    void checkEmailAvailability(String email);
}
