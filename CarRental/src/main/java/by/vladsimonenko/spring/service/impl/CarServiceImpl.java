package by.vladsimonenko.spring.service.impl;

import by.vladsimonenko.spring.dao.CarDAO;
import by.vladsimonenko.spring.entity.Car;
import by.vladsimonenko.spring.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    static Logger logger = LogManager.getLogger();
    private CarDAO carDAO;

    @Autowired
    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    @Transactional
    public List<Car> getAllCars() {
        logger.info("get all cars as list from db");
        return carDAO.getAllCars();
    }

    @Override
    @Transactional
    public Car getCarById(int id) {
        return carDAO.getCarById(id);
    }
}
