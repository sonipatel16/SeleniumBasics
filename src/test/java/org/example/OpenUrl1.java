package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenUrl1 {
// trying to open different websites
public static void main(String[] args) throws InterruptedException{
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.amazon.co.uk");
    driver.manage().window().maximize();
    driver.get("https://www.shein.co.uk/");
    Thread.sleep(3000);
    driver.close();

}
public void openYouTube(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.youtube.com/");

}
}
