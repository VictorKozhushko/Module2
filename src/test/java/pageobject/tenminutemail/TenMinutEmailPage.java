package pageobject.tenminutemail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenMinutEmailPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@id='copyAddress']")
    private WebElement emailAddress;

    public TenMinutEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEmailAddress() {
        return emailAddress.getAttribute("data-clipboard-text");
    }
}
