package by.vladsimonenko.spring.controller;

import by.vladsimonenko.spring.entity.Car;
import by.vladsimonenko.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCars(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("allCars", cars);
        return "cars";
    }

    @GetMapping("/cars/{id}")
    public String showCarInfo(@PathVariable int id, Model model) {
        Car currentCar = carService.getCarById(id);
        model.addAttribute("currentCar", currentCar);
        return "showInfo";
    }
}
