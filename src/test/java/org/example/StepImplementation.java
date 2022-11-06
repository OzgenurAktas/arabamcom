package org.example;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


public class StepImplementation {

    String arabamLogo="//*[@alt=\"arabam.com\"]";
    String loginBtn="//*[@aria-label=\"Giriş Yap\"]";

    String backToTheHomePage="//*[@class=\"back-to-home\"]";

    String email="//*[@id=\"emailOrPhone\"]";
    String password="//*[@name=\"password\"]";

    String loginButton="//*[@type=\"submit\"]";

    String errorMessage="//*[@class=\"form-row-error\"]";


    Wait wait=new Wait();

    @Step("Open webUrl")
    public void openWebUrl() {
        Driver.webDriver.get("https://www.arabam.com/");
        wait.waitForSeconds(4);
        Driver.webDriver.manage().window().maximize();
        WebElement logo= Driver.webDriver.findElement(By.xpath(arabamLogo));
        Assert.assertNotNull("WEb Site did not open",logo);
        System.out.println("website opened successfully");

    }

    @Step("Open Login page")
    public void openLoginPage(){
        wait.waitForSeconds(4);

        WebElement loginBtnElement= Driver.webDriver.findElement(By.xpath(loginBtn));
        Assert.assertNotNull("There is no login btn",loginBtnElement);
        loginBtnElement.click();

        wait.waitForSeconds(3);

        WebElement backToTheHomePageElemt= Driver.webDriver.findElement(By.xpath(backToTheHomePage));
        Assert.assertNotNull("login page did not open",backToTheHomePageElemt);


    }

    @Step("Negative Login Action")
    public void negativeLoginAction(){
        wait.waitForSeconds(3);

        WebElement emailElement= Driver.webDriver.findElement(By.xpath(email));
        Assert.assertNotNull("emailElement cant found!",emailElement);
        emailElement.sendKeys("negative@emain.com");

        WebElement passwordElemtn= Driver.webDriver.findElement(By.xpath(password));
        Assert.assertNotNull("passwordElemtn cant found",passwordElemtn);
        passwordElemtn.sendKeys("negarivepassword");

        WebElement loginButtonElement= Driver.webDriver.findElement(By.xpath(loginButton));
        Assert.assertNotNull("loginButtonElement cant found",loginButtonElement);

        loginButtonElement.click();
        wait.waitForSeconds(3);


        WebElement errorMessageElemt= Driver.webDriver.findElement(By.xpath(errorMessage));
        Assert.assertNotNull("Failed",errorMessageElemt);




    }





}
