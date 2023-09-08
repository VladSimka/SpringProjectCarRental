package by.vladsimonenko.spring.controller;

import by.vladsimonenko.spring.entity.Booking;
import by.vladsimonenko.spring.service.BookingService;
import by.vladsimonenko.spring.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    BookingService bookingService;
    MailService mailService;

    @Autowired
    public AdminController(BookingService bookingService, MailService mailService) {
        this.bookingService = bookingService;
        this.mailService = mailService;
    }


    @GetMapping("/login")
    public String login(Model model, @RequestParam(name = "error", required = false) String error) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/admin/requests")
    public String adminRequests(Model model) {
        model.addAttribute("requests", bookingService.findAllUnconfirmedBookings());
        return "admin/requests";
    }

    @PostMapping("/admin/requests/{id}")
    public String acceptRequest(@PathVariable int id) {
        Booking booking = bookingService.findBookingById(id);
        bookingService.changeStartAcceptedById(id, true);
        mailService.sendMailConfirmingRental(booking);

        return "redirect:/admin/requests";
    }

    @PostMapping("/admin/requests/delete/{id}")
    public String refuseRequest(@PathVariable int id,@RequestParam("reason") String reason) {
        Booking booking = bookingService.findBookingById(id);

        mailService.sendMailRefusalRental(booking,reason);
        bookingService.deleteBookingById(id);
        return "redirect:/admin/requests";
    }



    @GetMapping("/admin/active-requests")
    public String activeRequests(Model model) {
        model.addAttribute("activeRequests",bookingService.findAllActiveBookings());

        return "admin/active-requests";
    }

    @GetMapping("/admin/end-of-requests")
    public String endOfRequests(Model model){
        model.addAttribute("endingRequests",bookingService.findAllUnconfirmedForChangeBackBookings());
        return "admin/submission";
    }

    @PostMapping("/admin/end-of-requests/{id}")
    public String finishRequest(@PathVariable int id){
        Booking booking = bookingService.findBookingById(id);
        bookingService.changeEndAcceptedById(id, true);
        mailService.sendMailConfirmingEndRental(booking);

        return "redirect:/admin/end-of-requests";
    }

}
