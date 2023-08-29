package by.vladsimonenko.spring.service.impl;

import by.vladsimonenko.spring.dao.CarDAO;
import by.vladsimonenko.spring.entity.Car;
import by.vladsimonenko.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarDAO carDAO;

    @Autowired
    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    @Transactional
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    @Transactional
    public Car getCarById(int id) {
        return carDAO.getCarById(id);
    }
}
