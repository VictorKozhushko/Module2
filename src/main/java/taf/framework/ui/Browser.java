package taf.framework.ui;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import taf.framework.driver.DriverSingleton;
import taf.framework.loger.Log;

import java.io.File;
import java.io.IOException;

public class Browser {

    protected static WebDriver driver;

    protected Browser() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void makeScreenShot() {
        File screenshotFile = new File("logs/screenshots" + System.nanoTime() + "screenshot.png");
        try {
            File screenshotAsFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotAsFile, screenshotFile);
            Log.info("Screenshot taken: file:" + screenshotFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed screenshot: ", e);
        }
    }

    public void highlightElement(WebElement element) {
        String backgroundColor = element.getCssValue("backgroundColor");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        makeScreenShot();
        js.executeScript("arguments[0].style.backgroundColor = '" + backgroundColor + "'", element);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = DriverSingleton.getDriver();
        }
        return driver;
    }
}


