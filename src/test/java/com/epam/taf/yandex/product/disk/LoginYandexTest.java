package com.epam.taf.yandex.product.disk;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import taf.framework.bo.AccountFactory;
import taf.framework.driver.DriverSingleton;
import taf.yandex.product.disk.screen.*;
import taf.yandex.product.disk.service.AccountDiskService;
import taf.yandex.product.disk.service.AccountService;

public class LoginYandexTest {

    private YandexAccountPage yandexAccountPage;

    @Test(description = "Test Yandex Login")
    public void testYandexLogingPage() {
        yandexAccountPage = new AccountService()
                .signIn(AccountFactory.defaultAccount());
    }

    @Test(dependsOnMethods = {"testYandexLogingPage"})
    public void testYandexDisk() {
        YandexWordPage yandexWordPage = AccountDiskService.switchToDiskPage(yandexAccountPage);

        yandexWordPage
                .sendText("Hello world!")
                .waitSavingOfDocument();
        String documentName = yandexWordPage.getDocumentName();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
