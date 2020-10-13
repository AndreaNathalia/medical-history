package com.app.MedicalHistory;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    Doctor.DoctorInformation doc = new Doctor.DoctorInformation("Doctor", "doc@mail.com", "Pass123");

    @Test
    @Parameters({"NewPoints"})
    public void pointsTest(int NewPoints) {
        int points = doc.addDocPoints(NewPoints);
        Assert.assertEquals(points,5);
    }
//
    @Test
    @Parameters({"lastName"})
        public void userTypeTest(String lastName) {
        doc.setLastName(lastName);
        String LastNAme = doc.getLastName();
        Assert.assertEquals(lastName, LastNAme); //??????????
    }


}