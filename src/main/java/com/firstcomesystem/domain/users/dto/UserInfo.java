package com.firstcomesystem.domain.users.dto;

import com.firstcomesystem.domain.users.entity.Users;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInfo {
    private final Long id;
    private final String email;
    private final String password;
    private final String name;
    private final String phoneNumber;
    private final String address;

    public UserInfo(Users user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getEmail();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
    }
}
