package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import taf.framework.loger.Log;
import taf.framework.ui.Browser;

public class YandexLogInPasswordPage extends Browser {

    private By loginPasswordLocator = By.xpath("//input[@id='passp-field-passwd']");

    public YandexLogInPasswordPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public YandexAccountPage loginPasswordAccount(String password) {

        type(loginPasswordLocator, password);
        WebElement loginPassword = driver.findElement(loginPasswordLocator);
        loginPassword.submit();

        Log.info("The password was submitted");
        return new YandexAccountPage();
    }
}
