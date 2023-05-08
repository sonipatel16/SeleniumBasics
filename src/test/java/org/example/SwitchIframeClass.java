package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchIframeClass {
    public WebDriver driver;
    public String Url = "https://www.letskodeit.com/practice";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }@Test
    public void switchToIframe()throws InterruptedException{
     //WebElement iframe = driver.findElement(By.id("courses-iframe"));
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebElement category = driver.findElement(By.xpath("//select[@name='categories']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", category);
     // WebElement searchTab =   driver.findElement(By.xpath("//input[@id='search']"));
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchTab);
        Thread.sleep(3000);
       // category.sendKeys("Software Testing");
        category.sendKeys("Selenium WebDriver");
        category.sendKeys(Keys.ENTER);
     // searchTab.sendKeys("JavaScript");
     //  searchTab.sendKeys("Complete Test");
       // searchTab.sendKeys("python");
     //searchTab.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        WebElement carSelect = driver.findElement(By.id("carselect"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carSelect);
        Thread.sleep(3000);
        carSelect.click();
        Thread.sleep(3000);

    }@After
    public void tearDown(){
        driver.close();
    }
}
