package com.example.demo;

import org.testng.annotations.DataProvider;

public class addDocUserTest {
    @DataProvider(name = "addDoctorUser")
    public Object[][] dataDocs() {
        return new Object [][] {
                {"uno", "dos"}
        };
    }
}
