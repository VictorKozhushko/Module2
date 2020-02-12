package tat.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tat.framework.loger.Log;
import tat.framework.screen.BasePage;

public class YandexLogInAccountPage extends BasePage {

    private WebElement loginName;

    public YandexLogInAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public YandexLogInPasswordPage loginToAccound(String login) {
        Log.info("Log in to accout via adding accountname");
        loginName = driver.findElement(By.xpath("//input[@id='passp-field-login']"));
        loginName.sendKeys(login);
        loginName.submit();

        return new YandexLogInPasswordPage();
    }

}
