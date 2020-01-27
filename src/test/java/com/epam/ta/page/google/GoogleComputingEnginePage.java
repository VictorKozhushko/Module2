package com.epam.ta.page.google;

import com.epam.ta.page.AbstractPage;
import com.epam.ta.service.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleComputingEnginePage extends AbstractPage {

    @FindBy(xpath = "//input[@id='input_53']")
    private WebElement numberOfInstances;

    @FindBy(id = "select_option_218")
    private WebElement selectStandart8;

    @FindBy(xpath = "//div[@class='md-container md-ink-ripple']")
    private WebElement selectAddGPU;

    @FindBy(id = "select_value_label_50")
    private WebElement selectMachineType;

    @FindBy(id = "select_option_210")
    private WebElement selectn1standart8;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_349']")
    private WebElement selectGPUNumber;

    @FindBy(xpath = "//md-option[@class='ng-scope md-ink-ripple' and @id='select_option_356']")
    private WebElement select1GPU;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_350']")
    private WebElement selectGPU;

    @FindBy(xpath = "//md-option[@id='select_option_363']")
    private WebElement selectTeslaV100;

    @FindBy(id = "select_value_label_171")
    private WebElement selectSSD;

    @FindBy(id = "select_option_232")
    private WebElement select2x375;

    @FindBy(id = "select_value_label_51")
    private WebElement selectCenterLocation;

    @FindBy(id = "select_option_181")
    private WebElement selectFrankfurt;

    @FindBy(id = "select_option_185")
    private WebElement selectOsaka;

    @FindBy(id = "select_value_label_52")
    private WebElement selectCommittedUsage;

    @FindBy(id = "select_option_85")
    private WebElement select1Year;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement cost;

    @FindBy(xpath = "//button[@ng-click='cloudCartCtrl.showEmailForm();']")
    private WebElement emailEstimate;

    @FindBy(xpath = "//iframe[@id = 'myFrame']")
    private WebElement frameEmailEstimate;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmail;

    protected GoogleComputingEnginePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void waitGoogleComputingEngineElement(WebElement webElement) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public GoogleComputingEnginePage fillForm() {
        driver.switchTo().frame(0);
        waitGoogleComputingEngineElement(numberOfInstances);
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

        switch (TestDataReader.getTestData("place")) {
            case "frankfurt":
                waitGoogleComputingEngineElement(selectFrankfurt);
                selectFrankfurt.click();
                break;
            case "osaka":
                waitGoogleComputingEngineElement(selectOsaka);
                selectOsaka.click();
                break;
        }

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
        String[] words = string.split(" ");
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
