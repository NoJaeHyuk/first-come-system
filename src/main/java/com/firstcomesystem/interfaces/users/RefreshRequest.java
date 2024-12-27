package com.firstcomesystem.interfaces.users;

import lombok.Getter;

@Getter
public class RefreshRequest {
    private String email;
    private String refreshToken;

    public RefreshRequest(String email, String refreshToken) {
        this.email = email;
        this.refreshToken = refreshToken;
    }
}
