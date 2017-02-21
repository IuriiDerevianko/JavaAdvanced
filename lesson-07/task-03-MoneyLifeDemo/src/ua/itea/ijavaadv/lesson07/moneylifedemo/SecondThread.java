package ua.itea.ijavaadv.lesson07.moneylifedemo;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created
 * at 18:33
 * on 20.02.17
 * by Iurii Derevianko;
 */
public class SecondThread implements Runnable{
    Lock myLock;
    Condition moneyAvailable;
    Bank bank;

    public SecondThread(Lock myLock, Condition moneyAvailable, Bank bank){
        this.myLock = myLock;
        this.moneyAvailable = moneyAvailable;
        this.bank = bank;
    }

    @Override
    public void run() {

        try {
            myLock.lock();
            System.out.println("SecondLock lock: " + bank.getAccounts()[0].getBalance() + ";");
            bank.execute(new Transaction(Transaction.Type.CASH_REPLENISHMENT, 1, bank.getAccounts()[0], null));
            System.out.println("SecondLock: CASH_REPLENISHMENT;");
            moneyAvailable.signal();
            System.out.println("SecondLock signal: " + bank.getAccounts()[0].getBalance() + ";");
        } finally {
            myLock.unlock();
            System.out.println("SecondLock unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
        }

    }
}
