package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenUrl {
    public WebDriver driver;
    @Before
            public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
@Test
    public void openNopeCommerce()throws InterruptedException{
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.id("gender-female")).click();
        Thread.sleep(3000);

   Thread.sleep(3000);
        driver.findElement(By.name("FirstName")).sendKeys("falguni");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@data-val-required='Last name is required.']")).sendKeys("patel");
      // driver.findElement(By.name("LastName")).sendKeys("patel");
   Thread.sleep(3000);
       driver.findElement(By.name("DateOfBirthDay")).sendKeys("10");
   Thread.sleep(3000);
       driver.findElement(By.name("DateOfBirthMonth")).sendKeys("october");
    Thread.sleep(3000);


     // driver.findElement(By.id("Email")).sendKeys("sonipatel16@gmail.com");
    driver.findElement(By.xpath("//input[@data-val-required='Email is required.']")).sendKeys("sonipatel16@gmail.com");

    Thread.sleep(3000);
       driver.findElement(By.id("Password")).sendKeys("ketsoni29");
   Thread.sleep(3000);
   driver.findElement(By.name("ConfirmPassword")).sendKeys("ketsoni29");
      driver.findElement(By.linkText("Register")).click();
    Thread.sleep(3000);




}
@Test
    public void logInNope()throws InterruptedException{
        driver.get("https://demo.nopcommerce.com/");
        //driver.findElement(By.xpath("//input[@data-val-required='Please enter your email']")).sendKeys("sonipatel16@gmail.com");

    driver.findElements(By.xpath("//input[@id='Email']"));

       // Thread.sleep(3000);
        Thread.sleep(3000);
}



}