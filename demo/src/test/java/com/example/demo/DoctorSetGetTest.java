package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DoctorSetGetTest {
    Doctor.DoctorInformation doc = new Doctor.DoctorInformation();

    @Test
    @Parameters({"NewPoints"})
    public void pointsTest(int NewPoints) {
        int points = doc.addDocPoints(NewPoints);
        Assert.assertEquals(points,5);
    }

    @Test
    @Parameters({"lastName"})
    public void lastNameTest(String lastName) {
        doc.setLastName(lastName);
        String LastNAme = doc.getLastName();
        Assert.assertEquals(lastName, LastNAme); //??????????
    }

    @Test
    @Parameters({"Age"})
    public void ageTest(String age) {
        doc.setAge(age);
        String getAge = doc.getAge();
        Assert.assertEquals(age, getAge);
    }
    @Test
    @Parameters({"specialty"})
    public void specialityTest(String specialty) {
        doc.setSpecialty(specialty);
        String getSpec = doc.getSpecialty();
        Assert.assertEquals(specialty, getSpec);
    }
    @Test
    @Parameters({"ClinicAddress"})
    public void addressTest(String address) {
        doc.setClinicAddress(address);
        String getClinicAddress = doc.getClinicAddress();
        Assert.assertEquals(address, getClinicAddress);
    }
    @Test
    @Parameters({"TimeWPatient"})
    public void timeWPTest(int time) {
        doc.setTimeWPatient(time);
        int getTime = doc.getTimeWPatient();
        Assert.assertEquals(time, getTime);
    }

}