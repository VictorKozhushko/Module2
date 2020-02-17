package taf.yandex.product.disk.service;

import taf.framework.bo.Account;
import taf.yandex.product.disk.screen.YandexAccountPage;
import taf.yandex.product.disk.screen.YandexHomePage;

public class AccountService {
    public YandexAccountPage signIn(Account account) {
        YandexAccountPage yandexAccountPage = new YandexHomePage()
                .loginToYandex()
                .loginToAccound(account.getLogin())
                .loginPasswordAccount(account.getPassword());
        return yandexAccountPage;
    }
}
