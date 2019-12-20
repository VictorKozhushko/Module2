package pageobject.tenminutemail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutEmailPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@id='copyAddress']")
    private WebElement emailAddress;

    @FindBy(xpath = "//span[@class='inc-mail-address']")
    private WebElement emailIncoming;

    @FindBy(xpath="//td[contains(text(),'USD')]")
    private WebElement cost;

    public void waitTenMinutEmailPage(WebElement webElement){
        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public TenMinutEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEmailAddress() {
        return emailAddress.getAttribute("data-clipboard-text");
    }

    public String getPriceFromEmail() {
        waitTenMinutEmailPage(emailIncoming);
        emailIncoming.click();
        waitTenMinutEmailPage(cost);
        String stringPrice = cost.getText();
        String words[] = stringPrice.split(" ");
        return words[1];
    }
}
