package com.firstcomesystem.infrastructure.user;

import com.firstcomesystem.common.util.AESUtil;
import com.firstcomesystem.domain.users.policy.EncryptionPolicy;
import org.springframework.stereotype.Component;

@Component
public class EncryptionPolicyImpl implements EncryptionPolicy {
    //private final PasswordEncoder passwordEncoder;
    private final AESUtil aesUtil;

    public EncryptionPolicyImpl() {
        String secretKey = "MySecretKey12345"; // TODO 환경 변수 사용 변경
        this.aesUtil = new AESUtil(secretKey);
    }

    @Override
    public String hashData(String data) {
        // TODO Security 할때 PasswordEncoder를 사용하여 구현 예정
        return data;
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
