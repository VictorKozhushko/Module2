package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.google.GoogleCloudHomePage;
import pageobject.google.GoogleComputingEnginePage;
import pageobject.google.GoogleSearchResultsPage;
import pageobject.tenminutemail.TenMinutEmailPage;

import java.util.ArrayList;

public class WebDriverGoogleCloudCalculatorTest {

    private WebDriver driver;
    private static final String SEARCH = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

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

//        double priceGoogleComputing = computingEnginePage.getCost();

        computingEnginePage.estimateViaEmail(email);

        driver.switchTo().window(tab10MinutEmail);

//        Assert.assertEquals();

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}