package com.firstcomesystem.domain.users.service;

import com.firstcomesystem.domain.users.repository.AuthCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthCodeService {

    private final AuthCodeRepository authCodeRepository;

    private static final long EXPIRATION_TIME = 300L; // 5분

    public void saveAuthCode(String email, String authCode) {
        authCodeRepository.saveAuthCode(email, authCode, EXPIRATION_TIME);
    }

    public String getAuthCode(String email) {
        return authCodeRepository.getAuthCode(email);
    }

    public void deleteAuthCode(String email) {
        authCodeRepository.deleteAuthCode(email);
    }
}
