package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleComputingEnginePage {

    private WebDriver driver;

    @FindBy(id = "input_53")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//div[@class='md-ripple-container']")
    private WebElement selectAddGPU;

    public GoogleComputingEnginePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleComputingEnginePage fillForm() {
//        selectAddGPU.click();
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        return this;
    }
}
