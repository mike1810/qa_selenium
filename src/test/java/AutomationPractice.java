import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.lang.System;

public class AutomationPractice {
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ua/");

        WebElement search = driver.findElement(By.className("a4blc"));
        search.sendKeys("GeForce 1050");
        search.sendKeys(Keys.ENTER);
    }

    @Test
    public void userLogin(){

    }

    @AfterClass
    public static void tearDown(){

    }
}
