package by.vladsimonenko.spring.service;

import by.vladsimonenko.spring.entity.Booking;
import by.vladsimonenko.spring.entity.Client;

public interface MailService {
    void sendTestMail();

    void sendMailRefusalRental(Booking booking);

    void sendMailConfirmingRental(Booking booking);

}
