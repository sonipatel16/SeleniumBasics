package org.example;
import org.openqa.selenium.JavascriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnabledDisableAndElementsDisplay {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Actions actions = new Actions(driver);
    }

    @Test
    public void enabledDisableTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement Disable = driver.findElement(By.id("disabled-button"));
        //driver.findElement(By.xpath("//input[@id=disabled-button]")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Disable);
        driver.findElement(By.id("disabled-button")).click();
       boolean ans1 = driver.findElement(By.id("enabled-example-input")).isEnabled();
        assertFalse(ans1);
       Thread.sleep(3000);
       WebElement enabled =driver.findElement(By.id("enabled-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", enabled);
        driver.findElement(By.id("enabled-button")).click();
        Thread.sleep(3000);


       boolean ans2 = driver.findElement(By.id("enabled-example-input")).isEnabled();
      assertTrue(ans2);
       Thread.sleep(3000);
       driver.findElement(By.id("enabled-example-input")).sendKeys("falguni");
        Thread.sleep(3000);
    }
        @Test
        public void testDisplay()throws InterruptedException{
        Actions actions = new Actions(driver);
         WebElement hide =   driver.findElement(By.id("hide-textbox"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hide);
            driver.findElement(By.id("hide-textbox")).click();
            boolean hey = driver.findElement(By.id("displayed-text")).isDisplayed();
            //System.out.println(hey);
            assertFalse(hey);
            Thread.sleep(3000);
           WebElement show = driver.findElement(By.id("show-textbox"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", show);
            driver.findElement(By.id("show-textbox")).click();
            Thread.sleep(3000);
            boolean hey1 = driver.findElement(By.id("displayed-text")).isDisplayed();
            assertTrue(hey1);
            Thread.sleep(3000);
            driver.findElement(By.id("displayed-text")).sendKeys("ketan");
        }
        @After
        public void teardown(){
            driver.close();
        }


    }
