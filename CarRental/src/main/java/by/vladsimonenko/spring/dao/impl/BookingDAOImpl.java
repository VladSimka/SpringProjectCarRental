package by.vladsimonenko.spring.dao.impl;

import by.vladsimonenko.spring.dao.BookingDAO;
import by.vladsimonenko.spring.entity.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public void deleteBookingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Booking WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Booking> findAllUnconfirmedBookings() {
        Session session = sessionFactory.getCurrentSession();
        List<Booking> bookings = session.createQuery("FROM Booking WHERE startAccepted =" + false, Booking.class).getResultList();
        return bookings;
    }

    @Override
    public List<Booking> findAllActiveBookings() {
        Session session = sessionFactory.getCurrentSession();
        List<Booking> bookings = session.createQuery("FROM Booking WHERE startAccepted =" + true +
                " and endAccepted=" + false, Booking.class).getResultList();
        return bookings;
    }

    @Override
    public Booking findBookingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Booking.class, id);
    }

    @Override
    public void changeStartAcceptedById(int id, boolean change) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("UPDATE Booking SET startAccepted =" + change + " WHERE id =" + id).executeUpdate();
    }
}
