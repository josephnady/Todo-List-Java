package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.in28minutes.springboot.myfirstwebapp.login.AuthenticationService;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam("username") String username,@RequestParam("password") String password, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);

        if (authenticationService.authenticate(username, password))
            return "welcome";
        else {
            model.addAttribute("errorMessage", "Invalid Credentials!, please review again");
            logger.info("Invalid Credentials!, please review again");
            return "login";
        }
    }

}
