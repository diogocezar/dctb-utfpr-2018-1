package utfpr.desktop.account.controllers.core;

import java.util.Date;

public class Client {
    private int id;
    private static int count = 0;
    private double balance;
    private String agency;
    private String holder;
    private Date dateCreated;

    /**
     *  Criar conta com id auto incremental e data de criação
     * @param balance saldo
     * @param agency agencia
     * @param holder titulo
     */
    public Client(double balance, String agency, String holder) {
        this.id = ++count;
        this.balance = balance;
        this.agency = agency;
        this.holder = holder;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getAgency() {
        return agency;
    }

    public String getHolder() {
        return holder;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", balance=" + balance +
                ", agency='" + agency + '\'' +
                ", holder='" + holder + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
