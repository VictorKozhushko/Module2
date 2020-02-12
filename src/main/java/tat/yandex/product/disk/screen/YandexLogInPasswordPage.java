package tat.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tat.framework.loger.Log;
import tat.framework.screen.BasePage;

public class YandexLogInPasswordPage extends BasePage {

    private By loginPasswordLocator = By.xpath("//input[@id='passp-field-passwd']");

    public YandexLogInPasswordPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public YandexAccountPage loginAccount(String password) {
        WebElement loginPassword = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(loginPasswordLocator));
        loginPassword.sendKeys(password);
        loginPassword.submit();

        Log.info("The password was submitted");
        return new YandexAccountPage();
    }
}
