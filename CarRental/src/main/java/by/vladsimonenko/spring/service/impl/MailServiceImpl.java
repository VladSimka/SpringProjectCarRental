package by.vladsimonenko.spring.service.impl;

import by.vladsimonenko.spring.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    private JavaMailSender javaMailSender;
    private static final String ADMIN_MAIL = "vladsimonenko428@gmail.com";

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendTestMail() {

        String to = "springcarrental1@gmail.com";
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom(ADMIN_MAIL);

        msg.setSubject("привет ");
        msg.setText("пытаюсь послать сообщение");

        javaMailSender.send(msg);
    }

    @Override
    public void sendMailRefusalRental() {

    }

    @Override
    public void sendMailConfirmingRental() {

    }
}
