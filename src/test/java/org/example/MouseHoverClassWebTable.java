package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHoverClass {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void mouseHoverTest()throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(By.id("mousehover"));
     //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",mouseHover);


        actions.moveToElement(mouseHover).perform();
        driver.findElement(By.linkText("Top")).click();
        Thread.sleep(3000);


    }
    @After
    public void teardown(){
        driver.close();
    }
}