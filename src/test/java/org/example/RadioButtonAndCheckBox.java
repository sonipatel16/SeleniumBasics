package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class RadioButtonAndCheckBox {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Test
    public void radioButtonChecks()throws InterruptedException{
        driver.findElement(By.id("bmwradio")).click();
        Thread.sleep(3000);
        boolean ans = driver.findElement(By.id("bmwradio")).isSelected();
        assertEquals(true,ans);
        boolean ans2 = driver.findElement(By.id("hondaradio")).isSelected();
        assertEquals(false,ans2);
        driver.findElement(By.id("benzradio")).click();
        boolean ans3 = driver.findElement(By.id("benzradio")).isSelected();
        assertEquals(true,ans3);
        Thread.sleep(3000);

    }
    @Test
    public void testCheckBox()throws InterruptedException{
        driver.findElement(By.id("benzcheck")).click();
        driver.findElement(By.id("hondacheck")).click();
        Thread.sleep(3000);
        boolean ans4 = driver.findElement(By.id("benzcheck")).isSelected();
        assertEquals(true,ans4);
        boolean ans5 = driver.findElement(By.id("hondacheck")).isSelected();
        assertEquals(true,ans5);
        boolean ans6 = driver.findElement(By.id("bmwcheck")).isSelected();
        assertEquals(false,ans6);
        Thread.sleep(3000);

    }


    @After
    public void teardown(){
        driver.close();
    }

}
