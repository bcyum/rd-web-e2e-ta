package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class cssTest {


    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL");


    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

// 1. ödev düğme testi
        @Test
    public void clickPageTest() {
        // "css seçici #login ile butona tıkla"
        WebElement button = driver.findElement(new By.ByCssSelector("#login"));
        button.click();
        // CSS selektörü kullanarak elementi bul
        By cssSelector = By.cssSelector("#loginstatus");
        WebElement element = driver.findElement(cssSelector);
        // Elementin metnini al ve assert et
        String expectedText = "Invalid username/password";
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Assert failed: Text does not match!");
    }

    // 2. ödev
    @Test
    public void fillPageTest() {

        // Text input username
        //dynamic id maalesef her sayfa yüklemesinde değişiyormuş...  :(
        By textInputSelector = By.cssSelector("#c477b612-e8bf-382c-111d-ec8ab1a5a4e8");
        WebElement textInput = driver.findElement(textInputSelector);
        String inputText = "Bekir";
        textInput.sendKeys(inputText);
        // Text input password
        By pwdInputSelector = By.cssSelector("#cf89d747-b34a-c556-0712-aa5e238e7442");
        WebElement pwdInput = driver.findElement(pwdInputSelector);
        String inputPwd = "pwd";
        pwdInput.sendKeys(inputPwd);
        // "#login" CSS seçicisiyle belirlenen düğmeye tıkla
        WebElement button = driver.findElement(new By.ByCssSelector("#login"));
        button.click();
        // CSS selektörü kullanarak elementi bul
        By cssSelector = By.cssSelector("#loginstatus");
        WebElement element = driver.findElement(cssSelector);
        // Elementin metnini al ve assert et
        String expectedText = "Welcome, Bekir!";
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Assert failed: Text does not match!");
    }


    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}