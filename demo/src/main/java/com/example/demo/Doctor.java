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
        //Constructor
        DoctorInformation(String UserType, String email, String password){
            this.UserType = UserType;
            this.email = email;
            this.password = password;
        }

        //Set methods
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
        public static void addDoctor(String UserType, String email, String password, Model model){
            doctorsList.add(new DoctorInformation(UserType, email, password));

            for(int i = 0; i < doctorsList.size(); i++){
                System.out.println("\n\n------ DOCTORS LIST ------");
                System.out.println("User Type: " + doctorsList.get(i).getUserType());
                System.out.println("Email: " + doctorsList.get(i).getEmail());
                System.out.println("Password: " + doctorsList.get(i).getPassword());
            }
            System.out.println("--------------------------------");
            model.addAttribute("doctorsList", doctorsList);
        }
        public static void patientadder (String index, String email){
            String test2 = email;
            for(int i = 0; i < doctorsList.size(); i++){
                String test = doctorsList.get(i).getEmail();
                if(test.equals(test2)){
                    patients.add(index);
                };
            };
        };

        public static String checker (String email, String password,Model model){
            String test2 = email;
            String test3 = password;

            int e = 0;
            for(int i = 0; i < doctorsList.size(); i++){
                String test = doctorsList.get(i).getEmail();
                String test1 = doctorsList.get(i).getPassword();
                if(test.equals(test2)){
                    //System.out.println(doctorsList.get(i).getEmail());
                    //System.out.println(doctorsList.get(i).getPassword());
                    if (test3.equals(test1)){
                        //System.out.println(doctorsList.get(i).getEmail());
                        //System.out.println(doctorsList.get(i).getPassword());
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
    }
}
