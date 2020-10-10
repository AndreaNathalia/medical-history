package com.app.MedicalHistory;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    static class DoctorInformation{
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

        //Constructor
        DoctorInformation(String UserType, String email, String password){
            this.UserType = UserType;
            this.email = email;
            this.password = password;
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

        //Rating
        public int addDocPoints(int newPoints){
            return rating += newPoints;
        }

        //Time of attention
        public int addTimeWPatient(){
            return timeWPatient += 1;
        }

        //Doctors List
        static List<DoctorInformation> doctorsList = new ArrayList<DoctorInformation>();

        //Method to add a new doctor user
        public static void addDoctor(String UserType, String email, String password, Model model){
            doctorsList.add(new DoctorInformation(UserType, email, password));

            for(int i = 0; i < doctorsList.size(); i++){
                System.out.println("LISTA: Doctores");
                System.out.println("\nType:");
                System.out.println(doctorsList.get(i).getUserType());
                System.out.println("\nEmail:");
                System.out.println(doctorsList.get(i).getEmail());
                System.out.println("\nPwd:");
                System.out.println(doctorsList.get(i).getPassword());
            }

            model.addAttribute("doctorsList", doctorsList);
        }


    }
}
