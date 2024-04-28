package com.example.Controller;


import com.example.Classes.Customer;
import com.example.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServices customerServices;

    @Autowired
    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAddCustomer(@ModelAttribute  Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-customers";
        }

        customerServices.addCustomer(customer);
        return "redirect:/customers";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditCustomerForm(@PathVariable(value = "id") int id, Model model) {
        Customer customer = customerServices.getCustomerById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "edit-customers";
        } else {
            return "redirect:/customers";
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String doEditCustomer(@PathVariable(value = "id") int id, @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-customer";
        }

        customerServices.updateCustomer(id, customer);
        return "redirect:/customers";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id) {
        customerServices.deleteCustomer(id);
        return "redirect:/customers";
    }

    @RequestMapping("")
    public String getAllCustomers(Model model) {
        model.addAttribute("theCustomers", customerServices.getAllCustomers());
        return "customers";
    }
}

