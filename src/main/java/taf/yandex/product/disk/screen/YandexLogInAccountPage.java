package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import taf.framework.loger.Log;
import taf.framework.ui.Browser;

public class YandexLogInAccountPage extends Browser {

    private WebElement loginName;

    private By loginLocator = By.xpath("//input[@id='passp-field-login']");

    public YandexLogInAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public YandexLogInPasswordPage loginToAccound(String login) {
        Log.info("Log in to accout via adding accountname");
        loginName = driver.findElement(loginLocator);
        highlightElement(loginName);
        loginName.sendKeys(login);
        loginName.submit();

        return new YandexLogInPasswordPage();
    }

}
