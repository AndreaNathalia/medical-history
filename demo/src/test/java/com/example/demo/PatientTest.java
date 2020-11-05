package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PatientTest {
    Patient.PatientInformation pat = new Patient.PatientInformation();
    //
    @Test
    @Parameters({"lastName"})
    public void lastNameTest(String lastName) {
        pat.setLastName(lastName);
        String LastNAme = pat.getLastName();
        Assert.assertEquals(lastName, LastNAme);
    }
    @Test
    @Parameters({"FirstName"})
    public void firstNameTest(String firstName) {
        pat.setFirstName(firstName);
        String getFirst = pat.getFirstName();
        Assert.assertEquals(firstName, getFirst);
    }

    @Test
    @Parameters({"MiddleName"})
    public void middleNameTest(String middleName) {
        pat.setMiddleName(middleName);
        String getMiddle = pat.getMiddleName();
        Assert.assertEquals(middleName, getMiddle);
    }

    @Test
    @Parameters({"PhoneNumber"})
    public void phoneTest(int phone) {
        pat.setPhone(phone);
        int getPH = pat.getPhone();
        Assert.assertEquals(phone, getPH);
    }

    @Test
    @Parameters({"Birthday"})
    public void birthTest(String birth) {
        pat.setBirth(birth);
        String getBirth = pat.getBirth();
        Assert.assertEquals(birth, getBirth);
    }

    @Test
    @Parameters({"Gender"})
    public void genderTest(String gender) {
        pat.setGender(gender);
        String getGen = pat.getGender();
        Assert.assertEquals(gender, getGen);
    }

    @Test
    @Parameters({"Status"})
    public void statusTest(String status) {
        pat.setMaritalStatus(status);
        String getStatus = pat.getMaritalStatus();
        Assert.assertEquals(status, getStatus);
    }

    @Test
    @Parameters({"City"})
    public void cityTest(String city) {
        pat.setCity(city);
        String getCity = pat.getCity();
        Assert.assertEquals(city, getCity);
    }
}
