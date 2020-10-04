package com.app.MedicalHistory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

@Controller
public class Main {
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getSignUpForm(){
        return "SignUp";
    }

    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String SignUp(@ModelAttribute(name = "signUp") SignUp signUp,  @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model){
        SignUp.User.addUser(UserType, email, password, model);
        return "SignUp";
    }

}
