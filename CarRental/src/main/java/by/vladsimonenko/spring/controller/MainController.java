package by.vladsimonenko.spring.controller;

import by.vladsimonenko.spring.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
