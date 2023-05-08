package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertClass {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }@Test
    public void alertTest()throws InterruptedException{
        driver.findElement(By.id("name")).sendKeys("hrishan");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);


    }@Test
    public void confirmButton()throws InterruptedException{
        driver.findElement(By.id("name")).sendKeys("Good Morning");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
    }

    @After
    public void teardown(){
        driver.close();
    }
}

