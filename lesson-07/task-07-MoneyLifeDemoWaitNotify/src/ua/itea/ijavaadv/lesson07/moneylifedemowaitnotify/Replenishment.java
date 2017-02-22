package ua.itea.ijavaadv.lesson07.moneylifedemowaitnotify;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

/**
 * Created
 * at 23:45
 * on 22.02.17
 * by Iurii Derevianko;
 */
public class Replenishment implements Runnable{
    private Bank bank;
    private int amount;
    private int isFull = 25_000;

    public Replenishment(Bank bank, int amount){
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public synchronized void run() {
        System.out.println("Replenishment mode lock: " + bank.getAccounts()[0].getBalance() + ";");
        if((bank.getAccounts()[0].getBalance() + amount) <= isFull) {
            bank.execute(new Transaction(Transaction.Type.CASH_REPLENISHMENT, amount, bank.getAccounts()[0], null));
            System.out.println("Replenishment mode: CASH_REPLENISHMENT;");
        } else {
            System.out.println("Replenishment mode is full: " + bank.getAccounts()[0].getBalance() + ";");
        }
        System.out.println("Replenishment mode unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
    }
}