package ua.itea.ijavaadv.lesson07.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Account[] accounts;

    public static Bank loadMyBank() {
        Bank bank = new Bank();
        final String[] NAMES = {"Noah", "Liam", "Mason", "Jacob", "William",
                "Ethan", "Emma", "Olivia", "Sophia", "Isabella", "Ava", "Mia",
                "Emily", "Abigail", "Madison", "Charlotte", "Harper", "Sofia", "Avery", "Elizabeth"};
        bank.accounts = new Account[NAMES.length];
        for (int i = 0; i < NAMES.length; i++) {
            bank.accounts[i] = new Account(NAMES[i], 10_000);
        }
        return bank;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public long getTotalBalance() {
        long sum = 0;
        for (Account account : accounts) {
            sum += account.getBalance();
        }
        return sum;
    }

    public synchronized void execute(Transaction transaction) {
        Lock myFirstLock = new ReentrantLock();
        switch (transaction.getType()) {
            case TRANSFER:
                long srcBal = transaction.getSource().getBalance();
                srcBal -= transaction.getAmount();
                transaction.getSource().setBalance(srcBal);
                long destBal = transaction.getDestination().getBalance();
                destBal += transaction.getAmount();
                transaction.getDestination().setBalance(destBal);
                break;
            case CASH_REPLENISHMENT:
                try {
                    myFirstLock.lock();
                    long balance = transaction.getSource().getBalance();
                    balance += transaction.getAmount();
                    transaction.getSource().setBalance(balance);
                } finally{
                    myFirstLock.unlock();
                }
                break;
            case CASH_WITHDRAWAL:
                /* NOT IMPLEMENTED YET */
            break;
        }
    }
}