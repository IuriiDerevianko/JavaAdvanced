package ua.itea.ijavaadv.lesson07.moneylifedemowaitnotify;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

/**
 * Created
 * at 23:46
 * on 22.02.17
 * by Iurii Derevianko;
 */
public class Withdrawal implements Runnable {

    private Bank bank;
    private int amount;
    private int isEmpty;

    public Withdrawal(Bank bank, int amount, int isEmpty){
        this.bank = bank;
        this.amount = amount;
        this.isEmpty = isEmpty;
    }

    @Override
    public void run(){
        synchronized (bank) {
            try {
                System.out.println("Withdrawal mode lock: " + bank.getAccounts()[0].getBalance() + ";");
                if ((bank.getAccounts()[0].getBalance() - amount) < isEmpty) {
                    System.out.println("Withdrawal mode await (WAITING mode): " + bank.getAccounts()[0].getBalance() + ";");
                    bank.wait();
                } else {
                    bank.execute(new Transaction(Transaction.Type.CASH_WITHDRAWAL, amount, bank.getAccounts()[0], null));
                    System.out.println("Withdrawal mode: CASH_WITHDRAWAL;");
                }
                System.out.println("Withdrawal mode unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

