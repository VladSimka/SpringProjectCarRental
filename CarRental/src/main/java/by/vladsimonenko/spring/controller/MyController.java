package by.vladsimonenko.spring.controller;

import by.vladsimonenko.spring.dao.CarDAO;
import by.vladsimonenko.spring.entity.Car;
import by.vladsimonenko.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyController {
    private CarService carService;

    @Autowired
    public MyController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }


    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }


    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/cars")
    public String showCars(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("allCars",cars);
        return "cars";
    }
}
