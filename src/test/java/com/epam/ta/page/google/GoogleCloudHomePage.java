package com.epam.ta.page.google;

import com.epam.ta.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchText;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public GoogleCloudHomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        searchText.click();
        return this;
    }

    public GoogleSearchResultsPage submitTerm(String searchString) {
        searchText.sendKeys(searchString);
        searchText.submit();
        return new GoogleSearchResultsPage(driver);
    }
}
