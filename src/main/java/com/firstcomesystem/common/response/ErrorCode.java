package com.firstcomesystem.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
    COMMON_ENTITY_NOT_FOUND("존재하지 않는 엔티티입니다."),
    COMMON_ILLEGAL_STATUS("잘못된 상태값입니다."),
    COMMON_DUPLICATE("이미 존재하는 데이터입니다."),
    EMAIL_SENDING("정상적으로 메일이 보내지지 않았습니다."),

    // 보안 관련 에러코드
    SECURITY_ERROR("Security operation failed."),
    ENCRYPTION_ERROR("Encryption failed."),
    DECRYPTION_ERROR("Decryption failed.")
    ;

    private final String errorMsg;

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}
