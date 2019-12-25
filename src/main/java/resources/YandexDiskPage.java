package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YandexDiskPage {

    private WebDriver driver;

    private WebElement uploadFile;

    private WebElement createFile;

    public YandexDiskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexDiskPage createFile() {

        driver.manage().window().maximize();

        try {
            Thread.sleep(2000);
            createFile = driver.findElement(By.xpath("//button[@class='control button2 button2_view_default button2_tone_default button2_size_n button2_theme_raised button2_width_max']"));
            createFile.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
