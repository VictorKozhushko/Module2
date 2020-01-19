package com.epam.ta.page.google;

import com.epam.ta.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.ta.page.google.GoogleComputingEnginePage;

public class GoogleSearchResultsPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchResult;

    protected GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleComputingEnginePage firstSearchItem() {
        searchResult.click();
        return new GoogleComputingEnginePage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

}
