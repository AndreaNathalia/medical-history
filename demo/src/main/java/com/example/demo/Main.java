package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.List;

@Controller
public class Main {

    //Main
    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String mainPage(){
        return "Main";
    }

    //Log In
    @RequestMapping(value="/log", method=RequestMethod.GET)
    public String getLogInForm(){
        return "LogIn";
    }

    @RequestMapping(value="/getsignup", method=RequestMethod.GET)
    public String getSignUpForm(){
        return "SignUp";
    }

    //Sig Up and add new user
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String SignUp(@ModelAttribute(name = "signUp") SignUp signUp,  @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model){
        if(UserType.equals("doctor")){
            Doctor.DoctorInformation.addDoctor(UserType, email, password, model);
        }

        if(UserType.equals("patient")){
            System.out.println("xxxxx"+ email);
            Patient.PatientInformation.addPatient(UserType, email, password, model);
        }

        return "LogIn";
    }

    //Log In (check on password and email)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LogIn(@ModelAttribute(name = "logIn") LogIn logIn, @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model){
        if(UserType.equals("doctor")){
//            System.out.println("check");

            if (Doctor.DoctorInformation.checker(email, password,model).equals("True")){

                return "DoctorProfile";
            } else{
                return "LogIn";
            }
        }

        if(UserType.equals("patient")){
            if (Patient.PatientInformation.checker(email, password,model).equals( "True")){
                return "PatientProfile";
            } else{
                return "LogIn";
            }

        }

        return "LogIn";
    }
    @RequestMapping(value = "/access", method = RequestMethod.POST)
    public String access(@ModelAttribute(name = "patient")  String patient, Model model){
        for (int i = 0 ; i< Doctor.DoctorInformation.patients.size();i++){
            if (Patient.PatientInformation.checker(patient,Doctor.DoctorInformation.patients.get(i),model) == "True"){

                return "PatientProfile";
            }

        }
        return "PatientsEditor";

    };

    //Get to options
    @RequestMapping(value = "/patientprofile", method = RequestMethod.GET)
    public String PatientProfile(@RequestParam(name = "information") String information){
        if(information.equals("PatientInformation1")){
            return "PatientInformation1";
        }

        if(information.equals("PatientsMedications")){
            return "PatientsMedications";
        }

        if(information.equals("ManageAccess")){
            return "ManageAccess";
        }

        return "PatientProfile";
    }

    @RequestMapping(value = "/patientinformation", method = RequestMethod.POST)
    public String PatientInformation(@RequestParam(name = "FirstName") String FirstName, @RequestParam(name = "MiddleName") String MiddleName, @RequestParam(name = "LastName") String LastName, @RequestParam(name = "birth") String birth, @RequestParam(name = "gender") String gender, @RequestParam(name = "MaritalStatus") String MaritalStatus, @RequestParam(name = "phone") int phone, @RequestParam(name = "city") String city,Model model){
        Patient.PatientInformation.setFirstName(FirstName);
        Patient.PatientInformation.setMiddleName(MiddleName);
        Patient.PatientInformation.setLastName(LastName);
        Patient.PatientInformation.setBirth(birth);
        Patient.PatientInformation.setGender(gender);
        Patient.PatientInformation.setMaritalStatus(MaritalStatus);
        Patient.PatientInformation.setPhone(phone);
        Patient.PatientInformation.setCity(city);
        model.addAttribute("FirstName", FirstName);
        model.addAttribute("LastName", LastName);
        model.addAttribute("FullName", FirstName+" "+ LastName);

        for (int i = 0; i < Patient.PatientInformation.patientsList.size(); i++) {
            System.out.println("\n\n------ PATIENT INFORMATION ------");
            System.out.println("\nFirst Name:");
            System.out.println(Patient.PatientInformation.patientsList.get(i).getFirstName());
            System.out.println("\nMiddle Name:");
            System.out.println(Patient.PatientInformation.patientsList.get(i).getMiddleName());
            System.out.println("\nLast Name:");
            System.out.println(Patient.PatientInformation.patientsList.get(i).getLastName());
            System.out.println("\nBirth:");
            System.out.println(Patient.PatientInformation.patientsList.get(i).getBirth());
            System.out.println("\nGender:");
            System.out.println(Patient.PatientInformation.patientsList.get(i).getGender());
            System.out.println("\nMarital Status:");
            System.out.println(Patient.PatientInformation.patientsList.get(i).getMaritalStatus());
            System.out.println("\nPhone:");
            System.out.println(Patient.PatientInformation.patientsList.get(i).getPhone());
            System.out.println("\nCity:");
            System.out.println(Patient.PatientInformation.patientsList.get(i).getCity());
        }
        return "PatientProfile";
    }
    @RequestMapping(value = "/doctorprofile", method = RequestMethod.GET)
    public String DoctorProfile(@RequestParam(name = "information") String information){
        if(information.equals("PatientsEditor")){
            return "PatientsEditor";
        }

        return "DoctorProfile";
    }

    //Manage Access
    @RequestMapping(value="/ManageAccess", method=RequestMethod.GET)
    public String getAddDoctor() {
        return "ManageAccess";
    }

    @RequestMapping(value="/ManageAccess", method=RequestMethod.POST)
    public String postAddDoctor(@RequestParam(name = "DocName") String DocName, @RequestParam(name = "email") String email, @RequestParam(name = "specialty")String specialty, Model model, @RequestParam(name = "youremail") String mymail) {
        String nid = Patient.PatientInformation.indexfinder(mymail);
        Doctor.DoctorInformation.patientadder(nid,email);
        List<Doctor.DoctorInformation> docList = Doctor.DoctorInformation.doctorsList;
        int n = docList.size();
        for(int i=0; i<n; i++){
//            if((DocName == docList.get(i).name) && (email == docList.get(i).email) && (specialty == docList.get(i).specialty)){
            if(email.equals(docList.get(i).getEmail()) ){
                Patient.PatientInformation.addDoctors(docList.get(i), model);
            }
        }
        return "ManageAccess";
    }

}
