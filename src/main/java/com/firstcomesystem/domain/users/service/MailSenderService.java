package com.firstcomesystem.domain.users.service;

public interface MailSenderService {

    public void sendMail(String email, String authCode);
}
