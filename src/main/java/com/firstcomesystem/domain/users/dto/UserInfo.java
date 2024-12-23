package com.firstcomesystem.domain.users.dto;

import com.firstcomesystem.domain.users.entity.Users;
import com.firstcomesystem.domain.users.policy.EncryptionPolicy;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserInfo {
    private final Long id;
    private final String email;
    private final String name;
    private final String phoneNumber;
    private final String address;

    public UserInfo(Users user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
    }

    public UserInfo(Users user, EncryptionPolicy policy) {
        this.id = user.getId();
        this.email = policy.decryptData(user.getEmail());
        this.name = policy.decryptData(user.getName());
        this.phoneNumber = policy.decryptData(user.getPhoneNumber());
        this.address = policy.decryptData(user.getAddress());
    }
}
