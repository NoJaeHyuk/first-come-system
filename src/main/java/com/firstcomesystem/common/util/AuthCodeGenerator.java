package com.firstcomesystem.common.util;

import java.util.Random;

public class AuthCodeGenerator {
    public static String generateAuthCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000)); // 0~999999 사이의 숫자를 6자리로 패딩
    }
}
