package by.vladsimonenko.spring.dao.impl;

import by.vladsimonenko.spring.dao.BookingDAO;
import by.vladsimonenko.spring.entity.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDAOImpl implements BookingDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public BookingDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void saveBooking(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.save(booking);
    }
}
