package com.firstcomesystem.common.util;


import com.firstcomesystem.common.exception.SecurityOperationException;
import com.firstcomesystem.common.response.ErrorCode;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

public class AESUtil {

    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;

    private final SecretKey secretKey;

    public AESUtil(String key) {
        try {
            this.secretKey = generateKey(key);
        } catch (Exception e) {
            throw new SecurityOperationException("Error generating AES key", ErrorCode.SECURITY_ERROR);
        }
    }

    public String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new SecurityOperationException("Encryption failed", ErrorCode.ENCRYPTION_ERROR);
        }
    }

    public String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new SecurityOperationException("Decryption failed", ErrorCode.DECRYPTION_ERROR);
        }
    }

    private SecretKey generateKey(String key) throws SecurityOperationException {
        try {
            byte[] keyBytes = key.getBytes();
            SecureRandom secureRandom = new SecureRandom(keyBytes);
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(KEY_SIZE, secureRandom);
            return keyGen.generateKey();
        } catch (Exception e) {
            throw new SecurityOperationException("Key generation failed", ErrorCode.SECURITY_ERROR);
        }
    }
}

