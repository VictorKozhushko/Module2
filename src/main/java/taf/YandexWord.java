package taf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexWord {

    private WebDriver driver;

    public YandexWord(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitYandexWordPage(By by) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public YandexWord sendText(String string) {
        By paragraph = By.xpath("//p[@class='Paragraph']");
        waitYandexWordPage(paragraph);
        WebElement paragraphInput = driver.findElement(paragraph);
        paragraphInput.sendKeys(string);
        return this;
    }

    public YandexWord waitSavingOfDocument() {
        By titleSaved = By.xpath("//span[@id='BreadcrumbSaveStatus']");
        new WebDriverWait(driver, 12)
                .until(ExpectedConditions.visibilityOfElementLocated(titleSaved));
        WebElement saved = driver.findElement(titleSaved);
        String stringSaved = saved.getText();
        while (!stringSaved.equals("Сохранено в Yandex")){
            stringSaved = saved.getText();
        }
        return this;
    }

    public String getDocumentName() {
        By titleDocument = By.xpath("//div[@id='BreadcrumbTitle']");
        WebElement title = driver.findElement(titleDocument);
        String titleString = title.getText();
        return titleString;
    }

}
