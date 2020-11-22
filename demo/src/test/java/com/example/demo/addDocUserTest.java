package com.example.demo;


import org.testng.annotations.Test;

import java.util.List;

public class addDocUserTest {
    Patient.PatientInformation newPatient = new Patient.PatientInformation();

    @Test
    public void addPatTest(){
        List<Patient.PatientInformation> listP = Doctor.DoctorInformation.addPatients(newPatient);
    }

    // MISSING
//    ADDER FUNCTION
//    PATIENT ADDER
//    ADD PATIENTS
//    DELETE PATIENTS
}
