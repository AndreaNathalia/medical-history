package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddPointsTest {
    Doctor.DoctorInformation doc = new Doctor.DoctorInformation();

    @DataProvider(name = "testPoints")
    public Object[][] Points() {
        return new Object[][]{
                {2, 2},
                {1, -1},
                {2, 1},
        };
    }

    @Test(dataProvider = "testPoints")
    public void testPoints(int testCase, int number) {
        int points = doc.addDocPoints(number);
        System.out.println("Expected "+testCase);
        System.out.println("Actual "+points);
        Assert.assertEquals(points,testCase);
    }
}
