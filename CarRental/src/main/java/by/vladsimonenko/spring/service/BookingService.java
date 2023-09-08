package by.vladsimonenko.spring.service;

import by.vladsimonenko.spring.entity.Booking;

import java.util.List;

public interface BookingService {
    void saveBooking(Booking booking);

    void deleteBookingById(int id);

    List<Booking> findAllUnconfirmedBookings();

    List<Booking> findAllActiveBookings();

    Booking findBookingById(int id);

    void changeStartAcceptedById(int id, boolean change);

    void changeEndAcceptedById(int id, boolean change);

    List<Booking> findAllUnconfirmedForChangeBackBookings();
}
