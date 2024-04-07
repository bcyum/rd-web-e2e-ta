package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;

public class CssSelectorTest {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager = new PropertyManager();
    String url = propertyManager.getProperty("https://demoqa.com/buttons");

    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test
    public void clickButtonTest() {
        // "Buttons" seçeneğini tıkla
        WebElement buttonsOption = driver.findElement(By.cssSelector("li#item-4"));
        buttonsOption.click();

        // "Click Me" düğmesini tıkla
        WebElement clickMeButton = driver.findElement(By.cssSelector("button#doubleClickBtn"));
        clickMeButton.click();

        // Görünen mesajı oku
        WebElement messageElement = driver.findElement(By.cssSelector("p#doubleClickMessage"));
        String messageText = messageElement.getText();

        // Assert et
        String expectedMessage = "You have done a double click";
        Assert.assertEquals(messageText, expectedMessage, "Assert failed: Message does not match!");
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        webDriver.quitDriver();
    }
}
