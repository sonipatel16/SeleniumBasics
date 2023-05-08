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


import java.util.List;
import java.util.concurrent.TimeUnit;

public class MouseHoverClassWebTable {
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

       Actions action = new Actions(driver);
       WebElement hoverTest = driver.findElement(By.id("mousehover"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hoverTest);
        action.moveToElement(hoverTest).click().perform();
       WebElement top = driver.findElement(By.xpath("//a[@href='#top']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", top);
       action.moveToElement(top).click().perform();
     Thread.sleep(3000);
       // WebElement reload = driver.findElement(By.xpath("//a[@href=Reload]"));
       WebElement reload = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[1]/fieldset/div/div/a[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reload);
        action.moveToElement(reload).click().perform();
       Thread.sleep(3000);

    }


    @Test
    public void webTableTest()throws InterruptedException{
        // finding number of rows
        List<WebElement> rowNumber = driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[1]"));
       // List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[3]"));
        int rowCount = rowNumber.size();
        // finding number of columns
        List<WebElement> column = driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[2]/td[1]"));
        List<WebElement> column1 = driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[3]"));
        int columnCOUNT = column.size();
        System.out.println("no. of raws in this table : " + rowCount);
        System.out.println("===========================");
        System.out.println("no.of column in this table : " + columnCOUNT);
       // Actions actions = new Actions(driver);
        WebElement cellAddress = driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr[4]"));
        String value = cellAddress.getText();
        System.out.println("==========================");
        System.out.println(" the cell value is : " + value);
        Thread.sleep(3000);
        WebElement cellAddress2 = driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr[3]"));
        String value2 = cellAddress2.getText();
        System.out.println("=======================");
        System.out.println(" the cell value2 is :  " + value2);
        Thread.sleep(3000);
        WebElement cellAddress1 = driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr[2]"));
        String value1 = cellAddress1.getText();
        System.out.println("==============================");
        System.out.println("the cell value1 is : " + value1);
        Thread.sleep(3000);




    }
    @After
    public void teardown(){
        driver.close();
    }
}