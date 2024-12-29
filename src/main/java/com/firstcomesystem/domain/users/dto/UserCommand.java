package com.firstcomesystem.domain.users.dto;

import com.firstcomesystem.domain.users.entity.Users;
import com.firstcomesystem.domain.users.policy.EncryptionPolicy;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UserCommand {
    private final String email;
    private final String password;
    private final String name;
    private final String phoneNumber;
    private final String address;

    public Users toEntity(EncryptionPolicy policy) {
        return Users.builder()
                .email(policy.encryptData(email))
                .password(policy.hashData(password))
                .name(policy.encryptData(name))
                .phoneNumber(policy.encryptData(phoneNumber))
                .address(policy.encryptData(address))
                .build();
    }
}
