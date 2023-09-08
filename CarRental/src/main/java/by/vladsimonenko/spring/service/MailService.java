package by.vladsimonenko.spring.service;

import by.vladsimonenko.spring.entity.Booking;
import by.vladsimonenko.spring.entity.Client;

public interface MailService {

    void sendMailRefusalRental(Booking booking,String reason);

    void sendMailConfirmingRental(Booking booking);

    void sendMailConfirmingEndRental(Booking booking);
    void sendMailConfirmingEndRentalWithScratches(Booking booking);
    void sendMailConfirmingEndRentalWithDirty(Booking booking);

}
