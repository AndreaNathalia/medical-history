package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class addPatientUserTest {
    Patient.PatientInformation pat = new Patient.PatientInformation();
    Doctor.DoctorInformation doc1 = new Doctor.DoctorInformation();
    Doctor.DoctorInformation doc2 = new Doctor.DoctorInformation();

    @DataProvider(name = "addDocToPatient")
    public Object[][] doctors() {
        List<Doctor.DoctorInformation> doctors = new ArrayList<>();
        doc1.setEmail("andreareyes@ufm.edu");
        doc2.setEmail("andreanathaliar@gmail.com");
        doctors.add(doc1);
        doctors.add(doc2);

        List<String> doctorsAdded = new ArrayList<>();
        doctorsAdded.add("andreareyes@ufm.edu");
        doctorsAdded.add("andreanathaliar@gmail.com");
        Object[][] retKeyword={{doctorsAdded, doctors}};
        return(retKeyword);
    }
    @Test(dataProvider = "addDocToPatient")
    public void addDocToPatient(List<String> doctorsAdded, List<Doctor.DoctorInformation> doctors) {
        System.out.println("Add doctors to patients");

        for(int i=0; i<doctorsAdded.size(); i++){
            List<Doctor.DoctorInformation> funcDoctors = pat.addDoctorsModel(doctors.get(i));
            System.out.println("Expected > " +doctorsAdded.get(i));
            System.out.println("Actual > " + funcDoctors.get(i).getEmail());
            Assert.assertEquals(doctorsAdded.get(i), funcDoctors.get(i).getEmail());
        }
    }

}
