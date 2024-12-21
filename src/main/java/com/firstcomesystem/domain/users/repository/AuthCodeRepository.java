package com.firstcomesystem.domain.users.repository;

public interface AuthCodeRepository {
    void saveAuthCode(String email, String authCode, long expirationTime);
    String getAuthCode(String email);
    void deleteAuthCode(String email);
}
