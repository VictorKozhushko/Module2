package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taf.framework.loger.Log;
import taf.framework.ui.Browser;

public class YandexLogInPasswordPage extends Browser {

    private By loginPasswordLocator = By.xpath("//input[@id='passp-field-passwd']");

    public YandexLogInPasswordPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public YandexAccountPage loginPasswordAccount(String password) {
        WebElement loginPassword = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(loginPasswordLocator));

        highlightElement(loginPassword);
        loginPassword.sendKeys(password);
        loginPassword.submit();

        Log.info("The password was submitted");
        return new YandexAccountPage();
    }
}
