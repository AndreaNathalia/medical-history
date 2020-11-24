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
        patients.add(newPatient1);
        patients.add(newPatient2);

        List<String> patientsAdded = new ArrayList<>();
        patientsAdded.add("katherinegarcia@ufm.edu");
        patientsAdded.add("patient@mail.com");
        Object[][] retKeyword={{patientsAdded, patients},
                {patientsAdded, patients} };
        return(retKeyword);
    }
    @Test(dataProvider = "addPatToDoc")
    public void addPatientToDoc(List<String> patientsAdded, List<Patient.PatientInformation> patients) {
        System.out.println("Check doctor");
        Iterator e = patientsAdded.iterator();
        Iterator p = patients.iterator();

        while(e.hasNext() && p.hasNext())
        {
            String mail=(String)e.next();
            Object pass= p.next();

//            List<Patient.PatientInformation> funcPatients = doc.addPatients(pass);

            System.out.println("email: "+mail +" pass: "+ pass);
//            Assert.assertEquals(keyword,result);
        }
        for(int i=0; i<patientsAdded.size(); i++){
//            List<Patient.PatientInformation> funcPatients = doc.addPatients(patients.get(i));
//            Assert.assertEquals(patientsAdded.get(i), patientsAdded.get(i));

        }
    }

//    @Test
//    public void addPatTest(){
//        List<Patient.PatientInformation> listP = Doctor.DoctorInformation.addPatients(newPatient);
//    }

    // MISSING
//    ADDER FUNCTION
//    PATIENT ADDER
//    ADD PATIENTS
//    DELETE PATIENTS
}
