package com.firstcomesystem.domain.users.service;

import com.firstcomesystem.common.exception.MailSendingException;
import com.firstcomesystem.common.util.AuthCodeGenerator;
import com.firstcomesystem.common.util.EmailType;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailSenderServiceImpl implements MailSenderService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(String email, String authCode) {
        EmailType emailType = EmailType.SIGNUP;
        String subject = emailType.getSubject();
        String content = emailType.getContent(authCode);

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
            helper.setTo(email); // customer email
            helper.setSubject(subject); // email title
            helper.setText(content,true); // content, html: true
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new MailSendingException();
        }
    }
}
