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
    public void openSportsDirectUrl()throws InterruptedException{
        driver.get("https://www.sportsdirect.com");
        Thread.sleep(3000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.className("slideName")).click();
        Thread.sleep(3000);

    }
    @Test
    public void openSuperDryUrl(){
        driver.get("https://www.superdry.com");

    }
    @Test
    public void openYoutube()throws InterruptedException{
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='search']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("bolya shri hari re");
       // driver.findElement(By.xpath("//form[@id='search-form']")).click();
        driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
        Thread.sleep(3000);
       // driver.findElement(By.xpath("//form[@id='search-form']")).sendKeys("kids cartoon");
        Thread.sleep(3000);




    }


    public void tearDown(){
       // driver.close();

    }

}
