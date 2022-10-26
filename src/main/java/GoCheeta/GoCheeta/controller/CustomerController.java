package GoCheeta.GoCheeta.controller;

import GoCheeta.GoCheeta.entity.Customer;
import GoCheeta.GoCheeta.service.CustomerNotFoundException;
import GoCheeta.GoCheeta.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //Save operation
    @PostMapping("/customers/save")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Customer Saved Successfully");
        return "redirect:/customers";

    }

    //new
    @GetMapping("/customers/new")
    public String showNewForm(Model model)
    {
        model.addAttribute("customer", new Customer());
        model.addAttribute("pagetitle", "Add New Customer" );
        return "userForm";
    }

    //GetAll operation
    @GetMapping("/customers")
    public String viewManageCustomer(Model model)
    {
        List<Customer> customerList = customerService.fetchCustomerList();
        model.addAttribute("customerList", customerList);
        return "manageCustomerForm";
    }

    //Edit operation
    @GetMapping("/customers/edit/{customerId}")
    public String getCustomerbyId(@PathVariable ("customerId")int customerId, Model model, RedirectAttributes redirectAttributes)
    {
        try{
            Customer customer = customerService.getCustomerbyId(customerId);
            model.addAttribute("customer" ,customer);
            model.addAttribute("pagetitle", "Edit Customer ( "+ customerId +" )" );
            return "userForm";
        }
        catch (CustomerNotFoundException e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/customers";
        }

    }

    // Delete operation
    @GetMapping("/customers/delete/{customerId}")
    public String deleteCustomerById(@PathVariable("customerId") Integer customerId, RedirectAttributes re)
    {
        try{
            customerService.deleteCustomerById(customerId);
            re.addFlashAttribute("message", "The customer id "  +customerId+ " has been deleted");

        }catch (CustomerNotFoundException e){

            re.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/customers";
    }

    // Update operation
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer customerId)
    {
        return customerService.updateCustomer(customer, customerId);
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "signUpForm";
    }

    @PostMapping("/process_register")
    public String processRegister(Customer customer) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);

        customerService.saveCustomer(customer);

        return "register_success";
    }
}
