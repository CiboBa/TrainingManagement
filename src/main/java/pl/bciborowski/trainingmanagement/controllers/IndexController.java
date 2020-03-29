package pl.bciborowski.trainingmanagement.controllers;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private String indexMode;

    @Autowired
    public IndexController(Environment environment) {
        indexMode = environment.getProperty("index-mode");
    }

    @RequestMapping("/")
    public String index(Model model) {
//        model.addAttribute("mode", indexMode);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
