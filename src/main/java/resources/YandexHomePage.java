package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexHomePage {

    private WebDriver driver;

    private WebElement login;

    private static final String START_URL = "https://www.yandex.ru";

    public YandexHomePage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public YandexLogInToAccountPage loginToYandex(){

        driver.get(START_URL);
        By by = By.xpath("//a[@class='button desk-notif-card__login-enter-expanded button_theme_gray i-bem button_js_inited']");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(by)));

        login = driver.findElement(by);
        login.click();

        return new YandexLogInToAccountPage(driver);
    }

}
