package com.example.demo;

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
        public List<String> allergies = new ArrayList<String>();
        public List<String> surgeries = new ArrayList<String>();
        static List<String> allowedDoctorsNames = new ArrayList<>();
        static List<String> allowedDoctorsSpecialities = new ArrayList<>();

        //Constructor
        PatientInformation() { }

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

        public List<String> getAllergies(){
            return allergies;
        }

        public List<String> getSurgeries(){
            return surgeries;
        }

        //Set methods
        public void setUserType(String UserType) {
            this.UserType = UserType;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setFirstName(String FirstName) {
            this.FirstName = FirstName;
        }

        public void setMiddleName(String MiddleName) {
            this.MiddleName = MiddleName;;
        }

        public void setLastName(String LastName) {
            this.LastName = LastName;;
        }

        public void setBirth(String birth) {
            this.birth = birth;;
        }

        public void setGender(String gender) {
            this.gender = gender;;
        }

        public void setMaritalStatus(String MaritalStatus) {
            this.MaritalStatus = MaritalStatus;;
        }

        public void setPhone(int phone) {
            this.phone = phone;;
        }

        public void setCity(String city) {
            this.city = city;;
        }

        //Patients List
        static List<PatientInformation> patientsList = new ArrayList<PatientInformation>();

        //Method to add a new patient user
        public static void addPatient(String UserType, String email, String password, Model model) {
            //patientsList.add(new PatientInformation(UserType, email, password));
            System.out.println("\n\n------ PATIENTS LIST ------");
            for (int i = 0; i < patientsList.size(); i++) {

                System.out.println("User Type: " + patientsList.get(i).getUserType());
                System.out.println("Email: " + patientsList.get(i).getEmail());
                System.out.println("Password: " + patientsList.get(i).getPassword());
            }
            System.out.println("--------------------------------");
            model.addAttribute("patientsList", patientsList);

        }

        public static String indexfinder(String email){
            for(int i = 0; i < patientsList.size(); i++){
                String test = patientsList.get(i).getEmail();

                if(test.equals(email)){
                    return patientsList.get(i).getPassword();
                };
            };
            return "";
        };

        public static void addDoctors(Doctor.DoctorInformation newDoc, Model model){
            allowedDoctorsNames.add(newDoc.getEmail());
            allowedDoctorsSpecialities.add(newDoc.getUserType());
//            allowedDoctorsNames.add(newDoc.getName());
//            allowedDoctorsSpecialities.add(newDoc.getSpecialty());
            int allowedDoctorsLength = allowedDoctorsNames.size();

            //System.out.println("DocName"+ newDoc.getEmail());
            model.addAttribute("allowedDoctorsNames", allowedDoctorsNames);
            model.addAttribute("allowedDoctorsSpecialities", allowedDoctorsSpecialities);
            model.addAttribute("allowedDoctorsLength", allowedDoctorsLength);
        }
        public static String checker (String email, String password,Model model){
            String test = email;
            String test1 = password;
//            System.out.println("ooooooooooooooooo"+ patientsList.get(0).getEmail()+patientsList.get(1).getEmail()+patientsList.get(0).getPassword()+patientsList.get(1).getPassword());
            int e = 0;
            for(int i = 0; i < patientsList.size(); i++){
                String test2 = patientsList.get(i).getEmail();
                String test3 = patientsList.get(i).getPassword();
                if(test.equals(test2)){
                    //System.out.println(patientsList.get(i).getEmail());
                    //System.out.println(patientsList.get(i).getPassword());
                    if (test3.equals(test1)){
                        //System.out.println(patientsList.get(i).getEmail());
                        //System.out.println(patientsList.get(i).getPassword());
                        e = i;
                        return "True";
                    };
                };
            };
            model.addAttribute("FirstName", patientsList.get(e).getFirstName());
            model.addAttribute("LastName", patientsList.get(e).getLastName());
            model.addAttribute("FullName", patientsList.get(e).getFirstName()+" "+ patientsList.get(e).getLastName());

            return "not true";
        }
        public static  void adder (PatientInformation NewUser){
            int key = 0;
            for (int i= 0; i< patientsList.size();i++){
                String useremail = NewUser.getEmail();
                if (useremail.equals(patientsList.get(i).getEmail()) ){
                    if(NewUser.getPassword().equals(patientsList.get(i).getPassword())){
                        patientsList.set(i,NewUser);
                        key = 1;
                    }
                    patientsList.set(i,NewUser);
                    key = 1;
                }
            }
            if (key == 0){
                patientsList.add(NewUser);
            }


        }

    }
}
