package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryingJunit1 {
    public WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openNetflixUrl(){
        driver.get("https://www.netflix.com");



    }
    @Test
    public void openAmazonUrl(){
        driver.get("https://www.amazon.co.uk");

    }
    @Test
    public void openSportsDirectUrl(){
        driver.get("https://www.sportsdirect.com");

    }
    @Test
    public void openSuperDryUrl(){
        driver.get("https://www.superdry.com");

    }
    @Test
    public void openYoutube()throws InterruptedException{
        driver.get("https://www.youtube.com/");
        driver.findElements(By.tagName("'inline-player'"));
        Thread.sleep(3000);
       // driver.findElement(By.linkText("'search-input'")).sendKeys("tu chale mari sath");
    }

    @After
    public void tearDown(){
        driver.close();

    }

}
