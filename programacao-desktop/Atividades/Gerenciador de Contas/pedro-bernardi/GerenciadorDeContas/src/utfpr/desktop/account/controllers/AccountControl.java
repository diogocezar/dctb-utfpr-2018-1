package utfpr.desktop.account.controllers;

import utfpr.desktop.account.controllers.core.Client;
import java.util.ArrayList;

public class AccountControl {
    private ArrayList<Client> accounts = new ArrayList<>();

    /**
     * Metodo listar contas
     * @return lista de contas
     */
    public String listAccounts() {
        String accountsList = "";
        for (Client account : accounts)
            accountsList += account.toString() + "\n";
        return accountsList;
    }

    /**
     * Procurar conta em lista de conta
     * @param numberAccount recebe numero de conta
     * @return conta
     * @throws Exception caso não encontre a conta
     */
    public Client searchAccount(int numberAccount) throws Exception {
        for (Client account : accounts)
            if (account.getId() == numberAccount)
                return account;
        throw new Exception("Invalid Account");
    }

    /**
     * Remover conta atraves de busca em {@link #searchAccount(int)}
     * @param numberAccount numero da conta
     * @throws Exception caso não encontre a conta
     */
    public void removeAccount(int numberAccount) throws Exception {
        accounts.remove(searchAccount(numberAccount));
    }

    /**
     * Atualizar titulo atraves de busca em {@link #searchAccount(int)}
     * @param numberAccount numero da conta
     * @param newHolder novo nome da titulo
     * @throws Exception caso não encontre a conta
     */
    public void updateName(int numberAccount, String newHolder) throws Exception {
        searchAccount(numberAccount).setHolder(newHolder);
    }

    /**
     * Procurar agencia de conta atraves de busca em {@link #searchAccount(int)}
     * @param numberAccount numero da conta
     * @return agencia
     * @throws Exception caso não encontre a conta
     */
    public String searchSchedule(int numberAccount) throws Exception {
        return searchAccount(numberAccount).getAgency();
    }

    /**
     * Mostar saldo de conta atraves de busca em {@link #searchAccount(int)}
     * @param numberAccount numero da conta
     * @return saldo
     * @throws Exception caso não encontre a conta
     */
    public double searchBalance(int numberAccount) throws Exception {
        return searchAccount(numberAccount).getBalance();
    }

    /**
     * Criar conta
     * @param holder titulo
     * @param agency agencia
     * @param balance saldo
     */
    public void createAccount(String holder, String agency, double balance) {
        accounts.add(new Client(balance, agency, holder));
    }
}
