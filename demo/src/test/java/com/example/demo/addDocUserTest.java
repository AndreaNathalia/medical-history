package com.example.demo;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class addDocUserTest {
    Patient.PatientInformation newPatient1 = new Patient.PatientInformation();
    Patient.PatientInformation newPatient2 = new Patient.PatientInformation();
    Doctor.DoctorInformation doc = new Doctor.DoctorInformation();
    @DataProvider(name = "addPatToDoc")
    public Object[][] patients() {
        List<Patient.PatientInformation> patients = new ArrayList<>();
        newPatient1.setEmail("katherinegarcia@ufm.edu");
        newPatient2.setEmail("patient@mail.com");
        patients.add(newPatient1);
        patients.add(newPatient2);

        List<String> patientsAdded = new ArrayList<>();
        patientsAdded.add("katherinegarcia@ufm.edu");
        patientsAdded.add("patient@mail.com");
        Object[][] retKeyword={{patientsAdded, patients}};
        return(retKeyword);
    }
    @Test(dataProvider = "addPatToDoc")
    public void addPatientToDoc(List<String> patientsAdded, List<Patient.PatientInformation> patients) {
        System.out.println("Add patients to doctors");

        for(int i=0; i<patientsAdded.size(); i++){
            List<Patient.PatientInformation> funcPatients = doc.addPatients(patients.get(i));
            System.out.println("Expected > " +patientsAdded.get(i));
            System.out.println("Actual > " +funcPatients.get(i).getEmail());
            Assert.assertEquals(patientsAdded.get(i), funcPatients.get(i).getEmail());
        }
    }
    @Test(dataProvider = "addPatToDoc")
    public void deletePatientToDoc(List<String> patientsAdded, List<Patient.PatientInformation> patients) {
        System.out.println("Delete patients to doctors");
        int n = patients.size();

        for(int i=0; i<n; i++){
            System.out.println("deleting > "+ patients.get(i).getEmail());
//            doc.deletePatients(patients.get(i));
//            Assert.assertEquals();
        }
    }
}
