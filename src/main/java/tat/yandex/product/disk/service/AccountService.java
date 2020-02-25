package tat.yandex.product.disk.service;

import tat.framework.bo.Account;
import tat.yandex.product.disk.screen.YandexHomePage;

public class AccountService {
    public void signIn(Account account) {
        new YandexHomePage()
                .loginToYandex()
                .loginToAccound(account.getLogin())
                .loginAccount(account.getPassword());
    }
}
