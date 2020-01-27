package com.epam.ta.page;

import com.epam.ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

}
