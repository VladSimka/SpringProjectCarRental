package by.vladsimonenko.spring.controller;

import by.vladsimonenko.spring.entity.*;
import by.vladsimonenko.spring.service.BookingService;
import by.vladsimonenko.spring.service.CarService;
import by.vladsimonenko.spring.service.ClientService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@Controller
@SessionAttributes({"newBooking", "creditCard"})
public class CarController {
    static Logger logger = LogManager.getLogger();
    private CarService carService;
    private BookingService bookingService;
    private ClientService clientService;

    @Autowired
    public CarController(CarService carService, BookingService bookingService, ClientService clientService) {
        this.carService = carService;
        this.bookingService = bookingService;
        this.clientService = clientService;
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
        booking.setCar(currentCar);
        booking.setClient(new Client());
        model.addAttribute("newBooking", booking);
        model.addAttribute("availableHours", AvailableHours.getInstance());
        logger.info("create new order and go filling it");
        return "order";
    }

    @GetMapping("/cars/{id}/payment")
    public String payment(@PathVariable int id, @Valid @ModelAttribute("newBooking") Booking booking, BindingResult bindingResult, Model model) {
        Car currentCar = carService.getCarById(id);
        booking.setCar(currentCar);
        if (bindingResult.hasErrors()) {
            model.addAttribute("availableHours", AvailableHours.getInstance());
            // model.addAttribute("newBooking", booking);
            return "order";
        } else {
            booking.setPrice(booking.getHours() * 10);
            model.addAttribute("creditCard", new CreditCard());
            return "payment";
        }
    }


    @GetMapping("/done")
    public String addBooking(Model model, @Valid @ModelAttribute("creditCard") CreditCard creditCard,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "payment";
        }


        Booking booking = (Booking) model.getAttribute("newBooking");
        booking.setStartDate(new Timestamp(System.currentTimeMillis()));
        clientService.saveClient(booking.getClient());
        bookingService.saveBooking(booking);
        return "main";

    }


}
