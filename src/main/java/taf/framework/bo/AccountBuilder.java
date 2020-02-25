package taf.framework.bo;

public class AccountBuilder {

    private Account account;

    public AccountBuilder login(String login){
        account.setLogin(login);
        return this;
    }

    public AccountBuilder password(String password){
        account.setPassword(password);
        return this;
    }

    public Account build(){
        return account;
    }
}
