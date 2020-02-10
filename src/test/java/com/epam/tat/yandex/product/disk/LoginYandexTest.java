package com.epam.tat.yandex.product.disk;

import org.testng.annotations.Test;
import tat.framework.bo.AccountFactory;
import tat.yandex.product.disk.screen.*;
import tat.yandex.product.disk.service.AccountDisk;
import tat.yandex.product.disk.service.AccountService;

public class LoginYandexTest {

    private YandexAccountPage yandexAccountPage;

    @Test(description = "Test Yandex Login")
    public void testYandexLogingPage() {
        new AccountService()
                .signIn(AccountFactory.defaultAccount());
    }

    @Test(dependsOnMethods = {"testYandexLogingPage"})
    public void testYandexDisk() {
        new AccountDisk().switchToDisk();
        YandexWordPage yandexWordPage = new YandexWordPage();
        yandexWordPage.sendText("Hello world!").waitSavingOfDocument();
        String documentName = yandexWordPage.getDocumentName();
//        driver.close();
//        driver.switchTo().window(yandexDriver);
//        yandexDiskPage.deleteFile(documentName);
    }

//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown() {
//        driver.quit();
//        driver = null;
//    }
}
