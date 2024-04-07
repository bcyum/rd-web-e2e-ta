package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;

public class cssTestHw1 {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL");

    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test
    public void clickPageTest() {
        WebElement button = driver.findElement(By.id("login"));
        button.click();
        By cssSelector = By.id("loginstatus");
        WebElement element = driver.findElement(cssSelector);
        String expectedText = "Invalid username/password";
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Assert failed: Text does not match!");
    }

    @Test
    public void fillPageTest() {
        WebElement textInput = driver.findElement(By.name("username"));
        String inputText = "Bekir";
        textInput.sendKeys(inputText);
        WebElement pwdInput = driver.findElement(By.name("password"));
        String inputPwd = "pwd";
        pwdInput.sendKeys(inputPwd);
        WebElement button = driver.findElement(By.id("login"));
        button.click();
        By cssSelector = By.id("loginstatus");
        WebElement element = driver.findElement(cssSelector);
        String expectedText = "Welcome, Bekir!";
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Assert failed: Text does not match!");
    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
