package com.firstcomesystem.common.exception;

import com.firstcomesystem.common.response.ErrorCode;

public class SecurityOperationException extends BaseException {

    public SecurityOperationException() {
        super(ErrorCode.SECURITY_ERROR);
    }

    public SecurityOperationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public SecurityOperationException(String errorMsg) {
        super(errorMsg, ErrorCode.SECURITY_ERROR);
    }

    public SecurityOperationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
