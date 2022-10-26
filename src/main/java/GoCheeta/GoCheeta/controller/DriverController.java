package GoCheeta.GoCheeta.controller;

import GoCheeta.GoCheeta.entity.Driver;
import GoCheeta.GoCheeta.service.CustomerNotFoundException;
import GoCheeta.GoCheeta.service.DriverNotFoundException;
import GoCheeta.GoCheeta.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DriverController {

    @Autowired
    private DriverService driverService;

    //new
    @GetMapping("/drivers/new")
    public String showNewDriverForm(Model model)
    {
        model.addAttribute("driver", new Driver());
        model.addAttribute("pagetitle", "Add New Driver" );
        return "driverForm";
    }

    // Save operation
    @PostMapping("/drivers/save")
    public String saveDriver(Driver driver, RedirectAttributes redirectAttributes)
    {

        driverService.saveDriver(driver);
        redirectAttributes.addFlashAttribute("message", "Driver Saved Successfully");
        return "redirect:/drivers";
    }

    // Read operation
    @GetMapping("/drivers")
    public String fetchDriverList(Model model)
    {

        List<Driver> driverList = driverService.fetchDriverList();
        model.addAttribute("driverList", driverList);
        return "driversDetailsForm";
    }

    @GetMapping("/drivers/edit/{driverId}")
    public String getDriverbyId(@PathVariable ("driverId")int driverId, Model model, RedirectAttributes redirectAttributes)
    {
        try{
            Driver driver = driverService.getDriverbyId(driverId);
            model.addAttribute("driver" ,driver);
            model.addAttribute("pagetitle", "Edit Driver ( "+ driverId +" )" );
            return "driverForm";
        } catch (DriverNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/drivers";
        }

    }

    // Update operation
    @PutMapping("/drivers/{driverId}")
    public Driver updateDriver(@RequestBody Driver driver, @PathVariable("driverId") Integer driverId)
    {
        return driverService.updateDriver(
                driver, driverId);
    }

    // Delete operation
    @GetMapping("/drivers/delete/{driverId}")
    public String deleteDriverById(@PathVariable("driverId") Integer driverId, RedirectAttributes re)
    {
        try{
            driverService.deleteDriverById(driverId);
            re.addFlashAttribute("message", "The driver id "  +driverId+ " has been deleted");

        }catch (CustomerNotFoundException e){

            re.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/drivers";
    }
}
