package vn.funix.fx20512.java.asm02.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<Account>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremium() {
        for ( int i=0; i < getAccounts().size(); i++) {
            if (getAccounts().get(i).isPremium()) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(Account account) {
            this.accounts.add(account);
    }

    public double getBalance() {
        double balance = 0;
        for (int i=0; i<getAccounts().size(); i++) {
            balance += getAccounts().get(i).getBalance();
        }
        return balance;
    }

    public void displayInformation() {
        String a;
        if (isPremium()) {
            a = "Premium";
        } else {
            a = "Normal";
        }

        System.out.print(getCustomerId() + " |");
        System.out.printf("%12s", getName() + " |");
        System.out.printf("%10s", a + " |");
        String b = String.format("%,.2f", getBalance());
        System.out.printf("%15s", b + "đ\n");

        for (int i=0; i<accounts.size(); i++) {
            String c = String.format("%,.2f",accounts.get(i).getBalance());
            System.out.printf((i+1) + "     " + accounts.get(i).getAccountNumber() + " |"+ "%37s",c + "đ" + "\n");
        }
    }
}
