package com.firstcomesystem.domain.users.policy;

public interface EncryptionPolicy {
    public String hashData(String data);
    public String encryptData(String data);
    public String decryptData(String data);
}
