package com.firstcomesystem.application.users;

import com.firstcomesystem.domain.users.dto.UserCommand;
import com.firstcomesystem.domain.users.dto.UserInfo;
import com.firstcomesystem.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserFacade {
    private final UserService userService;

    public UserInfo registerUser(UserCommand command) {
        UserInfo userInfo = userService.registerUser(command);
        return userInfo;
    }

}
