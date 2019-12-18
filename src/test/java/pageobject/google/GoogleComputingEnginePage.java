package pageobject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement cost;

    @FindBy(xpath = "//button[@ng-click='cloudCartCtrl.showEmailForm();']")
    private WebElement emailEstimate;

    @FindBy(xpath = "//iframe[@id = 'myFrame']")
    private WebElement frameEmailEstimate;

    @FindBy(xpath = "//input[@id='input_412']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmail;

    public GoogleComputingEnginePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitGoogleComputingEngineElement(WebElement webElement) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public GoogleComputingEnginePage fillForm() {
        driver.switchTo().frame(0);
        driver.manage().window().maximize();
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        selectMachineType.click();
        waitGoogleComputingEngineElement(selectn1standart8);
        selectn1standart8.click();
        selectAddGPU.click();
        selectGPUNumber.click();
        select1GPU.click();
        waitGoogleComputingEngineElement(selectSSD);
        selectSSD.click();
        waitGoogleComputingEngineElement(select2x375);
        select2x375.click();
        selectCenterLocation.click();
        waitGoogleComputingEngineElement(selectFrankfurt);
        selectFrankfurt.click();
        selectCommittedUsage.click();
        waitGoogleComputingEngineElement(select1Year);
        select1Year.click();
        return this;
    }

    public String getCost() {
        driver.switchTo().frame(0);
        addToEstimate.click();
        waitGoogleComputingEngineElement(cost);
        String string = cost.getText();
        String words[] = string.split(" ");
        return words[4];
    }

    public GoogleComputingEnginePage estimateViaEmail(String emailAddress) {

        waitGoogleComputingEngineElement(emailEstimate);
        emailEstimate.click();
        waitGoogleComputingEngineElement(emailField);
        emailField.click();
        emailField.sendKeys(emailAddress);
        sendEmail.click();
        return this;
    }

}
