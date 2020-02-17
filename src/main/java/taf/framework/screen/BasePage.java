package taf.framework.screen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import taf.framework.driver.DriverSingleton;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

}
