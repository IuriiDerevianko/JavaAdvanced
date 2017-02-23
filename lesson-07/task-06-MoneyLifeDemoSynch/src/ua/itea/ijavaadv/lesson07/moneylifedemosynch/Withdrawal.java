package ua.itea.ijavaadv.lesson07.moneylifedemosynch;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

/**
 * Created
 * at 23:10
 * on 22.02.17
 * by Iurii Derevianko;
 */
public class Withdrawal implements Runnable {

    private Bank bank;
    private int amount;
    private int isEmpty = 0;

    public Withdrawal(Bank bank, int amount){
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public synchronized void run(){
        System.out.println("Withdrawal mode lock: " + bank.getAccounts()[0].getBalance() + ";");
        if((bank.getAccounts()[0].getBalance() - amount) < isEmpty) {
            System.out.println("Withdrawal mode await (WAITING mode): " + bank.getAccounts()[0].getBalance() + ";");
        } else {
            bank.execute(new Transaction(Transaction.Type.CASH_WITHDRAWAL, amount, bank.getAccounts()[0], null));
            System.out.println("Withdrawal mode: CASH_WITHDRAWAL;");
        }
        System.out.println("Withdrawal mode unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
    }
}

