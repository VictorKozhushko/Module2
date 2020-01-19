package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

    protected static WebDriver driver;
    private static final String RESOURCES_PATH = "src\\test\\resources\\";

    @BeforeMethod
    public static void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public static void stopBrowser() {
        DriverSingleton.closeDriver();
    }

}
