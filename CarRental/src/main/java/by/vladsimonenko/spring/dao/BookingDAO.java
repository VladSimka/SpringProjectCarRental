package by.vladsimonenko.spring.dao;

import by.vladsimonenko.spring.entity.Booking;
import java.util.List;

public interface BookingDAO {
    void saveBooking(Booking booking);
    void deleteBooking(int id);
    List<Booking> findAllUnconfirmedBookings();
}
