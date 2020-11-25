package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatientTest {
    Patient.PatientInformation pat = new Patient.PatientInformation();
    @DataProvider(name = "checkerPatient")
    public Object[][] dataPatients() {
        List<String> passwordLs = new ArrayList<>();
        passwordLs.add("pwd");
        passwordLs.add("pwd1");

        List<String> emailLs=new ArrayList<>();
        emailLs.add("andreareyes@ufm.edu");
        emailLs.add("andreanathaliar@gmail.com");
        Object[][] retKeyword={{"not true", emailLs, passwordLs},
                {"not true", emailLs, passwordLs},
        };
        return(retKeyword);
    }
    @Test(dataProvider = "checkerPatient")
    public void verifyPatient(String keyword, ArrayList<String> emailLs, ArrayList<String> passLs) {
        System.out.println("Check patient");
        Iterator e=emailLs.iterator();
        Iterator p=passLs.iterator();

        while(e.hasNext() && p.hasNext())
        {
            String mail=(String)e.next();
            String pass=(String)p.next();
            System.out.println("email: "+mail +" pass: "+ pass);
            String result = pat.checkerModel(mail,pass);
            System.out.println("func result ->" + result);
            System.out.println("expected ->" + keyword);
            Assert.assertEquals(keyword,result);
        }
    }
    @Test(dataProvider = "checkerPatient")
    public void returnerDoc(String keyword, ArrayList<String> emailLs, ArrayList<String> passLs) {
        System.out.println("Returner patient");
        Iterator e=emailLs.iterator();
        Iterator p=passLs.iterator();

        while(e.hasNext() && p.hasNext())
        {
            String mail=(String)e.next();
            String pass=(String)p.next();
            System.out.println("email: "+mail +" pass: "+ pass);
            Patient.PatientInformation result = pat.returner(mail,pass);
            System.out.println(result);
            Assert.assertEquals(null,result);
        }
    }

}
