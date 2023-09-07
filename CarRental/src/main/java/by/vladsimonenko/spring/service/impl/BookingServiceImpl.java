package by.vladsimonenko.spring.service.impl;

import by.vladsimonenko.spring.dao.BookingDAO;
import by.vladsimonenko.spring.entity.Booking;
import by.vladsimonenko.spring.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    BookingDAO bookingDAO;

    @Autowired
    public BookingServiceImpl(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    @Transactional
    public void saveBooking(Booking booking) {
        bookingDAO.saveBooking(booking);
    }

    @Override
    @Transactional
    public void deleteBookingById(int id) {
        bookingDAO.deleteBookingById(id);
    }

    @Override
    @Transactional
    public List<Booking> findAllUnconfirmedBookings() {
        return bookingDAO.findAllUnconfirmedBookings();
    }

    @Override
    @Transactional
    public List<Booking> findAllActiveBookings() {
        return bookingDAO.findAllActiveBookings();
    }

    @Override
    @Transactional
    public Booking findBookingById(int id) {
        return bookingDAO.findBookingById(id);
    }

    @Override
    @Transactional
    public void changeStartAcceptedById(int id, boolean change) {
        bookingDAO.changeStartAcceptedById(id, change);
    }
}
