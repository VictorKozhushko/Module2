package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleComputingEnginePage {

    private WebDriver driver;

    @FindBy(id = "input_54")
    private WebElement numberOfInstances;

    @FindBy(id = "select_option_218")
    private WebElement selectStandart8;

    @FindBy(xpath = "//div[@class='md-container md-ink-ripple']")
    private WebElement selectAddGPU;

    @FindBy(id = "select_value_label_51")
    private WebElement selectMachineType;

    @FindBy(id = "select_option_210")
    private WebElement selectn1standart8;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_348']")
    private WebElement selectGPUNumber;

    @FindBy(xpath = "//md-option[@class='ng-scope md-ink-ripple' and @id='select_option_355']")
    private WebElement select1GPU;

    @FindBy(id = "select_value_label_170")
    private WebElement selectSSD;

    @FindBy(id = "select_option_232")
    private WebElement select2x375;

    @FindBy(id = "select_value_label_52")
    private WebElement selectCenterLocation;

    @FindBy(id = "select_option_180")
    private WebElement selectFrankfurt;

    @FindBy(id = "select_value_label_53")
    private WebElement selectCommittedUsage;

    @FindBy(id = "select_option_84")
    private WebElement select1Year;

    @FindBy(xpath = "//button[text()='Add to Estimate' and not(disabled='disabled')]")
    private WebElement addToEstimate;

    @FindBy(xpath = "//button[text()='Email Estimate']")
    private WebElement emailEstimate;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailQuote;

    @FindBy(xpath = "//input[@id='input_340'")
    private WebElement emailField;

    public GoogleComputingEnginePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleComputingEnginePage fillForm() {
//        selectAddGPU.click();

        driver.switchTo().frame(0);
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        selectMachineType.click();
        new WebDriverWait(driver, 5);
        selectn1standart8.click();
        selectAddGPU.click();
        selectGPUNumber.click();
        select1GPU.click();
        selectSSD.click();
        select2x375.click();
        selectCenterLocation.click();
        new WebDriverWait(driver, 10);
        selectFrankfurt.click();
        new WebDriverWait(driver, 10);
        selectCommittedUsage.click();
        new WebDriverWait(driver, 10);
        select1Year.click();
        addToEstimate.click();
        return this;
    }

    public GoogleComputingEnginePage estimateViaEmail(String emailAddress) {
        driver.switchTo().frame(0);
        addToEstimate.submit();
        emailEstimate.click();
        emailQuote.click();
        emailField.click();
        emailField.sendKeys(emailAddress);
        return this;
    }

}
