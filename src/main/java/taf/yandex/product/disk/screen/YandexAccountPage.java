package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import taf.framework.ui.Browser;

import java.util.List;

public class YandexAccountPage extends Browser {

    private WebElement disk;

    private List<WebElement> advertisment;

    private By diskButton = By.xpath("//a[@data-id='disk']");

    public YandexAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public YandexDiskPage switchToDisk() {

        click(diskButton);

        By advertismentWindow = By.xpath("//button[contains(@class, 'button2_view_classic')]");
        advertisment = driver.findElements(advertismentWindow);
        if (advertisment.size() != 0) {
            advertisment.get(0).click();
        }

        return new YandexDiskPage();
    }

}
