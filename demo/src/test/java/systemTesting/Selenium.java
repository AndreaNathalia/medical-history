package systemTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.GlobalVariables;

public class Selenium  extends InitDriver {

    @BeforeClass(alwaysRun = true)
    public void initUrl(){
        driver.get(GlobalVariables.seleniumHost);

    }

    @Test(groups = {"systemTesting"})
    public void myfirstTest() throws InterruptedException {
        System.out.println("Selenium Test");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Components')]/parent::a"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Buttons')]"))).click();
        System.out.println(driver.getCurrentUrl());
    }
}
