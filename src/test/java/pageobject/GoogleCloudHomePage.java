package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudHomePage {


    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchText;

    public GoogleCloudHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        searchText.click();
        return this;
    }

    public GoogleSearchResultsPage submitTerm(String searchString) {
        searchText.sendKeys(searchString);
        searchText.submit();
        return new GoogleSearchResultsPage(driver);
    }

}
