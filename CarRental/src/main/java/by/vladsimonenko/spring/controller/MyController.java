package by.vladsimonenko.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String mainPage(){
        return "main";
    }


    @GetMapping("/terms")
    public String terms(){
        return "terms";
    }
}
