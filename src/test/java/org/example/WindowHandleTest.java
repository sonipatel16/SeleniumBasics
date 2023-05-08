package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.naming.ldap.StartTlsRequest;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandleTest {
    public WebDriver driver;
    public String url= " https://www.letskodeit.com/practice";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.close();
    }@Test
    public void windowHandleTest()throws InterruptedException{
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);
        driver.findElement(By.id("openwindow")).click();
        Thread.sleep(3000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String handle:allWindowHandles){
            if(!handle.equals(parentWindowHandle)){
                driver.switchTo().window(handle);
                WebElement category = driver.findElement(By.xpath("//select[@name='categories']"));
                category.sendKeys("Api Automation");
                category.sendKeys(Keys.ENTER);
                Thread.sleep(3000);

            }
        }
       driver.switchTo().window(parentWindowHandle);
        WebElement carSelect = driver.findElement(By.id("carselect"));
       //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carSelect);
       Thread.sleep(3000);
       carSelect.click();
       Thread.sleep(3000);

    }@Test
    public void newTabTest()throws InterruptedException{
       // String oldTab = driver.getWindowHandle();
        String windowHandle = driver.getWindowHandle();
        driver.findElement(By.id("opentab")).sendKeys(Keys.ENTER);
       // ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(tabs.size());
       // newTab.remove(oldTab);
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().window(windowHandle);
      //  driver.switchTo().window(oldTab);
        Thread.sleep(3000);
        driver.get(url);
        driver.switchTo().frame(0);
        WebElement category = driver.findElement(By.xpath("//select[@name='categories']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", category);
        category.sendKeys("Selenium WebDriver");
        category.sendKeys(Keys.ENTER);

        Thread.sleep(3000);


    }
    @After
    public void teardown(){
        driver.close();
    }
}
