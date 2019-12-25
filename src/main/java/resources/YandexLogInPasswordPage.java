package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YandexLogInPasswordPage {

    private static final String PASSWORD = "vic_TAR";

    private WebDriver driver;

    private WebElement loginPassword;

    public YandexLogInPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexAccountPage loginAccount() {
        loginPassword = driver.findElement(By.xpath("//input[@id='passp-field-passwd']"));
        loginPassword.sendKeys(PASSWORD);
        loginPassword.submit();
        return new YandexAccountPage(driver);
    }
}
