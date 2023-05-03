package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class SelectClassTest {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    String expectedText = "Honda";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Test
    public void selectClass()throws InterruptedException{
        WebElement selectClass = driver.findElement(By.id("carselect"));
                Select select = new Select(selectClass);

              //  select.selectByVisibleText("Honda");
              //  Thread.sleep(3000);
                select.selectByIndex(2);
                Thread.sleep(3000);
              //  select.selectByValue("benz");
              //  Thread.sleep(3000);
                String actual = select.getFirstSelectedOption().getText();
                assertEquals("not select",expectedText,actual);
                Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
