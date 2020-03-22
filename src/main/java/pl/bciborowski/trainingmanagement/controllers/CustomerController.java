package pl.bciborowski.trainingmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bciborowski.trainingmanagement.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String getCustomers (Model model){
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }
}
