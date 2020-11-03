package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.security.PublicKey;
import java.util.ArrayList;
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
    public String SignUp(@ModelAttribute(name = "signUp") SignUp signUp,  @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model) throws IOException {
        if(UserType.equals("doctor")){
            Doctor.DoctorInformation.addDoctor(UserType, email, password, model);
            FileOutputStream fos = new FileOutputStream("t.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Doctor.DoctorInformation.getDoctorsList());
            oos.close();
        }

        if(UserType.equals("patient")){
            //System.out.println("xxxxx"+ email);
            Patient.PatientInformation.addPatient(UserType, email, password, model);
        }
        return "LogIn";
    }

    //Log In (check on password and email)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LogIn(@ModelAttribute(name = "logIn") LogIn logIn, @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("t.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Doctor.DoctorInformation.doctorsList = (List<Doctor.DoctorInformation>) ois.readObject();
        ois.close();
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
        if(information.equals("PatientInformation")){
            return "PatientInformation";
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
    public String PatientInformation(@RequestParam(name = "FirstName") String FirstName, @RequestParam(name = "MiddleName") String MiddleName, @RequestParam(name = "LastName") String LastName, @RequestParam(name = "birth") String birth, @RequestParam(name = "gender") String gender, @RequestParam(name = "MaritalStatus") String MaritalStatus, @RequestParam(name = "phone") int phone, @RequestParam(name = "city") String city, @RequestParam(name = "allergies1") String allergies1, @RequestParam(name = "allergies2") String allergies2, @RequestParam(name = "allergies3") String allergies3, @RequestParam(name = "allergies4") String allergies4, @RequestParam(name = "surgery1") String surgery1, @RequestParam(name = "surgery2") String surgery2, @RequestParam(name = "surgery3") String surgery3, @RequestParam(name = "surgery4") String surgery4, Model model){
        Patient.PatientInformation.setFirstName(FirstName);
        Patient.PatientInformation.setMiddleName(MiddleName);
        Patient.PatientInformation.setLastName(LastName);
        Patient.PatientInformation.setBirth(birth);
        Patient.PatientInformation.setGender(gender);
        Patient.PatientInformation.setMaritalStatus(MaritalStatus);
        Patient.PatientInformation.setPhone(phone);
        Patient.PatientInformation.setCity(city);
        Patient.PatientInformation.allergies.add(allergies1);
        Patient.PatientInformation.allergies.add(allergies2);
        Patient.PatientInformation.allergies.add(allergies3);
        Patient.PatientInformation.allergies.add(allergies4);
        Patient.PatientInformation.surgeries.add(surgery1);
        Patient.PatientInformation.surgeries.add(surgery2);
        Patient.PatientInformation.surgeries.add(surgery3);
        Patient.PatientInformation.surgeries.add(surgery4);
        model.addAttribute("FirstName", FirstName);
        model.addAttribute("MiddleName", MiddleName);
        model.addAttribute("LastName", LastName);
        model.addAttribute("FullName", FirstName+" "+ LastName);
        model.addAttribute("birth", birth);
        model.addAttribute("gender", gender);
        model.addAttribute("MaritalStatus", MaritalStatus);
        model.addAttribute("phone", phone);
        model.addAttribute("city", city);
        model.addAttribute("allergies1", allergies1);
        model.addAttribute("allergies2", allergies2);
        model.addAttribute("allergies3", allergies3);
        model.addAttribute("allergies4", allergies4);
        model.addAttribute("surgery1", surgery1);
        model.addAttribute("surgery2", surgery2);
        model.addAttribute("surgery3", surgery3);
        model.addAttribute("surgery4", surgery4);

        //Just to check n the terminal that the data is being saved
        for (int i = 0; i < Patient.PatientInformation.patientsList.size(); i++) {
            System.out.println("\n\n------ PATIENT INFORMATION ------");
            System.out.println("First Name: " + Patient.PatientInformation.patientsList.get(i).getFirstName());
            System.out.println("Middle Name: " + Patient.PatientInformation.patientsList.get(i).getMiddleName());
            System.out.println("Last Name: " + Patient.PatientInformation.patientsList.get(i).getLastName());
            System.out.println("Birth: " + Patient.PatientInformation.patientsList.get(i).getBirth());
            System.out.println("Gender: " + Patient.PatientInformation.patientsList.get(i).getGender());
            System.out.println("Marital Status: " + Patient.PatientInformation.patientsList.get(i).getMaritalStatus());
            System.out.println("Phone: " + Patient.PatientInformation.patientsList.get(i).getPhone());
            System.out.println("City: " + Patient.PatientInformation.patientsList.get(i).getCity());
            System.out.println("Allergies: " + Patient.PatientInformation.patientsList.get(i).getAllergies());
            System.out.println("Surgeries: " + Patient.PatientInformation.patientsList.get(i).getSurgeries());
        }
        System.out.println("------------------------------------");
        return "SeePatientInformation";
    }

    @RequestMapping(value = "/getpatientprofile", method = RequestMethod.GET)
    public String getPatientProfile(){
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
    public String postAddDoctor(@RequestParam(name = "DocName") String DocName, @RequestParam(name = "email") String email, @RequestParam(name = "specialty")String specialty, Model model, @RequestParam(name = "youremail") String mymail) throws IOException, ClassNotFoundException {
        String nid = Patient.PatientInformation.indexfinder(mymail);
        Doctor.DoctorInformation.patientadder(nid,email);
        FileInputStream fis = new FileInputStream("t.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Doctor.DoctorInformation.doctorsList = (List<Doctor.DoctorInformation>) ois.readObject();
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
