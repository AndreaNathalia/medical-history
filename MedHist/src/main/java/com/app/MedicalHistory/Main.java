package com.app.MedicalHistory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

@Controller
public class Main {
    @RequestMapping(value="/log", method=RequestMethod.GET)
    public String getLogInForm(){
        return "LogIn";
    }

    @RequestMapping(value="/getsignup", method=RequestMethod.GET)
    public String getSignUpForm(){
        return "SignUp";
    }

    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String SignUp(@ModelAttribute(name = "signUp") SignUp signUp,  @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model){
        if(UserType.equals("doctor")){
            Doctor.DoctorInformation.addDoctor(UserType, email, password, model);
        }

        if(UserType.equals("patient")){
            Patient.PatientInformation.addPatient(UserType, email, password, model);
        }

        return "LogIn";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LogIn(@ModelAttribute(name = "logIn") LogIn logIn, @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model){
        if(UserType.equals("doctor")){
            return "DoctorProfile";
        }

        if(UserType.equals("patient")){
            return "PatientProfile";
        }
        
        return "LogIn";
    }

    @RequestMapping(value="/patient", method=RequestMethod.GET)
    public String getPatientForm() {
        return "PatientProfile";
    }

    @RequestMapping(value="/doctor", method=RequestMethod.GET)
    public String getDoctorForm() {
        return "DoctorProfile";
    }

//    @RequestMapping(value = "/patient", method=RequestMethod.POST)
//    public String PatientForm(@ModelAttribute(name = "signUp") SignUp signUp,  @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model){
//        SignUp.User.addUser(UserType, email, password, model);
//        return "PatientProfile"; // not this
//    }
}
