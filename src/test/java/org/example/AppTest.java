package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void Otp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        driver.findElement(By.cssSelector("div[class=\"position-relative HeaderMenu-link-wrap d-lg-inline-block\"]>a[href='/login']")).click();
        driver.findElement(By.id("login_field")).sendKeys("your email");
        driver.findElement(By.id("password")).sendKeys("your password", Keys.ENTER);
        Totp totp=new Totp("secret key that you will get from github setting under password and authentication and setip 2fa and also click on secret key and paste here");
        driver.findElement(By.id("app_totp")).sendKeys(totp.now(), Keys.ENTER);
        driver.quit();



    }
}
