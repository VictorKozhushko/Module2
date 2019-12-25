package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexAccountPage {

    private WebDriver driver;

    private WebElement disk;

    private List<WebElement> advertisment;

    public YandexAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexDiskPage switchToDisk() {

        try {
            Thread.sleep(1000);
            disk = driver.findElement(By.xpath("//a[@data-id='disk']"));
            disk.click();
            Thread.sleep(1000);
            advertisment = driver.findElements(By.xpath("//button[@class='control button2 button2_view_classic button2_size_s button2_theme_clear dialog__close']"));
            if (advertisment.size() != 0) {
                advertisment.get(0).click();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new YandexDiskPage(driver);
    }

}
