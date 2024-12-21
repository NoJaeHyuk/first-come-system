package com.firstcomesystem.application.users;

import com.firstcomesystem.common.util.AuthCodeGenerator;
import com.firstcomesystem.domain.users.dto.UserCommand;
import com.firstcomesystem.domain.users.dto.UserInfo;
import com.firstcomesystem.domain.users.service.AuthCodeService;
import com.firstcomesystem.domain.users.service.MailSenderService;
import com.firstcomesystem.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserFacade {
    private final UserService userService;
    private final MailSenderService mailSenderService;
    private final AuthCodeService authCodeService;

    public UserInfo registerUser(UserCommand command) {
        UserInfo userInfo = userService.registerUser(command);
        return userInfo;
    }

    public void requestAuthCode(String email) {
        userService.checkEmailAvailability(email);
        String authCode = AuthCodeGenerator.generateAuthCode();
        mailSenderService.sendMail(email, authCode);
        authCodeService.saveAuthCode(email, authCode);
    }

    public boolean verifyAuthCode(String email, String inputAuthCode) {
        String savedAuthCode = authCodeService.getAuthCode(email);
        if (savedAuthCode == null || !savedAuthCode.equals(inputAuthCode)) {
            return false;
        }
        authCodeService.deleteAuthCode(email);
        return true;
    }

}
