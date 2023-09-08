package by.vladsimonenko.spring.dao;

import by.vladsimonenko.spring.entity.Booking;

import java.util.List;

public interface BookingDAO {
    void saveBooking(Booking booking);

    void deleteBookingById(int id);

    List<Booking> findAllUnconfirmedBookings();

    List<Booking> findAllActiveBookings();

    List<Booking> findAllUnconfirmedForChangeBackBookings();

    Booking findBookingById(int id);

    void changeStartAcceptedById(int id, boolean change);

    void changeEndAcceptedById(int id, boolean change);

}
