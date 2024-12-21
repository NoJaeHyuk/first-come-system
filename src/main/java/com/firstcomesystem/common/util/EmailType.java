package com.firstcomesystem.common.util;

import lombok.Getter;

@Getter
public enum EmailType {
    SIGNUP("회원 가입을 위한 이메일입니다!",
            "이메일을 인증하기 위한 절차입니다.<br><br>인증 번호는 <b>{authCode}</b> 입니다.<br>회원 가입 폼에 해당 번호를 입력해주세요.");

    private final String subject;
    private final String content;

    EmailType(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getContent(String authCode) {
        return content.replace("{authCode}", authCode);
    }
}
