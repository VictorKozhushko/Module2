package tat.yandex.product.disk.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tat.yandex.product.disk.screen.YandexAccountPage;
import tat.yandex.product.disk.screen.YandexDiskPage;
import tat.yandex.product.disk.screen.YandexWordPage;

import java.util.ArrayList;

public class AccountDisk {


    public void switchToDisk() {

        YandexAccountPage yandexAccountPage = new YandexAccountPage();

        WebDriver driver = yandexAccountPage.getDriver();

        String yandexTab = driver.getWindowHandle();

        YandexDiskPage yandexDiskPage = yandexAccountPage.switchToDisk();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        tabs.remove(yandexTab);
        String yandexDriver = tabs.get(0);

        driver.switchTo().window(yandexDriver);

        String yandexWordTab;

        YandexWordPage yandexWordPage = yandexDiskPage.createFile();
        tabs = new ArrayList<>(driver.getWindowHandles());

        tabs.remove(yandexTab);
        tabs.remove(yandexDriver);
        yandexWordTab = tabs.get(0);

        driver.switchTo().window(yandexWordTab);

        By frame = By.tagName("iframe");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(frame));

        driver.switchTo().frame(0);
    }
}
