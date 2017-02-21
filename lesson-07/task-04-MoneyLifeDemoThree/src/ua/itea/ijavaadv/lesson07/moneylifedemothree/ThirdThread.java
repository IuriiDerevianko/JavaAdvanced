package ua.itea.ijavaadv.lesson07.moneylifedemothree;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created
 * at 22:14
 * on 21.02.17
 * by Iurii Derevianko;
 */
public class ThirdThread implements Runnable {
    Lock myLock;
    Condition moneyAvailable;
    Bank bank;

    public ThirdThread(Lock myLock, Condition moneyAvailable, Bank bank){
        this.myLock = myLock;
        this.moneyAvailable = moneyAvailable;
        this.bank = bank;
    }

    @Override
    public void run(){

        try {
            myLock.lock();
            System.out.println("ThirdLock lock: " + bank.getAccounts()[0].getBalance() + ";");
            while (bank.getAccounts()[0].getBalance() <= 11000) {
                System.out.println("ThirdLock await: " + bank.getAccounts()[0].getBalance() + ";");
                moneyAvailable.await();
            }
            bank.execute(new Transaction(Transaction.Type.CASH_WITHDRAWAL, 1, bank.getAccounts()[0], null));
            System.out.println("ThirdLock: CASH_WITHDRAWAL;" );
        } catch (Exception e){

        } finally {
            myLock.unlock();
            System.out.println("ThirdLock unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
        }
    }
}
