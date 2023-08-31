package by.vladsimonenko.spring.service.impl;

import by.vladsimonenko.spring.dao.BookingDAO;
import by.vladsimonenko.spring.entity.Booking;
import by.vladsimonenko.spring.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
