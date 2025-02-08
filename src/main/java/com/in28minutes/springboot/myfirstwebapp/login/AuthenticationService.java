package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {

        Boolean isValidUserName = username.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
//        Boolean isValidUserName = username.equalsIgnoreCase("josephnady");
        Boolean isValidPass = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$");
        return isValidUserName && isValidPass; //if username is empty or the usernmae or pass are wrong you will redirect to login page again

    }


}
