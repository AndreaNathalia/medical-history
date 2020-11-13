package com.example.demo;
import java.io.Serializable;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class Doctor implements Serializable{
    static class DoctorInformation implements Serializable{
        //Attributes
        public String UserType;
        public String email;
        public String password;
        public String name;
        public String LastName;
        public int age;
        public String specialty;
        public String clinicAddress;
        public int timeWPatient;
        public int rating;
        static List<String> patients = new ArrayList<>();
        public List<Patient.PatientInformation> allowedPatients = new ArrayList<>();

        //Constructor
        DoctorInformation(){ }

        //Get methods
        public String getUserType(){
            return UserType;
        }
        public String getEmail(){
            return email;
        }
        public String getPassword(){
            return password;
        }
        public String getName(){
            return name;
        }
        public String getLastName(){
            return LastName;
        }
        public int getAge(){
            return age;
        }
        public String getSpecialty(){
            return specialty;
        }
        public String getClinicAddress(){
            return clinicAddress;
        }
        public int getTimeWPatient(){
            return timeWPatient;
        }
        public int getRating(){
            return rating;
        }

        //Set methods
        public void setUserType(String UserType){
            this.UserType = UserType;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setLastName(String LastName) {
            this.LastName = LastName;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }
        public void setClinicAddress(String clinicAddress) {
            this.clinicAddress = clinicAddress;
        }
        public void setTimeWPatient(int timeWPatient) {
            this.timeWPatient = timeWPatient;
        }

        //Rating
        public int addDocPoints(int newPoints){
            return rating += newPoints;
        }

        //Time of attention
        public int addTimeWPatient(){
            return timeWPatient += 1;
        }
        static List<Integer> patient = new ArrayList<>();

        //Doctors List
        static List<DoctorInformation> doctorsList = new ArrayList<DoctorInformation>();

        public static List<DoctorInformation> getDoctorsList() {
            return doctorsList;
        }

        //Method to add a new doctor user
        public static void adder(DoctorInformation NewUser) {
            int hola = 0;
            for (int i = 0; i < doctorsList.size(); i++) {
                String useremail = NewUser.getEmail();
                if (useremail.equals(doctorsList.get(i).getEmail())) {
                    if (NewUser.getPassword().equals(doctorsList.get(i).getPassword())) {
                        doctorsList.set(i, NewUser);
                        hola = 1;
                    }
                }
            }
            if (hola == 0) {
                doctorsList.add(NewUser);
            }
        }

        //Methods to manage access
        public static void patientadder (String index, String email){
            String test2 = email;
            for(int i = 0; i < doctorsList.size(); i++){
                String test = doctorsList.get(i).getEmail();
                if(test.equals(test2)){
                    patients.add(index);
                };
            };
        }
        public void addPatients(Patient.PatientInformation newPatient, Model model){
            allowedPatients.add(newPatient);
            model.addAttribute("allowedPatients", allowedPatients);

        }
        public void deletePatients(Patient.PatientInformation patient){
            int allowedPatientsLength = allowedPatients.size();
            String email = patient.getEmail();
            for(int i=0; i < allowedPatientsLength; i++){
                if(email.equals(allowedPatients.get(i).getEmail())){
                    allowedPatients.remove(patient);
                }
            }
        }

        public static String checker (String email, String password,Model model){
            String test2 = email;
            String test3 = password;

            int e = 0;
            for(int i = 0; i < doctorsList.size(); i++){
                String test = doctorsList.get(i).getEmail();
                String test1 = doctorsList.get(i).getPassword();
                if(test.equals(test2)){
                    if (test3.equals(test1)){
                        e = i;
                        return "True";
                    };
                };
            };
            model.addAttribute("FirstName", doctorsList.get(e).getName());
            model.addAttribute("LastName", doctorsList.get(e).getLastName());
            model.addAttribute("Age", doctorsList.get(e).getAge());
            model.addAttribute("Speciality", doctorsList.get(e).getSpecialty());
            model.addAttribute("Address", doctorsList.get(e).getClinicAddress());

            return "not true";
        }

        public static DoctorInformation returner(String email, String password){
            String test = email;
            String test1 = password;
            for(int i = 0; i < doctorsList.size(); i++){
                String test2 = doctorsList.get(i).getEmail();
                String test3 = doctorsList.get(i).getPassword();
                if(test.equals(test2)){
                    if (test3.equals(test1)){
                        return doctorsList.get(i);
                    };
                };
            };
            return null;
        }
    }
}
