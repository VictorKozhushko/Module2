import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.GoogleCloudHomePage;
import pageobject.GoogleComputingEnginePage;
import pageobject.GoogleSearchResultsPage;

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

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}