package com.firstcomesystem.interfaces.users;

import com.firstcomesystem.domain.users.dto.UserCommand;
import com.firstcomesystem.domain.users.dto.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserDto {

    @Getter
    @Builder
    @ToString
    public static class RegisterRequest {
        private String email;
        private String password;
        private String name;
        private String phoneNumber;
        private String address;

        public UserCommand toCommand() {
            return UserCommand.builder()
                    .name(name)
                    .email(email)
                    .password(password)
                    .phoneNumber(phoneNumber)
                    .address(address)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private Long id;
        private String email;
        private String password;
        private String name;
        private String phoneNumber;
        private String address;

        public RegisterResponse(UserInfo userInfo) {
            this.id = userInfo.getId();
            this.email = userInfo.getEmail();
            this.password = userInfo.getPassword();
            this.name = userInfo.getName();
            this.phoneNumber = userInfo.getPhoneNumber();
            this.address = userInfo.getAddress();
        }
    }
}
