package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import resources.*;

import java.util.concurrent.TimeUnit;

public class LoginYandexTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        YandexLogInAccountPage yandexLogInAccountPage = new YandexHomePage(driver).loginToYandex();
        YandexLogInPasswordPage yandexLogInPasswordPage = yandexLogInAccountPage.loginToAccound();
        Thread.sleep(1000);
        YandexAccountPage yandexAccountPage = yandexLogInPasswordPage.loginAccount();
        Thread.sleep(2000);
        YandexDiskPage yandexDiskPage = yandexAccountPage.switchToDisk();
        Thread.sleep(1000);
                yandexDiskPage.createFile();

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
