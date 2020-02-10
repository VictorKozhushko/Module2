package tat.framework.ui;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tat.framework.driver.DriverSingleton;
import tat.framework.loger.Log;
import tat.framework.screen.BasePage;

import java.io.File;
import java.io.IOException;

public class Browser extends BasePage {

    private static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod
    public static void closeBrowser(){
        DriverSingleton.closeDriver();
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

    public void highlightFrame(WebElement element) {
        String bachgroundColor = element.getCssValue("backgroundColor");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        makeScreenShot();
        js.executeScript("arguments[0].style.backgroundColor = '" + bachgroundColor + "'", element);
    }

    public WebDriver getDriver() {
        return driver;
    }
}


