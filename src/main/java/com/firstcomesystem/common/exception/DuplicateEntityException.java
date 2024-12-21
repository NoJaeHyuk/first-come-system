package com.firstcomesystem.common.exception;

import com.firstcomesystem.common.response.ErrorCode;

public class DuplicateEntityException extends BaseException {

    public DuplicateEntityException() {
        super(ErrorCode.COMMON_DUPLICATE);
    }

    public DuplicateEntityException(String message) {
        super(message, ErrorCode.COMMON_DUPLICATE);
    }
}
