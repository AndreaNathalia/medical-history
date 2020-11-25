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
        public String age;
        public String specialty;
        public String clinicAddress;
        public int timeWPatient;
        public int rating;
        public List<Integer> RATINGS = new ArrayList<>();
        public List<String> patients = new ArrayList<>();
        public List<Patient.PatientInformation> allowedPatients = new ArrayList<>();
        public List<String> ments = new ArrayList<>();
        //Week schedule
        public String sMonday;
        public String eMonday;
        public String sTuesday;
        public String eTuesday;
        public String sWednesday;
        public String eWednesday;
        public String sThursday;
        public String eThursday;
        public String sFriday;
        public String eFriday;
        public String sSaturday;
        public String eSaturday;
        public String sSunday;
        public String eSunday;

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
        public String getAge(){
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
        public String getsMonday() {
            return sMonday;
        }
        public String geteMonday() {
            return eMonday;
        }
        public String getsTuesday() {
            return sTuesday;
        }
        public String geteTuesday() {
            return eTuesday;
        }
        public String getsWednesday() {
            return sWednesday;
        }
        public String geteWednesday() {
            return eWednesday;
        }
        public String getsThursday() {
            return sThursday;
        }
        public String geteThursday() {
            return eThursday;
        }
        public String getsFriday() {
            return sFriday;
        }
        public String geteFriday() {
            return eFriday;
        }
        public String getsSaturday() {
            return sSaturday;
        }
        public String geteSaturday() {
            return eSaturday;
        }
        public String getsSunday() {
            return sSunday;
        }
        public String geteSunday() {
            return eSunday;
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
            if(name.equals("")){

            }else{
                this.name = name;
            }
        }
        public void setLastName(String LastName) {
            if(LastName.equals("")){

            }else{
                this.LastName = LastName;
            }
        }
        public void setAge(String age) {
            if(age.equals("")){

            }else{
                this.age = age;
            }
        }
        public void setSpecialty(String specialty) {
            if(specialty.equals("")){

            }else{
                this.specialty = specialty;
            }
        }
        public void setClinicAddress(String clinicAddress) {
            if(clinicAddress.equals("")){

            }else{
                this.clinicAddress = clinicAddress;
            }
        }
        public void setsMonday(String sMonday) {
            if(!sMonday.equals("")){
                this.sMonday = sMonday;
            }
        }
        public void seteMonday(String eMonday) {
            if(!eMonday.equals("")){
                this.eMonday = eMonday;
            }
        }
        public void setsTuesday(String sTuesday) {
            if(!sTuesday.equals("")){
                this.sTuesday = sTuesday;
            }
        }
        public void seteTuesday(String eTuesday) {
            if(!eTuesday.equals("")){
                this.eTuesday = eTuesday;
            }
        }
        public void setsWednesday(String sWednesday) {
            if(!sWednesday.equals("")){
                this.sWednesday = sWednesday;
            }
        }
        public void seteWednesday(String eWednesday) {
            if(!eWednesday.equals("")){
                this.eWednesday = eWednesday;
            }
        }
        public void setsThursday(String sThursday) {
            if(!sThursday.equals("")){
                this.sThursday = sThursday;
            }
        }
        public void seteThursday(String eThursday) {
            if(!eThursday.equals("")){
                this.eThursday = eThursday;
            }
        }
        public void setsFriday(String sFriday) {
            if(!sFriday.equals("")){
                this.sFriday = sFriday;
            }
        }
        public void seteFriday(String eFriday) {
            if(!eFriday.equals("")){
                this.eFriday = eFriday;
            }
        }
        public void setsSaturday(String sSaturday) {
            if(!sSaturday.equals("")){
                this.sSaturday = sSaturday;
            }
        }
        public void seteSaturday(String eSaturday) {
            if(!eSaturday.equals("")){
                this.eSaturday = eSaturday;
            }
        }
        public void setsSunday(String sSunday) {
            if(!sSunday.equals("")){
                this.sSunday = sSunday;
            }
        }
        public void seteSunday(String eSunday) {
            if(!eSunday.equals("")){
                this.eSunday = eSunday;
            }
        }

        public void setMents(String ment) {
            if(ment.equals("")){

            }else{
                this.ments.add(ment);
            }
        }

        public void setTimeWPatient(int timeWPatient) {
            this.timeWPatient = timeWPatient;
        }

        //Rating
        public int addDocPoints(int newPoints){
            this.rating = 0;
            this.RATINGS.add(newPoints);
            for (int i = 0; i < this.RATINGS.size();i++){
                this.rating = this.rating + this.RATINGS.get(i);
            }
            this.rating = this.rating / this.RATINGS.size();
            return this.rating;
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
        public  void patientadder (String index, String email){
            String test2 = email;
            for(int i = 0; i < doctorsList.size(); i++){
                String test = doctorsList.get(i).getEmail();
                if(test.equals(test2)){
                    patients.add(index);
                }
            }
        }
        public List<Patient.PatientInformation> addPatients(Patient.PatientInformation newPatient){
            allowedPatients.add(newPatient);
            return allowedPatients;

        }
        public void addPatientsModel(Model model){
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

        public static String checker (String email, String password){
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
                    }
                }
            }
            return "not true";
        }
        public static void checkerModel(String email, String password, Model model){
            int e = 0;
            for(int i = 0; i < doctorsList.size(); i++){
                String test = doctorsList.get(i).getEmail();
                String test1 = doctorsList.get(i).getPassword();
                if(test.equals(email)){
                    if (password.equals(test1)){
                        e = i;
                    }
                }
            }
            model.addAttribute("FirstName", doctorsList.get(e).getName());
            model.addAttribute("LastName", doctorsList.get(e).getLastName());
            model.addAttribute("Age", doctorsList.get(e).getAge());
            model.addAttribute("Speciality", doctorsList.get(e).getSpecialty());
            model.addAttribute("Address", doctorsList.get(e).getClinicAddress());
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
                    }
                }
            }
            return null;
        }
    }
}
