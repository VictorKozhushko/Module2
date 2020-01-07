package taf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YandexAccountPage {

    private WebDriver driver;

    private WebElement disk;

    private List<WebElement> advertisment;

    public YandexAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitYandexAccountPage(By by) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public YandexDiskPage switchToDisk() {

        By diskButton = By.xpath("//a[@data-id='disk']");
        waitYandexAccountPage(diskButton);
        disk = driver.findElement(diskButton);
        disk.click();

        By advertismentWindow = By.xpath("//button[contains(@class, 'button2_view_classic')]");
        advertisment = driver.findElements(advertismentWindow);
        if (advertisment.size() != 0) {
            advertisment.get(0).click();
        }

        return new YandexDiskPage(driver);
    }

}
