package com.firstcomesystem.common.exception;

import com.firstcomesystem.common.response.ErrorCode;

public class MailSendingException extends BaseException {

    public MailSendingException() {
        super(ErrorCode.EMAIL_SENDING);
    }

    public MailSendingException(String message) {
        super(message, ErrorCode.EMAIL_SENDING);
    }
}
