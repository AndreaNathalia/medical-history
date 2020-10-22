package com.app.MedicalHistory;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    static class PatientInformation {
        //Attributes
        public static String UserType;
        public static String email;
        public static String password;
        public static String FirstName;
        public static String MiddleName;
        public static String LastName;
        public static String birth;
        public static String gender;
        public static String MaritalStatus;
        public static int phone;
        public static String city;
        static  List<String> allergies = new ArrayList<String>();
        static List<String> surgeries = new ArrayList<String>();
        static List<String> allowedDoctorsNames = new ArrayList<>();
        static List<String> allowedDoctorsSpecialities = new ArrayList<>();

        //Constructor
        PatientInformation(String UserType, String email, String password) {
            this.UserType = UserType;
            this.email = email;
            this.password = password;
        }

        //Get methods
        public static String getUserType() {
            return UserType;
        }

        public static String getEmail() {
            return email;
        }

        public static String getPassword() {
            return password;
        }

        public static String getFirstName() {
            return FirstName;
        }

        public static String getMiddleName() {
            return MiddleName;
        }

        public static String getLastName() {
            return LastName;
        }

        public static String getBirth() {
            return birth;
        }

        public static String getGender() {
            return gender;
        }

        public static String getMaritalStatus() {
            return MaritalStatus;
        }

        public static int getPhone() {
            return phone;
        }

        public static String getCity() {
            return city;
        }

        //Set methods
        public static void setFirstName(String FirstName) {
            PatientInformation.FirstName = FirstName;
        }

        public static void setMiddleName(String MiddleName) {
            PatientInformation.MiddleName = MiddleName;;
        }

        public static void setLastName(String LastName) {
            PatientInformation.LastName = LastName;;
        }

        public static void setBirth(String birth) {
            PatientInformation.birth = birth;;
        }

        public static void setGender(String gender) {
            PatientInformation.gender = gender;;
        }

        public static void setMaritalStatus(String MaritalStatus) {
            PatientInformation.MaritalStatus = MaritalStatus;;
        }

        public static void setPhone(int phone) {
            PatientInformation.phone = phone;;
        }

        public static void setCity(String city) {
            PatientInformation.city = city;;
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

        public static void addDoctors(Doctor.DoctorInformation newDoc, Model model){
            allowedDoctorsNames.add(newDoc.getEmail());
            allowedDoctorsSpecialities.add(newDoc.getUserType());
//            allowedDoctorsNames.add(newDoc.getName());
//            allowedDoctorsSpecialities.add(newDoc.getSpecialty());
            int allowedDoctorsLength = allowedDoctorsNames.size();

            System.out.println("DocName"+ newDoc.getEmail());
            model.addAttribute("allowedDoctorsNames", allowedDoctorsNames);
            model.addAttribute("allowedDoctorsSpecialities", allowedDoctorsSpecialities);
            model.addAttribute("allowedDoctorsLength", allowedDoctorsLength);
        }

    }
}
