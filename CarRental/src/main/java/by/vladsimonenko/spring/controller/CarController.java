package by.vladsimonenko.spring.controller;

import by.vladsimonenko.spring.entity.AvailableHours;
import by.vladsimonenko.spring.entity.Booking;
import by.vladsimonenko.spring.entity.Car;
import by.vladsimonenko.spring.entity.Client;
import by.vladsimonenko.spring.service.CarService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Validated
public class CarController {
    static Logger logger = LogManager.getLogger();
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
    public String order(@PathVariable int id, Model model) {
        Car currentCar = carService.getCarById(id);
        if (currentCar == null) {
            return "main";
        }
        Booking booking = new Booking();
        model.addAttribute("newBooking", new Booking());
        model.addAttribute("currentCar", currentCar);
        model.addAttribute("client",new Client());
        model.addAttribute("availableHours", AvailableHours.getInstance());
        logger.info("create new order and go filling it");
        return "order";
    }

    @GetMapping("/cars/{id}/payment")
    public String payment(@PathVariable int id, @Valid @ModelAttribute("newBooking") Booking booking, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentCar", carService.getCarById(id));
            model.addAttribute("client",new Client());
            model.addAttribute("availableHours", AvailableHours.getInstance());
            return "order";
        } else {
            return "payment";
        }
    }
}
