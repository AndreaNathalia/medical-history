package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class sTest {
    WebDriver driver = new ChromeDriver();
    String url = "http://localhost:8080/";

    @Test
    public void seTest(){
        driver.get(url+"main");
        System.out.println("Currently in /main");
        WebElement linkSignUp = driver.findElement(By.xpath("//button[@id='signUp']"));
        linkSignUp.click();
        System.out.println("Now in Get SignUp for Doctor");
//        Sign Up doc
        WebElement userType = driver.findElement(By.xpath("//input[@type='radio' and @id='doctor']"));
        userType.click();
        WebElement email = driver.findElement(By.xpath("//input[@type='text' and @id='email']"));
        email.sendKeys("abcdoc@email.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password' and @id='password']"));
        password.sendKeys("1234");
        WebElement signUp = driver.findElement(By.xpath("//button[@type='submit' and @class='button-SigUpSubmit']"));
        signUp.click();

        System.out.println("Now in LogIn");
        linkSignUp = driver.findElement(By.xpath("//button[@type='submit' and @class='button-signup'"));
        linkSignUp.click();

        System.out.println("Now in Get SignUp for Patient");
        userType = driver.findElement(By.xpath("//input[@type='radio' and @id='patient']"));
        userType.click();
        email = driver.findElement(By.xpath("//input[@type='text' and @id='email']"));
        email.sendKeys("patient@email.com");
        password = driver.findElement(By.xpath("//input[@type='password' and @id='password']"));
        password.sendKeys("1234");
        signUp = driver.findElement(By.xpath("//button[@type='submit' and @class='button-SigUpSubmit']"));
        signUp.click();

        System.out.println("Log in Doc");
        userType = driver.findElement(By.xpath("//input[@type='radio' and @id='patient']"));
        userType.click();
        email = driver.findElement(By.xpath("//input[@type='text' and @id='email']"));
        email.sendKeys("abcdoc@email.com");
        password = driver.findElement(By.xpath("//input[@type='password' and @id='password']"));
        password.sendKeys("1234");
        signUp = driver.findElement(By.xpath("//button[@type='submit' and @class='button-SigUpSubmit']"));
        signUp.click();

        System.out.println("Now in Doctor profile");
        WebElement editProfile = driver.findElement(By.xpath("//button[@type='submit' and @class='button-editProfile']"));
        editProfile.click();

        System.out.println("Now in edit doc info");
        WebElement name = driver.findElement(By.xpath("//input[@type='text' and @id='name']"));
        name.sendKeys("Doctor");
        WebElement lastName = driver.findElement(By.xpath("//input[@type='text' and @id='LastName']"));
        lastName.sendKeys("Perez");
        WebElement age = driver.findElement(By.xpath("//input[@type='text' and @id='age']"));
        age.sendKeys("22");
        WebElement spec = driver.findElement(By.xpath("//input[@type='text' and @id='specialty']"));
        spec.sendKeys("General");
        WebElement address = driver.findElement(By.xpath("//input[@type='text' and @id='clinicAddress']"));
        address.sendKeys("Tower 1 ");
        WebElement saveChanges = driver.findElement(By.xpath("//button[@type='submit' and @class='button-Save']"));
        saveChanges.click();

    }
}
