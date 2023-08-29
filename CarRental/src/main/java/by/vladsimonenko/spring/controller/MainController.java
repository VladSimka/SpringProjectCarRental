package by.vladsimonenko.spring.controller;

import by.vladsimonenko.spring.entity.Car;
import by.vladsimonenko.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

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

    @GetMapping("/promo")
    public String promo(){
        return "promo";
    }

}
