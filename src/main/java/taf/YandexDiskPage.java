package taf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexDiskPage {

    private WebDriver driver;

    private WebElement uploadFile;

    private WebElement createFile;

    public YandexDiskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitYandexDiskPage(By by) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public YandexWord createFile() {

        driver.manage().window().maximize();

        By button = By.xpath("//button[contains(@class, 'button2_tone_default')]");
        waitYandexDiskPage(button);
        createFile = driver.findElement(button);
        createFile.click();

        By textDocument = By.xpath("//span[contains(text(), 'документ')]");
        waitYandexDiskPage(textDocument);
        WebElement textFile = driver.findElement(textDocument);
        textFile.click();

        return new YandexWord(driver);
    }

    public YandexDiskPage deleteFile(String filename){
        By document = By.xpath("//span[contains(text(), '"+filename+"')]");
        WebElement doc = driver.findElement(document);
        doc.click();
        By deleteItem = By.xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_delete')]");
        WebElement delete = driver.findElement(deleteItem);
        delete.click();
        return this;
    }
}
