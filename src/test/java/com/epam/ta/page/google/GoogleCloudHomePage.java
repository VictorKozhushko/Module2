package com.epam.ta.page.google;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.ta.page.AbstractPage;
import com.epam.ta.page.google.GoogleSearchResultsPage;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchText;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
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
