package com.app.MedicalHistory;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TimewPatientTest {
    Doctor.DoctorInformation doc = new Doctor.DoctorInformation("Doctor", "doc@mail.com", "Pass123");

    @DataProvider(name = "testTime")
    public Object[][] yearTime() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3},
        };
    }

    @Test(dataProvider = "testTime")
    public void testTimeWP(int year, int number) {
        int addTime = doc.addTimeWPatient();
        System.out.println("Expected "+ year);
        System.out.println("Actual "+ addTime);
        Assert.assertEquals(year, addTime);
    }
}
