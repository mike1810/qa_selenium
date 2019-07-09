import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.lang.System;

public class AutomationPractice {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        //driver.quit();
    }

    @Test
    public void userLogin() {
        driver.get("http://automationpractice.com");

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("mixasikkaliberdiev@yandex.ru");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("create_account_error")));

        if (driver.findElement(By.xpath("//*[@id=\"create_account_error\"]")).isDisplayed()) {
            userLogin2();
        }


        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@id='id_gender1']")));
        driver.findElement(By.xpath(".//input[@id='id_gender1']")).click();

        driver.findElement(By.name("customer_firstname")).sendKeys("Mike");

        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Kaliberdin");

        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Mike10");

        Select selectDays = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        selectDays.selectByValue("10");

        Select selectMonths = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        selectMonths.selectByValue("1");

        Select selectYears = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        selectYears.selectByValue("1994");

        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Mike");

        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Kaliberdin");

        driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("Sperasoft");

        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Donetskaya");

        driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("666");

        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Volgograd");

        Select selectState = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        selectState.selectByValue("5");

        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("00000");
        driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("88005553535");
        driver.findElement(By.xpath("//*[@id=\"alias\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("Donetskaya 666");


        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"submitAccount\"]/span")));
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
    }

    public void userLogin2() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("mixasikkaliberdiev@yandex.ru");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Mike10");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
