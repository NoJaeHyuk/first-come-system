package com.firstcomesystem.interfaces.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class EmailRequestDto {

    @Getter
    @NoArgsConstructor
    @ToString
    public static class AuthRequest {
        private String email;
    }

    @Getter
    @Builder
    @ToString
    public static class VerifyRequest {
        private String email;
        private String authCode;
    }
}
