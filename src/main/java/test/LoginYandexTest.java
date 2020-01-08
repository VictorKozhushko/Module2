package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taf.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginYandexTest {

    private WebDriver driver;
    private YandexAccountPage yandexAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Test Yandex Login")
    public void testYandexLogingPage() {

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        YandexLogInAccountPage yandexLogInAccountPage = new YandexHomePage(driver).loginToYandex();
        YandexLogInPasswordPage yandexLogInPasswordPage = yandexLogInAccountPage.loginToAccound();
        yandexAccountPage = yandexLogInPasswordPage.loginAccount();
    }

    @Test(dependsOnMethods = {"testYandexLogingPage"})
    public void testYandexDisk() {

        String yandexTab = driver.getWindowHandle();

        YandexDiskPage yandexDiskPage = yandexAccountPage.switchToDisk();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        tabs.remove(yandexTab);
        String yandexDriver = tabs.get(0);

        driver.switchTo().window(yandexDriver);

        String yandexWordTab;

        YandexWord yandexWord = yandexDiskPage.createFile();
        tabs = new ArrayList<>(driver.getWindowHandles());

        tabs.remove(yandexTab);
        tabs.remove(yandexDriver);
        yandexWordTab = tabs.get(0);

        driver.switchTo().window(yandexWordTab);
        By frame = By.tagName("iframe");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(frame));
        driver.switchTo().frame(0);

        yandexWord.sendText("Hello world!").waitSavingOfDocument();

        String documentName = yandexWord.getDocumentName();
        driver.close();
        driver.switchTo().window(yandexDriver);
        yandexDiskPage.deleteFile(documentName);
    }

//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown() {
//        driver.quit();
//        driver = null;
//    }
}
