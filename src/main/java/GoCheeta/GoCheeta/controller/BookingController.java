package GoCheeta.GoCheeta.controller;

import GoCheeta.GoCheeta.entity.Booking;
import GoCheeta.GoCheeta.service.BookingService;
import GoCheeta.GoCheeta.service.ReservationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @PostMapping("/booking/save")
    public String saveReservation(Booking booking, RedirectAttributes redirectAttributes)
    {

        bookingService.saveReservation(booking);
        redirectAttributes.addFlashAttribute("message", "Reservation Added Successfully");
        return "Reservation";
    }


    @GetMapping("/booking/new")
    public String showReservationForm(Model model)
    {
        model.addAttribute("booking", new Booking());
        model.addAttribute("pagetitle", "Add New Booking" );
        return "addReservation";
    }

    //GetAll operation
    @GetMapping("/booking")
    public String viewManageBooking(Model model)
    {
        List<Booking> bookingList = bookingService.fetchReservationList();
        model.addAttribute("bookingList", bookingList);
        return "manageManageBooking";
    }


    // Delete operation
    @GetMapping("/booking/delete/{bookingId}")
    public String deleteReservationById(@PathVariable("bookingId") Integer bookingId, RedirectAttributes re)
    {
        try{
            bookingService.deleteReservationById(bookingId);
            re.addFlashAttribute("message", "The reservation id "  +bookingId+ " has been deleted");

        }catch (ReservationNotFoundException e){

            re.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/customers";
    }



}
