/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webim;

import com.mycompany.emphasofttest.GenerateText;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author Dell
 */
public class ChatTest extends WebDriverSettings {

    @Test
    public void openAndCloseChat() {

        driver.get("https://demo-pro.webim.ru");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='webim-button-corner webim_button']")));

        WebElement chatBottom = driver.findElement(By.xpath("//a[@class='webim-button-corner webim_button']"));
        chatBottom.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='scroll-wrapper webim-message-area webim-textarea-ext']")));

        //check sending message
        WebElement textField = driver.findElement(By.xpath("//div[@class='webim-message-area webim-textarea-ext scroll-content']"));
        String message = GenerateText.generateMessage();
        textField.sendKeys(message);

        driver.findElement(By.xpath("//button[@class='webim-action webim-send-button']")).click();
        String xPathMessage = "//span[contains(text(),'" + message + "')]";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathMessage)));

        //check closing chat
        WebElement chatCloseBottom = driver.findElement(By.xpath("//div[@class='webim-action webim-action-close']"));
        chatCloseBottom.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='webim-chat']")));
    }

    @Test
    public void sendFile() {

        driver.get("https://demo-pro.webim.ru");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='webim-button-corner webim_button']")));

        WebElement chatBottom = driver.findElement(By.xpath("//a[@class='webim-button-corner webim_button']"));
        chatBottom.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='webim-chat']")));

        driver.findElement(By.xpath("//button[@class='webim-action webim-actions-button']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='webim-chat-action webim-chat-action-upload']")));

        WebElement uploadFile = driver.findElement(By.xpath("//li[@class='webim-chat-action webim-chat-action-upload']//input[@class='webim-fileupload']"));
        uploadFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/files/ForSendingFile.txt");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//li[@class='webim-message webim-file_visitor-message webim-ready']//a[contains(text(),'ForSendingFile.txt')]")));

    }

    @Test
    public void raitOperator() {
        support.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='bg-ico webim-status online']")));
        support.getDriver().findElement(By.xpath("//span[@class='bg-ico webim-status online']")).click();

        support.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='session-panel-inner-wrapper']")));

        driver.get("https://demo-pro.webim.ru");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='webim-button-corner webim_button']")));

        WebElement chatBottom = driver.findElement(By.xpath("//a[@class='webim-button-corner webim_button']"));
        chatBottom.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='scroll-wrapper webim-message-area webim-textarea-ext']")));

        WebElement textField = driver.findElement(By.xpath("//div[@class='webim-message-area webim-textarea-ext scroll-content']"));
        String message = GenerateText.generateMessage();
        textField.sendKeys(message);
        driver.findElement(By.xpath("//button[@class='webim-action webim-send-button']")).click();
        String xPathMessage = "//span[contains(text(),'" + message + "')]";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathMessage)));

        support.getDriver().findElement(By.xpath("//div[contains(text(),'" + message + "')]")).click();
        WebElement answer = support.getDriver().findElement(By.xpath("//textarea[@placeholder='Сообщение']"));
        String answerText = GenerateText.generateMessage();
        answer.sendKeys(answerText);
        support.getDriver().findElement(By.xpath("//input[@id='check_spelling_auto_checkbox']")).click();
        support.getDriver().findElement(By.xpath("//a[@class='button send_chat_message']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + answerText + "')]")));
        driver.findElement(By.xpath("//button[@class='webim-action webim-actions-button']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='webim-chat-action webim-chat-action-rate']")));

        driver.findElement(By.xpath("//li[@class='webim-chat-action webim-chat-action-rate']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='webim-rate-block']")));
        driver.findElement(By.xpath("//div[@class='webim-overlays-container']//li[5]")).click();

        driver.findElement(By.xpath("//button[@class='webim-btn webim-btn-send webim-js-button-style']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='webim-overlay webim-rate-block webim-ready']")));
    }

}
