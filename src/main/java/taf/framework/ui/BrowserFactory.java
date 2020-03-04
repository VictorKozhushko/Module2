package taf.framework.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import taf.framework.runner.Parameters;

import java.util.concurrent.TimeUnit;

import static taf.framework.ui.BrowserType.CHROME;

public class BrowserFactory {

    private BrowserFactory() {
    }

    public static WebDriver getBrowser() {
        WebDriver webDriver;
        switch (Parameters.instance().getBrowserType()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Parameters.instance().getBrowserType());
        }
        configure(webDriver);
        return webDriver;
    }

    private static void configure(WebDriver webDriver){
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }
}
