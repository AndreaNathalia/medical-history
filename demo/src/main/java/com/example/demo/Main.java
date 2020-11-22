package com.example.demo;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import java.io.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Main {
    //New PATIENT object/user (empty)
    Patient.PatientInformation newUser = new Patient.PatientInformation();

    //New DOCTOR object/user (empty)
    Doctor.DoctorInformation newDoctor = new Doctor.DoctorInformation();

    //Main (web page/homepage)
    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String mainPage(){
        return "main";
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
            newDoctor.setUserType(UserType);
            newDoctor.setEmail(email);
            newDoctor.setPassword(password);
            Doctor.DoctorInformation.adder(newDoctor);
            FileOutputStream fos = new FileOutputStream("doctor.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Doctor.DoctorInformation.getDoctorsList());
            oos.close();
        }

        //Save patient new user
        if(UserType.equals("patient")){
            newUser.setUserType(UserType);
            newUser.setEmail(email);
            newUser.setPassword(password);
            Patient.PatientInformation.adder(newUser);

            FileOutputStream fos = new FileOutputStream("patient.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Patient.PatientInformation.patientsList);
            oos.close();
        }
        return "LogIn";
    }

    //POST Log In (check on password and email)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LogIn(@ModelAttribute(name = "logIn") LogIn logIn, @RequestParam(name = "UserType") String UserType, @RequestParam(name = "email") String email, @RequestParam(name = "password")String password, Model model) throws IOException, ClassNotFoundException {
        //Data Base
        FileInputStream fis = new FileInputStream("doctor.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Doctor.DoctorInformation.doctorsList = (List<Doctor.DoctorInformation>) ois.readObject();
        ois.close();
        FileInputStream fi = new FileInputStream("patient.tmp");
        ObjectInputStream oi = new ObjectInputStream(fi);
        Patient.PatientInformation.patientsList = (List<Patient.PatientInformation>) oi.readObject();
        oi.close();

        //Doctor type
        if(UserType.equals("doctor")){
            //Check pwd and email
            if (Doctor.DoctorInformation.checker(email, password,model).equals("True")){
                newDoctor = Doctor.DoctorInformation.returner(email,password);
                model.addAttribute("name", newDoctor.name);
                model.addAttribute("LastName", newDoctor.LastName);
                model.addAttribute("age", newDoctor.age);
                model.addAttribute("specialty", newDoctor.specialty);
                model.addAttribute("clinicAddress", newDoctor.clinicAddress);
                model.addAttribute("Rating", newDoctor.rating);
                return "DoctorProfile";

            } else{
                return "LogIn";
            }
        }

        //Patient type
        if(UserType.equals("patient")){
            //Check pwd and email
            if (Patient.PatientInformation.checker(email, password,model).equals( "True")){
                newUser = Patient.PatientInformation.returner(email,password);
                model.addAttribute("FirstName", newUser.FirstName);
                model.addAttribute("LastName", newUser.LastName);
                model.addAttribute("birth", newUser.birth);
                model.addAttribute("phone", newUser.phone);
                return "PatientProfile";

            } else{
                return "LogIn";
            }
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
            model.addAttribute("allergies1", newUser.allergies1);
            model.addAttribute("allergies2", newUser.allergies2);
            model.addAttribute("allergies3", newUser.allergies3);
            model.addAttribute("allergies4", newUser.allergies4);
            model.addAttribute("surgery1", newUser.surgery1);
            model.addAttribute("surgery2", newUser.surgery2);
            model.addAttribute("surgery3", newUser.surgery3);
            model.addAttribute("surgery4", newUser.surgery4);

            return "SeePatientInformation";
        }

        if(information.equals("PatientsMedications")){
            model.addAttribute("med1", newUser.med1);
            model.addAttribute("med2", newUser.med2);
            model.addAttribute("med3", newUser.med3);
            model.addAttribute("med4", newUser.med4);
            model.addAttribute("med5", newUser.med5);
            model.addAttribute("med6", newUser.med6);
            model.addAttribute("med7", newUser.med7);
            model.addAttribute("med8", newUser.med8);
            return "SeeMedications";
        }

        if(information.equals("ManageAccess")){
            model.addAttribute("allowedDoctors", newUser.allowedDoctors);
            return "ManageAccess";
        }

        if(information.equals("DoctorSchedule")){
            model.addAttribute("sMonday", newDoctor.getsMonday());
            model.addAttribute("eMonday", newDoctor.geteMonday());
            model.addAttribute("sTuesday", newDoctor.getsTuesday());
            model.addAttribute("eTuesday", newDoctor.geteTuesday());
            model.addAttribute("sWednesday", newDoctor.getsWednesday());
            model.addAttribute("eWednesday", newDoctor.geteWednesday());
            model.addAttribute("sThursday", newDoctor.getsThursday());
            model.addAttribute("eThursday", newDoctor.geteThursday());
            model.addAttribute("sFriday", newDoctor.getsFriday());
            model.addAttribute("eFriday", newDoctor.geteFriday());
            model.addAttribute("sSaturday", newDoctor.getsSaturday());
            model.addAttribute("eSaturday", newDoctor.geteSaturday());
            model.addAttribute("sSunday", newDoctor.getsSunday());
            model.addAttribute("eSunday", newDoctor.geteSunday());
            return "SeeDocSchedule";
        }

        return "PatientProfile";
    }

    //GET to edit patient info
    @RequestMapping(value = "/editpatientinformation", method = RequestMethod.GET)
    public String EditPatientInfo(){
        return "PatientInformation";
    }

    //POST set/modifications in patient information (PATIENT SIDE)
    @RequestMapping(value = "/patientinformation", method = RequestMethod.POST)
    public String PatientInformation(@RequestParam(name = "FirstName") String FirstName, @RequestParam(name = "MiddleName") String MiddleName, @RequestParam(name = "LastName") String LastName, @RequestParam(name = "birth") String birth, @RequestParam(name = "gender") String gender, @RequestParam(name = "MaritalStatus") String MaritalStatus, @RequestParam(name = "phone") String phone, @RequestParam(name = "city") String city, Model model) throws IOException, ClassNotFoundException {
        try{
            newUser.setFirstName(FirstName);
            newUser.setMiddleName(MiddleName);
            newUser.setLastName(LastName);
            newUser.setBirth(birth);
            newUser.setGender(gender);
            newUser.setMaritalStatus(MaritalStatus);
            newUser.setPhone(phone);
            newUser.setCity(city);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Data base
        Patient.PatientInformation.adder(newUser);
        FileOutputStream fos = new FileOutputStream("patient.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Patient.PatientInformation.patientsList);
        oos.close();

        model.addAttribute("FirstName", newUser.FirstName);
        model.addAttribute("MiddleName",newUser. MiddleName);
        model.addAttribute("LastName", newUser.LastName);
        model.addAttribute("FullName", newUser.FirstName+" "+ newUser.LastName);
        model.addAttribute("birth", newUser.birth);
        model.addAttribute("gender", newUser.gender);
        model.addAttribute("MaritalStatus", newUser.MaritalStatus);
        model.addAttribute("phone", newUser.phone);
        model.addAttribute("city", newUser.city);

        //PRINTS Just to check in the terminal if the data is being saved
        System.out.println("\n\n------ PATIENT INFORMATION ------");
        System.out.println("First Name: " + newUser.getFirstName());
        System.out.println("Middle Name: " + newUser.getMiddleName());
        System.out.println("Last Name: " + newUser.getLastName());
        System.out.println("Birth: " + newUser.getBirth());
        System.out.println("Gender: " + newUser.getGender());
        System.out.println("Marital Status: " + newUser.getMaritalStatus());
        System.out.println("Phone: " + newUser.getPhone());
        System.out.println("City: " + newUser.getCity());
        System.out.println("Allergies: ");
        System.out.println(newUser.getAllergies1());
        System.out.println(newUser.getAllergies2());
        System.out.println(newUser.getAllergies3());
        System.out.println(newUser.getAllergies4());
        System.out.println("Surgeries: ");
        System.out.println(newUser.getSurgery1());
        System.out.println(newUser.getSurgery2());
        System.out.println(newUser.getSurgery3());
        System.out.println(newUser.getSurgery4());

        System.out.println("------------------------------------");
        return "PatientProfile";
    }

    //GET to patient profile
    @RequestMapping(value = "/getpatientprofile", method = RequestMethod.GET)
    public String getPatientProfile(Model model){
        model.addAttribute("FirstName", newUser.FirstName);
        model.addAttribute("LastName", newUser.LastName);
        model.addAttribute("birth", newUser.birth);
        model.addAttribute("phone", newUser.phone);
        return "PatientProfile";
    }

    //GET to Manage Access
    @RequestMapping(value="/ManageAccess", method=RequestMethod.GET)
    public String getAddDoctor( Model model) {
        model.addAttribute("allowedDoctors", newUser.allowedDoctors);
        return "ManageAccess";
    }

    //POST manage access
    @RequestMapping(value="/ManageAccess", method=RequestMethod.POST)
    public String postAddDoctor(@RequestParam(name = "DocName") String DocName, @RequestParam(name = "email") String email, @RequestParam(name = "specialty")String specialty, Model model, @RequestParam(name = "youremail") String myEmail, @RequestParam(name="deleteBtn", defaultValue="null", required = false) String deleteEmail) throws IOException, ClassNotFoundException {
        String nid = Patient.PatientInformation.indexfinder(myEmail);

//        load something from DB
        FileInputStream fis = new FileInputStream("doctor.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Doctor.DoctorInformation.doctorsList = (List<Doctor.DoctorInformation>) ois.readObject();

        int nPatient = Patient.PatientInformation.patientsList.size();
        int nDoctor = Doctor.DoctorInformation.doctorsList.size();

        for(int i=0; i< nPatient; i++){
            if(myEmail.equals(Patient.PatientInformation.patientsList.get(i).getEmail())){
                for(int j=0; j< nDoctor; j++){
                    if(email.equals(Doctor.DoctorInformation.doctorsList.get(j).getEmail())){
                        Doctor.DoctorInformation addDoc = Doctor.DoctorInformation.doctorsList.get(j);
                        Patient.PatientInformation addPat = Patient.PatientInformation.patientsList.get(i);
                        //        add doctor to patient profile
                        newUser.addDoctors(addDoc,model);
                        //        add patient to doctor profile
                        Doctor.DoctorInformation.doctorsList.get(j).patientadder(nid,email);
                        Doctor.DoctorInformation.doctorsList.get(j).addPatients(addPat, model);

                        FileOutputStream fos = new FileOutputStream("doctor.tmp");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(Doctor.DoctorInformation.getDoctorsList());
                        oos.close();

                        Patient.PatientInformation.adder(newUser);
                        FileOutputStream foo = new FileOutputStream("patient.tmp");
                        ObjectOutputStream oof = new ObjectOutputStream(foo);
                        oof.writeObject(Patient.PatientInformation.patientsList);
                        oof.close();
                    }
                }
            }
        }
        model.addAttribute("allowedDoctors", newUser.allowedDoctors);
        return "ManageAccess";
    }

    @RequestMapping(value = "/deleteDoctorAccess", method = RequestMethod.GET)
    public String deleteDoctorAccess(@RequestParam(name="subButton")String email, Model model) {
//        delete doctor from patient profile
        for(int i=0; i< newUser.allowedDoctors.size(); i++){
            if(email.equals(newUser.allowedDoctors.get(i).getEmail())){
                Doctor.DoctorInformation docDel = newUser.allowedDoctors.get(i);
                newUser.deleteDoctors(docDel);
            }
        }
        int nDoctor = Doctor.DoctorInformation.doctorsList.size();
        for(int i=0; i<nDoctor; i++){
            if(email.equals(Doctor.DoctorInformation.doctorsList.get(i).getEmail())){

                for(int j = 0; j< Doctor.DoctorInformation.doctorsList.get(i).allowedPatients.size(); j++){
                    if(email.equals(Doctor.DoctorInformation.doctorsList.get(i).allowedPatients.get(j).getEmail())){
                        Patient.PatientInformation patDel = Doctor.DoctorInformation.doctorsList.get(i).allowedPatients.get(j);
                        Doctor.DoctorInformation.doctorsList.get(i).deletePatients(patDel);
                    }
                }
            }
        }
        model.addAttribute("allowedDoctors", newUser.allowedDoctors);
//        delete patient from doctor profile
        return "redirect:/ManageAccess";
    }

    //GET to doctor profile
    @RequestMapping(value = "/getdoctorprofile", method = RequestMethod.GET)
    public String getDoctorProfile(Model model){
        model.addAttribute("name", newDoctor.name);
        model.addAttribute("LastName", newDoctor.LastName);
        model.addAttribute("age", newDoctor.age);
        model.addAttribute("specialty", newDoctor.specialty);
        model.addAttribute("clinicAddress", newDoctor.clinicAddress);
        return "DoctorProfile";
    }

    //GET to edit doctor info
    @RequestMapping(value = "/editdoctorinformation", method = RequestMethod.GET)
    public String EditDoctortInfo(){
        return "EditDocProfile";
    }
    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    public String Rating(@RequestParam(name = "rating") int rating,@RequestParam(name = "rate") String rate,Model model) throws IOException {
        for (int i= 0 ; i< Doctor.DoctorInformation.doctorsList.size();i++){
            if (Doctor.DoctorInformation.doctorsList.get(i).getEmail().equals(rate)){
                System.out.println("SI FUNCIA");
                Doctor.DoctorInformation.doctorsList.get(i).addDocPoints(rating);
            }
        }
        FileOutputStream fos = new FileOutputStream("doctor.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Doctor.DoctorInformation.getDoctorsList());
        oos.close();

        return "redirect:/ManageAccess";
    }

    //POST set/modifications in doctor information
    @RequestMapping(value = "/doctorinformation", method = RequestMethod.POST)
    public String PatientInformation(@RequestParam(name = "name") String name, @RequestParam(name = "LastName") String LastName, @RequestParam(name = "age") String age, @RequestParam(name = "specialty") String specialty, @RequestParam(name = "clinicAddress") String clinicAddress, Model model) throws IOException, ClassNotFoundException {
        try{
            newDoctor.setName(name);
            newDoctor.setLastName(LastName);
            newDoctor.setAge(age);
            newDoctor.setSpecialty(specialty);
            newDoctor.setClinicAddress(clinicAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Data base
        Doctor.DoctorInformation.adder(newDoctor);
        FileOutputStream fos = new FileOutputStream("doctor.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Doctor.DoctorInformation.getDoctorsList());
        oos.close();

        model.addAttribute("name", newDoctor.name);
        model.addAttribute("LastName", newDoctor.LastName);
        model.addAttribute("age", newDoctor.age);
        model.addAttribute("specialty", newDoctor.specialty);
        model.addAttribute("clinicAddress", newDoctor.clinicAddress);
        model.addAttribute("Rating", newDoctor.rating);
        return "DoctorProfile";
    }

    //GET to patients editor
    @RequestMapping(value = "/doctorprofile", method = RequestMethod.GET)
    public String DoctorProfile(@RequestParam(name = "information") String information, Model model){
        if(information.equals("PatientsEditor")){
            model.addAttribute("allowedPatients", newDoctor.allowedPatients);
            return "PatientsEditor";
        }

        if(information.equals("Schedule")){
            return "SetDocSchedule";
        }
        return "DoctorProfile";
    }

    //POST to set doctor schedule
    @RequestMapping(value = "/setschedule", method = RequestMethod.POST)
    public String SetDocSchedule(@RequestParam(name = "sMonday") String sMonday, @RequestParam(name = "eMonday") String eMonday,
                                 @RequestParam(name = "sTuesday") String sTuesday, @RequestParam(name = "eTuesday") String eTuesday,
                                 @RequestParam(name = "sWednesday") String sWednesday, @RequestParam(name = "eWednesday") String eWednesday,
                                 @RequestParam(name = "sThursday") String sThursday, @RequestParam(name = "eThursday") String eThursday,
                                 @RequestParam(name = "sFriday") String sFriday, @RequestParam(name = "eFriday") String eFriday,
                                 @RequestParam(name = "sSaturday") String sSaturday, @RequestParam(name = "eSaturday") String eSaturday,
                                 @RequestParam(name = "sSunday") String sSunday, @RequestParam(name = "eSunday") String eSunday, Model model) throws IOException, ClassNotFoundException{

        try{
            newDoctor.setsMonday(sMonday.toString());
            newDoctor.seteMonday(eMonday.toString());
            newDoctor.setsTuesday(sTuesday.toString());
            newDoctor.seteTuesday(eTuesday.toString());
            newDoctor.setsWednesday(sWednesday.toString());
            newDoctor.seteWednesday(eWednesday.toString());
            newDoctor.setsThursday(sThursday.toString());
            newDoctor.seteThursday(eThursday.toString());
            newDoctor.setsFriday(sFriday.toString());
            newDoctor.seteFriday(eFriday.toString());
            newDoctor.setsSaturday(sSaturday.toString());
            newDoctor.seteSaturday(eSaturday.toString());
            newDoctor.setsSunday(sSunday.toString());
            newDoctor.seteSunday(eSunday.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Data base
        Doctor.DoctorInformation.adder(newDoctor);
        FileOutputStream fos = new FileOutputStream("doctor.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Doctor.DoctorInformation.getDoctorsList());
        oos.close();

        model.addAttribute("name", newDoctor.name);
        model.addAttribute("LastName", newDoctor.LastName);
        model.addAttribute("age", newDoctor.age);
        model.addAttribute("specialty", newDoctor.specialty);
        model.addAttribute("clinicAddress", newDoctor.clinicAddress);

        return "DoctorProfile";
    }

    //GET to edit patient info (DOCTOR SIDE)
    @RequestMapping(value = "/doceditpatientinformation", method = RequestMethod.GET)
    public String DocEditPatientInfo(Model model){
        model.addAttribute("FirstName", newUser.FirstName);
        model.addAttribute("MiddleName", newUser.MiddleName);
        model.addAttribute("LastName", newUser.LastName);
        model.addAttribute("FullName", newUser.FirstName+" "+ newUser.LastName);
        model.addAttribute("birth", newUser.birth);
        model.addAttribute("gender", newUser.gender);
        model.addAttribute("MaritalStatus", newUser.MaritalStatus);
        model.addAttribute("phone", newUser.phone);
        model.addAttribute("city", newUser.city);
        return "EditPatientInfo";
    }

    //POST set/modifications in patient information (DOCTOR SIDE)
    @RequestMapping(value = "/doctorediting", method = RequestMethod.POST)
    public String DoctorEditingPatientInfo(@RequestParam(name = "allergies1") String allergies1,
                                           @RequestParam(name = "allergies2") String allergies2,
                                           @RequestParam(name = "allergies3") String allergies3,
                                           @RequestParam(name = "allergies4") String allergies4,
                                           @RequestParam(name = "surgery1") String surgery1,
                                           @RequestParam(name = "surgery2") String surgery2,
                                           @RequestParam(name = "surgery3") String surgery3,
                                           @RequestParam(name = "surgery4") String surgery4,
                                           Model model) throws IOException, ClassNotFoundException {
        try{
            newUser.setAllergies1(allergies1);
            newUser.setAllergies2(allergies2);
            newUser.setAllergies3(allergies3);
            newUser.setAllergies4(allergies4);
            newUser.setSurgery1(surgery1);
            newUser.setSurgery2(surgery2);
            newUser.setSurgery3(surgery3);
            newUser.setSurgery4(surgery4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Data base
        Patient.PatientInformation.adder(newUser);
        FileOutputStream fos = new FileOutputStream("patient.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Patient.PatientInformation.patientsList);
        oos.close();

        model.addAttribute("allergies1", allergies1);
        model.addAttribute("allergies2", allergies2);
        model.addAttribute("allergies3", allergies3);
        model.addAttribute("allergies4", allergies4);
        model.addAttribute("surgery1", surgery1);
        model.addAttribute("surgery2", surgery2);
        model.addAttribute("surgery3", surgery3);
        model.addAttribute("surgery4", surgery4);

        model.addAttribute("name", newDoctor.name);
        model.addAttribute("LastName", newDoctor.LastName);
        model.addAttribute("age", newDoctor.age);
        model.addAttribute("specialty", newDoctor.specialty);
        model.addAttribute("clinicAddress", newDoctor.clinicAddress);
        model.addAttribute("Rating", newDoctor.rating);
//        patientsList
        model.addAttribute("allowedPatients", newDoctor.allowedPatients);

        return "PatientsEditor";
    }

    //GET to edit patient medications info (DOCTOR SIDE)
    @RequestMapping(value = "/doceditpatientmedications", method = RequestMethod.GET)
    public String DocEditPatientMeds(Model model){
        model.addAttribute("med1", newUser.med1);
        model.addAttribute("med2", newUser.med2);
        model.addAttribute("med3", newUser.med3);
        model.addAttribute("med4", newUser.med4);
        model.addAttribute("med5", newUser.med5);
        model.addAttribute("med6", newUser.med6);
        model.addAttribute("med7", newUser.med7);
        model.addAttribute("med8", newUser.med8);
        return "PatientsMedications";
    }

    //POST set/modifications in patient medications (DOCTOR SIDE)
    @RequestMapping(value = "/doctoreditingmeds", method = RequestMethod.POST)
    public String DoctorEditingPatientMeds(@RequestParam(name = "M1") String M1, @RequestParam(name = "D1") String D1, @RequestParam(name = "F1") String F1, @RequestParam(name = "R1") String R1,
                                           @RequestParam(name = "M2") String M2, @RequestParam(name = "D2") String D2, @RequestParam(name = "F2") String F2, @RequestParam(name = "R2") String R2,
                                           @RequestParam(name = "M3") String M3, @RequestParam(name = "D3") String D3, @RequestParam(name = "F3") String F3, @RequestParam(name = "R3") String R3,
                                           @RequestParam(name = "M4") String M4, @RequestParam(name = "D4") String D4, @RequestParam(name = "F4") String F4, @RequestParam(name = "R4") String R4,
                                           @RequestParam(name = "M5") String M5, @RequestParam(name = "D5") String D5, @RequestParam(name = "F5") String F5, @RequestParam(name = "R5") String R5,
                                           @RequestParam(name = "M6") String M6, @RequestParam(name = "D6") String D6, @RequestParam(name = "F6") String F6, @RequestParam(name = "R6") String R6,
                                           @RequestParam(name = "M7") String M7, @RequestParam(name = "D7") String D7, @RequestParam(name = "F7") String F7, @RequestParam(name = "R7") String R7,
                                           @RequestParam(name = "M8") String M8, @RequestParam(name = "D8") String D8, @RequestParam(name = "F8") String F8, @RequestParam(name = "R8") String R8,
                                           Model model) throws IOException, ClassNotFoundException {
        //Set Meds
        System.out.println(M1);
        try{
            newUser.setMed1(M1,D1,F1,R1);
            newUser.setMed2(M2,D2,F2,R2);
            newUser.setMed3(M3,D3,F3,R3);
            newUser.setMed4(M4,D4,F4,R4);
            newUser.setMed5(M5,D5,F5,R5);
            newUser.setMed6(M6,D6,F6,R6);
            newUser.setMed7(M7,D7,F7,R7);
            newUser.setMed8(M8,D8,F8,R8);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Data base
        Patient.PatientInformation.adder(newUser);
        FileOutputStream fos = new FileOutputStream("patient.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Patient.PatientInformation.patientsList);
        oos.close();

//        Lists
        model.addAttribute("med1", newUser.med1);
        model.addAttribute("med2", newUser.med2);
        model.addAttribute("med3", newUser.med3);
        model.addAttribute("med4", newUser.med4);
        model.addAttribute("med5", newUser.med5);
        model.addAttribute("med6", newUser.med6);
        model.addAttribute("med7", newUser.med7);
        model.addAttribute("med8", newUser.med8);

        model.addAttribute("name", newDoctor.name);
        model.addAttribute("LastName", newDoctor.LastName);
        model.addAttribute("age", newDoctor.age);
        model.addAttribute("specialty", newDoctor.specialty);
        model.addAttribute("clinicAddress", newDoctor.clinicAddress);
        model.addAttribute("Rating", newDoctor.rating);

        //        patientsList
        model.addAttribute("allowedPatients", newDoctor.allowedPatients);

        return "PatientsEditor";
    }

    //Patients access
    @RequestMapping(value = "/access", method = RequestMethod.POST)
    public String access(@ModelAttribute(name = "patient")  String patient, @RequestParam(name = "path") String path, Model model){
        for (int i = 0 ; i< newDoctor.patients.size();i++){
            if (Patient.PatientInformation.checker(patient,newDoctor.patients.get(i),model).equals("True")){
                newUser = Patient.PatientInformation.returner(patient,newDoctor.patients.get(i));
            }
            System.out.println(newDoctor.patients.get(i));
        }
        if (path.equals("info")){
            model.addAttribute("FirstName", newUser.FirstName);
            model.addAttribute("MiddleName", newUser.MiddleName);
            model.addAttribute("LastName", newUser.LastName);
            model.addAttribute("FullName", newUser.FirstName+" "+ newUser.LastName);
            model.addAttribute("birth", newUser.birth);
            model.addAttribute("gender", newUser.gender);
            model.addAttribute("MaritalStatus", newUser.MaritalStatus);
            model.addAttribute("phone", newUser.phone);
            model.addAttribute("city", newUser.city);
            return "EditPatientInfo";
        }
        else{
            System.out.println(newUser.med1);
            System.out.println(newUser.med2);
            model.addAttribute("med1", newUser.med1);
            model.addAttribute("med2", newUser.med2);
            model.addAttribute("med3", newUser.med3);
            model.addAttribute("med4", newUser.med4);
            model.addAttribute("med5", newUser.med5);
            model.addAttribute("med6", newUser.med6);
            model.addAttribute("med7", newUser.med7);
            model.addAttribute("med8", newUser.med8);

            return "PatientsMedications";
        }
    }

    @RequestMapping(value = "/testeradder", method = RequestMethod.GET)
    public String testeradder() throws IOException, ClassNotFoundException {
        Patient.PatientInformation.adder(newUser);
        return "PatientProfile";
    }

    //CLEANER
    @RequestMapping(value = "/cleaner", method = RequestMethod.GET)
    public String cleaner() throws IOException {
        Patient.PatientInformation.patientsList = new ArrayList<Patient.PatientInformation>();
        Doctor.DoctorInformation.doctorsList = new ArrayList<Doctor.DoctorInformation>();
        FileOutputStream fos = new FileOutputStream("doctor.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Doctor.DoctorInformation.doctorsList);
        oos.close();
        FileOutputStream fs = new FileOutputStream("patient.tmp");
        ObjectOutputStream so = new ObjectOutputStream(fs);
        so.writeObject(Patient.PatientInformation.patientsList);
        so.close();
        return "PatientProfile";
    }

}
