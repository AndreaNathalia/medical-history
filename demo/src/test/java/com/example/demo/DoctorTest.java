package com.example.demo;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoctorTest{
    Doctor.DoctorInformation doc = new Doctor.DoctorInformation();
    @DataProvider(name = "checkerDoctor")
    public Object[][] dataDocs() {
        List<String> passwordLs = new ArrayList<>();
        passwordLs.add("1111");
        passwordLs.add("1234");

        List<String> emailLs=new ArrayList<>();
        emailLs.add("katherinegarcia@ufm.edu");
        emailLs.add("patient@mail.com");
        Object[][] retKeyword={{"not true", emailLs, passwordLs},
                {"not true", emailLs, passwordLs},
        };
        return(retKeyword);
    }
    @Test(dataProvider = "checkerDoctor")
    public void verifyDoc(String keyword, ArrayList<String> emailLs, ArrayList<String> passLs) {
        System.out.println("Check doctor");
        Iterator e=emailLs.iterator();
        Iterator p=passLs.iterator();

        while(e.hasNext() && p.hasNext())
        {
            String mail=(String)e.next();
            String pass=(String)p.next();
            System.out.println("email: "+mail +" pass: "+ pass);
            String result = doc.checker(mail,pass);
            System.out.println("func result ->" + result);
            System.out.println("expected ->" + keyword);
            Assert.assertEquals(keyword,result);
        }
    }

    @Test(dataProvider = "checkerDoctor")
    public void returnerDoc(String keyword, ArrayList<String> emailLs, ArrayList<String> passLs) {
        System.out.println("Returner doctor");
        Iterator e=emailLs.iterator();
        Iterator p=passLs.iterator();

        while(e.hasNext() && p.hasNext())
        {
            String mail=(String)e.next();
            String pass=(String)p.next();
            System.out.println("email: "+mail +" pass: "+ pass);
            Doctor.DoctorInformation result = doc.returner(mail,pass);
            System.out.println(result);
            Assert.assertEquals(null,result);
        }
    }

}