/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webim;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Dell
 */
public class SupportSignUp {

    private WebDriver driver;
    private WebDriverWait wait;

    public void start() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 25);
        driver.manage().window().maximize();
        driver.get("https://login.webim.ru/operator/login.php");

        WebElement email = driver.findElement(By.xpath("//input[@id='login_or_email']"));
        email.sendKeys("o@webim.ru");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("password");

        WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submit.click();

    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    @After
    public void close() {
        driver.close();
    }
}
