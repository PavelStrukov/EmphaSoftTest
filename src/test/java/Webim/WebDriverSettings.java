/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webim;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Dell
 */
public class WebDriverSettings {

    public WebDriver driver;
    public WebDriverWait wait;
    SupportSignUp support;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 25);

        support = new SupportSignUp();

        support.start();

    }

    @After
    public void close() {
        driver.quit();
        support.getDriver().quit();
    }

}
