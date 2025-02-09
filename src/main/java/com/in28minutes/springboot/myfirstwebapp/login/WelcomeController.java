package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("username")
public class WelcomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    /*Version 2*/
    @GetMapping(value = "/")
    public String goToWelcomePage(Model model) {
        model.addAttribute("username", "Josephnady@gmail.com");
        return "welcome";
    }
    
    /*Version 1*/
//    private final AuthenticationService authenticationService;
//    public WelcomeController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//    
//    @GetMapping(value = "/")
//    public String goToLoginPage() {
//        return "login";
//    }
//    
//    @PostMapping(value = "/")
//    public String goToWelcomePage(@RequestParam("username") String username,
//                                  @RequestParam("password") String password,
//                                  Model model) {
//        model.addAttribute("username", username);
//
//        if (authenticationService.authenticate(username, password))
//            return "welcome";
//        else {
//            model.addAttribute("errorMessage", "Invalid Credentials!, please review again");
//            logger.info("Invalid Credentials!, please review again");
//            return "login";
//        }
//    }

}
