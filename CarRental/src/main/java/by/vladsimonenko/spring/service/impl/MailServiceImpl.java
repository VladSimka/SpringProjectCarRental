package by.vladsimonenko.spring.service.impl;

import by.vladsimonenko.spring.entity.Booking;
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
    public void sendMailRefusalRental(Booking booking, String reason) {
        String message = "Добрый день, " + booking.getClient().getName() + " " +
                booking.getClient().getSurname() + "." +
                " Ваша заявка на аренду " + booking.getCar().getBrand()
                + " " + booking.getCar().getModel() + " отклонена. " +
                "Причина: " + reason + "." + " Деньги за плату возвращены Вам на карту.";
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(booking.getClient().getGmail());
        mailMessage.setFrom(ADMIN_MAIL);

        mailMessage.setSubject("Auto.by");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }

    @Override
    public void sendMailConfirmingRental(Booking booking) {
        String message = "Добрый день, " + booking.getClient().getName() + " " +
                booking.getClient().getSurname() + "." +
                " Ваша заявка на аренду " + booking.getCar().getBrand()
                + " " + booking.getCar().getModel() + " одобрена.";
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(ADMIN_MAIL);
        mailMessage.setTo(booking.getClient().getGmail());

        mailMessage.setSubject("Auto.by");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }

    @Override
    public void sendMailConfirmingEndRental(Booking booking) {
        String message = "Добрый день, " + booking.getClient().getName() + " " +
                booking.getClient().getSurname() + "." +
                " Аренда успешно окончена. Спасибо, что выбрали нас!";
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(ADMIN_MAIL);
        mailMessage.setTo(booking.getClient().getGmail());

        mailMessage.setSubject("Auto.by");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }


}
