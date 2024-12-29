package com.firstcomesystem.infrastructure.user;

import com.firstcomesystem.common.util.AESUtil;
import com.firstcomesystem.domain.users.policy.EncryptionPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptionPolicyImpl implements EncryptionPolicy {
    private final PasswordEncoder passwordEncoder;
    private final AESUtil aesUtil;

    public EncryptionPolicyImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        String secretKey = "MySecretKey12345"; // TODO 환경 변수 사용 변경
        this.aesUtil = new AESUtil(secretKey);
    }

    @Override
    public String hashData(String data) {
        return passwordEncoder.encode(data);
    }

    @Override
    public String encryptData(String data) {
        return aesUtil.encrypt(data);
    }

    @Override
    public String decryptData(String encryptedData) {
        return aesUtil.decrypt(encryptedData);
    }
}
