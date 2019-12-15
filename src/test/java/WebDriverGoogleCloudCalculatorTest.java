import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.GoogleCloudHomePage;
import pageobject.GoogleComputingEnginePage;
import pageobject.GoogleSearchResultsPage;
import pageobject.TenMinutEmailPage;

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

        String tabGoogleComputing = driver.getWindowHandle();

        String a = "window.open(\"https://10minutemail.com\",'_blank');";
        ((JavascriptExecutor) driver).executeScript(a);

        TenMinutEmailPage tenMinutEmailPage = new TenMinutEmailPage(driver);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        tabs.remove(tabGoogleComputing);
        String tab10Minutes = tabs.get(0);

        driver.switchTo().window(tab10Minutes);

        String email = tenMinutEmailPage.getEmailAddress();

        driver.switchTo().window(tabGoogleComputing);

        computingEnginePage.estimateViaEmail(email);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}