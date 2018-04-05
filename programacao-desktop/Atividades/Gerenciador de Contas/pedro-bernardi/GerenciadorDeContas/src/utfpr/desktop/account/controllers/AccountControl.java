package utfpr.desktop.account.controllers;

import utfpr.desktop.account.controllers.core.Client;

import java.util.ArrayList;

public class AccountControl {
    private ArrayList<Client> accounts = new ArrayList<>();

    public String listAccounts() {
        String accountsList="";
        for(Client account :  accounts)
            accountsList+= account.toString() + "\n";
        return accountsList;
    }

    public void removeAccount(int numberAccount) {
        for(Client account :  accounts)
            if (account.getId() == numberAccount)
                accounts.remove(account);
    }

    public void updateName(int numberAccount, String newHolder) {
        for(Client account :  accounts)
            if (account.getId() == numberAccount)
                account.setHolder(newHolder);
    }

    public String searchSchedule(int numberAccount) {
        for(Client account :  accounts)
            if (account.getId() == numberAccount)
                return  account.getAgency();
        return null;
    }

    public double searchBalance(int numberAccount) {
        for(Client account :  accounts)
            if (account.getId() == numberAccount)
                return account.getBalance();
        return Double.MAX_VALUE+1;
    }

    public void createAccount(String holder, String agency, double balance) {
        accounts.add(new Client(balance,agency,holder));
    }
}
