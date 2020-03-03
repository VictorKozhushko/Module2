package taf.framework.ui;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taf.framework.driver.DriverSingleton;
import taf.framework.loger.Log;

import java.io.File;
import java.io.IOException;

public final class Browser implements WrapsDriver {

    protected static WebDriver driver;

    private static final int ELEMENT_VISIBILITY_TIMEOUT_SECONDS = 10;

    private static ThreadLocal<Browser> instance = new ThreadLocal<>();

    public static synchronized Browser getInstance() {
        if (instance.get() == null) {
            instance.set(new Browser());
        }
        return instance.get();
    }

    protected Browser() {
        driver = BrowserFactory.getBrowser();
    }

    public void stopBrowser() {
        try {
            if (getDriver() != null) {
                getDriver().quit();
            }
        } catch (WebDriverException exc) {
            Log.info("Exception during closing browser " + exc.getMessage());
        } finally {
            instance.set(null);
        }
    }

    public void type(By by, String text) {
        Log.info("Text " + text + " inserter into " + by.toString());
        WebElement webElement = waitWebElement(by);
        highlightElement(webElement);
        webElement.sendKeys(text);
    }

    public void click(By by) {
        Log.info("Locator " + by.toString() + " is clicked");
        WebElement webElement = waitWebElement(by);
        highlightElement(webElement);
        webElement.click();
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

    public WebElement waitWebElement(By locator) {
        return new WebDriverWait(driver, ELEMENT_VISIBILITY_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = DriverSingleton.getDriver();
        }
        return driver;
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driver;
    }
}


