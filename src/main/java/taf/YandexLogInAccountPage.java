package taf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YandexLogInAccountPage {

    private static final String LOGIN = "vikozhushko@yandex.ru";

    private WebDriver driver;

    private WebElement loginName;


    public YandexLogInAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexLogInPasswordPage loginToAccound() {
        loginName = driver.findElement(By.xpath("//input[@id='passp-field-login']"));
        loginName.sendKeys(LOGIN);
        loginName.submit();

        return new YandexLogInPasswordPage(driver);
    }

}
