package com.example.demo;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class Patient implements Serializable{
    static class PatientInformation implements Serializable {
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
        public String phone;
        public String city;
        public String allergies1;
        public String allergies2;
        public String allergies3;
        public String allergies4;
        public String surgery1;
        public String surgery2;
        public String surgery3;
        public String surgery4;
        public int allowedDoctorsLength;
        public List<Doctor.DoctorInformation> allowedDoctors = new ArrayList<>();
        public List<String> med1 = new ArrayList<>();
        public List<String> med2 = new ArrayList<>();
        public List<String> med3 = new ArrayList<>();
        public List<String> med4 = new ArrayList<>();
        public List<String> med5 = new ArrayList<>();
        public List<String> med6 = new ArrayList<>();
        public List<String> med7 = new ArrayList<>();
        public List<String> med8 = new ArrayList<>();
        public List<String> ments = new ArrayList<>();

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
        public String getPhone() {
            return phone;
        }
        public String getCity() {
            return city;
        }
        public String getAllergies1(){
            return allergies1;
        }
        public String getAllergies2(){
            return allergies2;
        }
        public String getAllergies3(){
            return allergies3;
        }
        public String getAllergies4(){
            return allergies4;
        }
        public String getSurgery1(){
            return surgery1;
        }
        public String getSurgery2(){
            return surgery2;
        }
        public String getSurgery3(){
            return surgery3;
        }
        public String getSurgery4(){
            return surgery4;
        }
        public List<String> getMed1(){
            return med1;
        }
        public List<String> getMed2(){
            return med2;
        }
        public List<String> getMed3(){
            return med3;
        }
        public List<String> getMed4(){
            return med4;
        }
        public List<String> getMed5(){
            return med5;
        }
        public List<String> getMed6(){
            return med6;
        }
        public List<String> getMed7(){
            return med7;
        }
        public List<String> getMed8(){
            return med8;
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
            if(FirstName.equals("")){

            }else{
                this.FirstName = FirstName;
            }
        }
        public void setMiddleName(String MiddleName) {
            if(MiddleName.equals("")){

            }else{
                this.MiddleName = MiddleName;
            }
        }
        public void setLastName(String LastName) {
            if(LastName.equals("")){

            }else{
                this.LastName = LastName;
            }
        }
        public void setBirth(String birth) {
            if(birth.equals("")){

            }else{
                this.birth = birth;
            }
        }
        public void setGender(String gender) {
            if(gender.equals("")){

            }else{
                this.gender = gender;
            }
        }
        public void setMaritalStatus(String MaritalStatus) {
            if(MaritalStatus.equals("")){

            }else{
                this.MaritalStatus = MaritalStatus;
            }
        }
        public void setPhone(String phone) {
            if(phone.equals("")){

            }else{
                this.phone = phone;
            }
        }
        public void setCity(String city) {
            if(!city.equals("")){
                this.city = city;
            }
        }
        public void setAllergies1(String allergies1) {
            if(!allergies1.equals("")){
                this.allergies1 = allergies1;
            }
        }
        public void setAllergies2(String allergies2) {
            if(!allergies2.equals("")){
                this.allergies2 = allergies2;
            }
        }
        public void setAllergies3(String allergies3) {
            if(!allergies3.equals("")){
                this.allergies3 = allergies3;
            }
        }
        public void setAllergies4(String allergies4) {
            if(!allergies4.equals("")){
                this.allergies4 = allergies4;
            }
        }
        public void setSurgery1(String surgery1) {
            if(!surgery1.equals("")){
                this.surgery1 = surgery1;
            }
        }
        public void setSurgery2(String surgery2) {
            if(surgery2.equals("")){

            }else{
                this.surgery2 = surgery2;
            }
        }
        public void setSurgery3(String surgery3) {
            if(surgery3.equals("")){

            }else{
                this.surgery3 = surgery3;
            }
        }
        public void setSurgery4(String surgery4) {
            if(surgery4.equals("")){

            }else{
                this.surgery4 = surgery4;
            }
        }
        public void setMed1(String medName, String dosage, String freq, String reason){
            if(!medName.equals("")) {
                List<String> meds = fillMedList(medName, dosage, freq, reason);
                this.med1 = meds;
            }
        }
        public void setMed2(String medName, String dosage, String freq, String reason){
            if(!medName.equals("")) {
                List<String> meds = fillMedList(medName, dosage, freq, reason);
                this.med2 = meds;
            }
        }
        public void setMed3(String medName, String dosage, String freq, String reason){
            if(!medName.equals("")) {
                List<String> meds = fillMedList(medName, dosage, freq, reason);
                this.med3 = meds;
            }
        }
        public void setMed4(String medName, String dosage, String freq, String reason){
            if(!medName.equals("")) {
                List<String> meds = fillMedList(medName, dosage, freq, reason);
                this.med4 = meds;
            }
        }
        public void setMed5(String medName, String dosage, String freq, String reason){
            if(!medName.equals("")) {
                List<String> meds = fillMedList(medName, dosage, freq, reason);
                this.med5 = meds;
            }
        }
        public void setMed6(String medName, String dosage, String freq, String reason){
            if(!medName.equals("")) {
                List<String> meds = fillMedList(medName, dosage, freq, reason);
                this.med6 = meds;
            }
        }
        public void setMed7(String medName, String dosage, String freq, String reason){
            if(!medName.equals("")) {
                List<String> meds = fillMedList(medName, dosage, freq, reason);
                this.med7 = meds;
            }
        }
        public void setMed8(String medName, String dosage, String freq, String reason){
            if(!medName.equals("")) {
                List<String> meds = fillMedList(medName, dosage, freq, reason);
                this.med8 = meds;
            }
        }

        public void setMents(String ment) {
            if(ment.equals("")){

            }else{
                this.ments.add(ment);
            }
        }

        public List<String> fillMedList(String medName, String dosage, String freq, String reason){
            List<String> meds = new ArrayList<>();
            if(!medName.equals("")){
                meds.add(0,medName);
                meds.add(1,dosage);
                meds.add(2,freq);
                meds.add(3,reason);
            }
            return meds;
        }

        //Patients List
        static List<PatientInformation> patientsList = new ArrayList<PatientInformation>();

        //Method to add a new patient user
        public static void adder(PatientInformation NewUser){
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

            System.out.println("\n\n------ PATIENTS LIST ------");
            for(int x = 0; x < patientsList.size(); x++){
                System.out.println("User Type: " + patientsList.get(x).getUserType());
                System.out.println("Email: " + patientsList.get(x).getEmail());
                System.out.println("Password: " + patientsList.get(x).getPassword());
            }

            System.out.println("--------------------------------");
        }

        //Methods to manage access
        public static String indexfinder(String email){
            for(int i = 0; i < patientsList.size(); i++){
                String test = patientsList.get(i).getEmail();

                if(test.equals(email)){
                    return patientsList.get(i).getPassword();
                };
            };
            return "";
        };

        public void addDoctors(Doctor.DoctorInformation newDoc, Model model){
            allowedDoctors.add(newDoc);
            model.addAttribute("allowedDoctors", allowedDoctors);
        }
        public void deleteDoctors(Doctor.DoctorInformation newDoc){
            int allowedDoctorsLength = allowedDoctors.size();
            String email = newDoc.getEmail();
            for(int i=0; i < allowedDoctorsLength; i++){
                if(email.equals(allowedDoctors.get(i).getEmail())){
                    allowedDoctors.remove(newDoc);
                }
            }
        }

        public static String checker(String email, String password,Model model){
            String test = email;
            String test1 = password;
            int e = 0;

            for(int i = 0; i < patientsList.size(); i++){
                String test2 = patientsList.get(i).getEmail();
                String test3 = patientsList.get(i).getPassword();
                if(test.equals(test2)){
                    if (test3.equals(test1)){
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

        public static String checkerModel(String email, String password){
            String test = email;
            String test1 = password;
            int e = 0;

            for(int i = 0; i < patientsList.size(); i++){
                String test2 = patientsList.get(i).getEmail();
                String test3 = patientsList.get(i).getPassword();
                if(test.equals(test2)){
                    if (test3.equals(test1)){
                        e = i;
                        return "True";
                    };
                };
            };

            return "not true";
        }

        public static PatientInformation returner(String email, String password){
            String test = email;
            String test1 = password;
            for(int i = 0; i < patientsList.size(); i++){
                String test2 = patientsList.get(i).getEmail();
                String test3 = patientsList.get(i).getPassword();
                if(test.equals(test2)){
                    if (test3.equals(test1)){
                        return patientsList.get(i);
                    };
                };
            };
            return null;
        }

    }
}
