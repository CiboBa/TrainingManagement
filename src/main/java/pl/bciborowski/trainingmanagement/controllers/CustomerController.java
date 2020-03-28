package pl.bciborowski.trainingmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.bciborowski.trainingmanagement.domain.Customer;
import pl.bciborowski.trainingmanagement.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }

    @RequestMapping("/customer/{id}")
    public String getCustomerBy(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer";
    }

    @RequestMapping("/customer/delete/{id}")
    public String getCustomerBy(@PathVariable Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }

    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customerForm";
    }

    @RequestMapping("/customer/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveCustomer(Customer customer) {
        Customer newOne = customerService.save(customer);
        return "redirect:/customer/" + newOne.getId();
    }

    @RequestMapping("/customerPanel")
    public String customerPanel() {
        return "customerPanel";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
