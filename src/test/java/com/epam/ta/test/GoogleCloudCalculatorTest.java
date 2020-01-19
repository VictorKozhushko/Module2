package com.epam.ta.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.ta.page.google.GoogleCloudHomePage;
import com.epam.ta.page.google.GoogleComputingEnginePage;
import com.epam.ta.page.google.GoogleSearchResultsPage;
import com.epam.ta.page.tenminutes.TenMinutEmailPage;

import java.util.ArrayList;

public class GoogleCloudCalculatorTest extends CommonConditions {

    private static final String SEARCH = "Google Cloud Platform Pricing Calculator";

    @Test(description = "Test google cloud platform price calculator")
    public void googleCloudCalulatorTest() {

        GoogleSearchResultsPage searchResultsPage = new GoogleCloudHomePage(driver).openPage().submitTerm(SEARCH);
        GoogleComputingEnginePage computingEnginePage = searchResultsPage.firstSearchItem();
        computingEnginePage.fillForm();

        String tabGoogleComputingEngine = driver.getWindowHandle();

        String a = "window.open(\"https://10minutemail.com\",'_blank');";
        ((JavascriptExecutor) driver).executeScript(a);

        TenMinutEmailPage tenMinutEmailPage = new TenMinutEmailPage(driver);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        tabs.remove(tabGoogleComputingEngine);
        String tab10MinutEmail = tabs.get(0);

        driver.switchTo().window(tab10MinutEmail);

        String email = tenMinutEmailPage.getEmailAddress();

        driver.switchTo().window(tabGoogleComputingEngine);

        String priceGoogleComputing = computingEnginePage.getCost();

        computingEnginePage.estimateViaEmail(email);

        driver.switchTo().window(tab10MinutEmail);

        String priceFromEmail = tenMinutEmailPage.getPriceFromEmail();

        Assert.assertEquals(priceGoogleComputing, priceFromEmail);

    }

}
