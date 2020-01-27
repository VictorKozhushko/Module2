package com.epam.ta.page.google;

import com.epam.ta.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResultsPage extends AbstractPage {

    private final By searchLocator = By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']");

    protected GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleComputingEnginePage firstSearchItem() {
        WebElement searchResult = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchLocator));
        searchResult.click();
        return new GoogleComputingEnginePage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

}
