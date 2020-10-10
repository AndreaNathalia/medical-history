package com.app.MedicalHistory;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    static class PatientInformation {
        //Attributes
        public String UserType;
        public String email;
        public String password;
        public String FirstName;
        public String MiddleName;
        public String LastName;
        public String birth;
        public String gender;
        public String MaritalStatus;
        public int phone;
        public String city;

        //Constructor
        PatientInformation(String UserType, String email, String password) {
            this.UserType = UserType;
            this.email = email;
            this.password = password;
        }

        //Get methods
        public String getUserType() {
            return UserType;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getFirstName() {
            return FirstName;
        }

        public String getMiddleName() {
            return MiddleName;
        }

        public String getLastName() {
            return LastName;
        }

        public String getBirth() {
            return birth;
        }

        public String getGender() {
            return gender;
        }

        public String getMaritalStatus() {
            return MaritalStatus;
        }

        public int getPhone() {
            return phone;
        }

        public String getCity() {
            return city;
        }

        //Set methods
        public void setFirstName(String FirstName) {
            this.FirstName = FirstName;
        }

        //Set methods
        public void setMiddleName(String MiddleName) {
            this.MiddleName = MiddleName;
        }

        public void setLastName(String LastName) {
            this.LastName = LastName;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setMaritalStatus(String MaritalStatus) {
            this.MaritalStatus = MaritalStatus;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public void setCity(String city) {
            this.city = city;
        }

        //Patients List
        static List<PatientInformation> patientsList = new ArrayList<PatientInformation>();

        //Method to add a new patient user
        public static void addPatient(String UserType, String email, String password, Model model) {
            patientsList.add(new PatientInformation(UserType, email, password));

            for (int i = 0; i < patientsList.size(); i++) {
                System.out.println("LISTA: Pacientes");
                System.out.println("\nType:");
                System.out.println(patientsList.get(i).getUserType());
                System.out.println("\nEmail:");
                System.out.println(patientsList.get(i).getEmail());
                System.out.println("\nPwd:");
                System.out.println(patientsList.get(i).getPassword());
            }

            model.addAttribute("patientsList", patientsList);

        }
    }
}
