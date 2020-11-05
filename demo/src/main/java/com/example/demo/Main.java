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
    //New object/user (empty)
    Patient.PatientInformation newUser = new Patient.PatientInformation();

    //Main (web page/homepage)
    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String mainPage(){
        return "Main";
    }

    //GET Log In
    @RequestMapping(value="/log", method=RequestMethod.GET)
    public String getLogInForm(){

        return "LogIn";
    }

    //GET Sign up
    @RequestMapping(value="/getsignup", method=RequestMethod.GET)
    public String getSignUpForm(){
        return "SignUp";
    }

    //Sig Up and add new user (POST new user)
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String SignUp(@ModelAttribute(name = "signUp") SignUp signUp,  @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model) throws IOException {
        //Save doctor new user
        if(UserType.equals("doctor")){
            Doctor.DoctorInformation.addDoctor(UserType, email, password, model);
            FileOutputStream fos = new FileOutputStream("t.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Doctor.DoctorInformation.getDoctorsList());
            oos.close();
        }

        //Save patient new user ----(not yet)----
        if(UserType.equals("patient")){
            //Patient.PatientInformation.addPatient(UserType, email, password, model);
            System.out.println("added");
        }
        return "LogIn";
    }

    //POST Log In (check on password and email)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LogIn(@ModelAttribute(name = "logIn") LogIn logIn, @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model) throws IOException, ClassNotFoundException {
        //Data Base
        FileInputStream fis = new FileInputStream("t.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Doctor.DoctorInformation.doctorsList = (List<Doctor.DoctorInformation>) ois.readObject();
        ois.close();

        //Doctor type
        if(UserType.equals("doctor")){
            //Check pwd and email
            if (Doctor.DoctorInformation.checker(email, password,model).equals("True")){
                return "DoctorProfile";

            } else{
                return "LogIn";
            }
        }

        //Patient type
        if(UserType.equals("patient")){
            //Set/modify type, email and pwd
            newUser.setUserType(UserType);
            newUser.setEmail(email);
            newUser.setPassword(password);

            return "PatientProfile";

            //Check pwd and email
//            if (Patient.PatientInformation.checker(email, password,model).equals( "True")){
//                return "PatientProfile";

//            } else{
//                return "LogIn";
//            }
        }
        return "LogIn";
    }

    //GET to patient menu options
    @RequestMapping(value = "/patientprofile", method = RequestMethod.GET)
    public String PatientProfile(@RequestParam(name = "information") String information, Model model){
        if(information.equals("PatientInformation")){
            model.addAttribute("FirstName", newUser.FirstName);
            model.addAttribute("MiddleName", newUser.MiddleName);
            model.addAttribute("LastName", newUser.LastName);
            model.addAttribute("FullName", newUser.FirstName+" "+ newUser.LastName);
            model.addAttribute("birth", newUser.birth);
            model.addAttribute("gender", newUser.gender);
            model.addAttribute("MaritalStatus", newUser.MaritalStatus);
            model.addAttribute("phone", newUser.phone);
            model.addAttribute("city", newUser.city);
            for(int allergy = 0; allergy < newUser.allergies.size(); allergy++){
                model.addAttribute("allergies1", newUser.allergies.get(0));
                model.addAttribute("allergies2", newUser.allergies.get(1));
                model.addAttribute("allergies3", newUser.allergies.get(2));
                model.addAttribute("allergies4", newUser.allergies.get(3));
            }

            for(int surgery = 0; surgery < newUser.surgeries.size(); surgery++){
                model.addAttribute("surgery1", newUser.surgeries.get(0));
                model.addAttribute("surgery2", newUser.surgeries.get(1));
                model.addAttribute("surgery3", newUser.surgeries.get(2));
                model.addAttribute("surgery4", newUser.surgeries.get(3));
            }
            return "SeePatientInformation";
        }

        if(information.equals("PatientsMedications")){
            return "PatientsMedications";
        }

        if(information.equals("ManageAccess")){
            return "ManageAccess";
        }

        return "PatientProfile";
    }

    //GET to edit patient info
    @RequestMapping(value = "/editpatientinformation", method = RequestMethod.GET)
    public String EditPatientInfo(){
        return "PatientInformation";
    }

    //POST set/modifications in patient information
    @RequestMapping(value = "/patientinformation", method = RequestMethod.POST)
    public String PatientInformation(@RequestParam(name = "FirstName") String FirstName, @RequestParam(name = "MiddleName") String MiddleName, @RequestParam(name = "LastName") String LastName, @RequestParam(name = "birth") String birth, @RequestParam(name = "gender") String gender, @RequestParam(name = "MaritalStatus") String MaritalStatus, @RequestParam(name = "phone") int phone, @RequestParam(name = "city") String city, @RequestParam(name = "allergies1") String allergies1, @RequestParam(name = "allergies2") String allergies2, @RequestParam(name = "allergies3") String allergies3, @RequestParam(name = "allergies4") String allergies4, @RequestParam(name = "surgery1") String surgery1, @RequestParam(name = "surgery2") String surgery2, @RequestParam(name = "surgery3") String surgery3, @RequestParam(name = "surgery4") String surgery4, Model model){
        newUser.setFirstName(FirstName);
        newUser.setMiddleName(MiddleName);
        newUser.setLastName(LastName);
        newUser.setBirth(birth);
        newUser.setGender(gender);
        newUser.setMaritalStatus(MaritalStatus);
        newUser.setPhone(phone);
        newUser.setCity(city);
        newUser.allergies.add(allergies1);
        newUser.allergies.add(allergies2);
        newUser.allergies.add(allergies3);
        newUser.allergies.add(allergies4);
        newUser.surgeries.add(surgery1);
        newUser.surgeries.add(surgery2);
        newUser.surgeries.add(surgery3);
        newUser.surgeries.add(surgery4);

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

        //PRINTS Just to check in the terminal that the data is being saved
        System.out.println("\n\n------ PATIENT INFORMATION ------");
        System.out.println("First Name: " + newUser.getFirstName());
        System.out.println("Middle Name: " + newUser.getMiddleName());
        System.out.println("Last Name: " + newUser.getLastName());
        System.out.println("Birth: " + newUser.getBirth());
        System.out.println("Gender: " + newUser.getGender());
        System.out.println("Marital Status: " + newUser.getMaritalStatus());
        System.out.println("Phone: " + newUser.getPhone());
        System.out.println("City: " + newUser.getCity());
        System.out.println("Allergies: " + newUser.getAllergies());
        System.out.println("Surgeries: " + newUser.getSurgeries());

        System.out.println("------------------------------------");
        return "PatientProfile";
    }

    //GET to patient profile
    @RequestMapping(value = "/getpatientprofile", method = RequestMethod.GET)
    public String getPatientProfile(){
        return "PatientProfile";
    }

    //GET to Manage Access
    @RequestMapping(value="/ManageAccess", method=RequestMethod.GET)
    public String getAddDoctor() {
        return "ManageAccess";
    }

    //POST manage access
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

    //GET to patients editor
    @RequestMapping(value = "/doctorprofile", method = RequestMethod.GET)
    public String DoctorProfile(@RequestParam(name = "information") String information){
        if(information.equals("PatientsEditor")){
            return "PatientsEditor";
        }
        return "DoctorProfile";
    }

    //Patients access
    @RequestMapping(value = "/access", method = RequestMethod.POST)
    public String access(@ModelAttribute(name = "patient")  String patient, Model model){
        for (int i = 0 ; i< Doctor.DoctorInformation.patients.size();i++){
            if (Patient.PatientInformation.checker(patient,Doctor.DoctorInformation.patients.get(i),model) == "True"){
                return "PatientProfile";
            }
        }
        return "PatientsEditor";
    };
    @RequestMapping(value = "/testeradder", method = RequestMethod.GET)
    public void testeradder() throws IOException, ClassNotFoundException {

        Patient.PatientInformation.adder(newUser);
        FileInputStream fis = new FileInputStream("e.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Patient.PatientInformation.patientsList = (List<Patient.PatientInformation>) ois.readObject();


    }
}
