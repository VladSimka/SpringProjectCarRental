package by.vladsimonenko.spring.dao.impl;

import by.vladsimonenko.spring.dao.CarDAO;
import by.vladsimonenko.spring.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public CarDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Car> getAllCars() {
        Session session = sessionFactory.getCurrentSession();
        List<Car> allCars = session.createQuery("FROM Car", Car.class).getResultList();
        return allCars;
    }
}
