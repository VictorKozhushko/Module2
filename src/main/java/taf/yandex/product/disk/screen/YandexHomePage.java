package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taf.framework.loger.Log;
import taf.framework.ui.Browser;

public class YandexHomePage extends Browser {

    private By loginButtonLocator = By.xpath("//a[contains(@class, 'desk-notif-card__login-enter-expanded')]");

    private static final String START_URL = "https://www.yandex.ru";

    public YandexHomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public WebElement waitYandexHomePage(By by) {
        return new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public YandexLogInAccountPage loginToYandex() {

        driver.get(START_URL);
        Log.info("Starting page of the test is: " + START_URL);

        highlightElement(waitYandexHomePage(loginButtonLocator));

        WebElement login = driver.findElement(loginButtonLocator);
        login.click();

        return new YandexLogInAccountPage();
    }

}
