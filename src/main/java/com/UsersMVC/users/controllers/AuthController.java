package com.UsersMVC.users.controllers;

<<<<<<< HEAD

=======
import com.UsersMVC.users.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {



    @GetMapping("/login")
    public String loginPage() {
        return "users/auth/login";
    }

}
