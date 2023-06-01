package com.UsersMVC.users.configs;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("users/user");
        registry.addViewController("/admin").setViewName("users/admin");
        registry.addViewController("/login").setViewName("users/auth/login");
        registry.addViewController("/logout").setViewName("redirect:/login?logout");
    }



}