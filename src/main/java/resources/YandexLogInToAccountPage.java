package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YandexLogInToAccountPage {

    private static final String LOGIN = "vikozhushko@yandex.ru";

    private static final String PASSWORD = "vic_TAR";

    private WebDriver driver;

    private WebElement loginName;

    private WebElement loginPassword;

    private WebElement loginButton;

    public YandexLogInToAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexAccountPage loginToAccound() {
        loginName = driver.findElement(By.xpath("//input[@id='passp-field-login']"));
        loginName.click();
        loginName.sendKeys(LOGIN);
        loginPassword = driver.findElement(By.xpath("//input[@id='passp-field-passwd']"));
        loginPassword.click();
        loginPassword.sendKeys(PASSWORD);

        return new YandexAccountPage(driver);
    }

}
