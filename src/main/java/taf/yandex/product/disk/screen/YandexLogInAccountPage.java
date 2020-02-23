package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import taf.framework.ui.Browser;

public class YandexLogInAccountPage extends Browser {

    private WebElement loginName;

    private By loginLocator = By.xpath("//input[@id='passp-field-login']");

    public YandexLogInAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public YandexLogInPasswordPage loginToAccound(String login) {

        type(loginLocator, login);
        loginName = driver.findElement(loginLocator);
        loginName.submit();

        return new YandexLogInPasswordPage();
    }

}
