package taf.framework.bo;

public class AccountFactory {

    public static Account defaultAccount(){
        Account account = new Account();
        account.setLogin("vikozhushko@yandex.ru");
        account.setPassword("vic_TAR");
        return account;
    }
}
