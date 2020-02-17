package taf.yandex.product.disk.service;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taf.framework.driver.DriverSingleton;
import taf.yandex.product.disk.screen.YandexAccountPage;
import taf.yandex.product.disk.screen.YandexDiskPage;
import taf.yandex.product.disk.screen.YandexWordPage;

import java.util.ArrayList;

public class AccountDiskService {

    public void switchToDiskPage(YandexAccountPage yandexAccountPage) {

        String yandexTab = DriverSingleton.getDriver().getWindowHandle();

        YandexDiskPage yandexDiskPage = yandexAccountPage.switchToDisk();

        ArrayList<String> tabs = new ArrayList<>(DriverSingleton.getDriver().getWindowHandles());

        tabs.remove(yandexTab);
        String yandexDriver = tabs.get(0);

        DriverSingleton.getDriver().switchTo().window(yandexDriver);

        String yandexWordTab;

        YandexWordPage yandexWordPage = yandexDiskPage.createFile();
        tabs = new ArrayList<>(DriverSingleton.getDriver().getWindowHandles());

        tabs.remove(yandexTab);
        tabs.remove(yandexDriver);
        yandexWordTab = tabs.get(0);

        DriverSingleton.getDriver().switchTo().window(yandexWordTab);

        By frame = By.tagName("iframe");
        new WebDriverWait(DriverSingleton.getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(frame));

        DriverSingleton.getDriver().switchTo().frame(0);
    }
}
