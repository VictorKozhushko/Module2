package pageobject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject.google.GoogleComputingEnginePage;

public class GoogleSearchResultsPage {

    private WebDriver driver;

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchResult;

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleComputingEnginePage firstSearchItem() {
        searchResult.click();
        return new GoogleComputingEnginePage(driver);
    }
}
