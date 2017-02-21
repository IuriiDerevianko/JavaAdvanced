package ua.itea.ijavaadv.lesson07.moneylifedemo;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created
 * at 18:32
 * on 20.02.17
 * by Iurii Derevianko;
 *
 */
public class FirstThread implements Runnable{
    Lock myLock;
    Condition moneyAvailable;
    Bank bank;

    public FirstThread(Lock myLock, Condition moneyAvailable, Bank bank){
        this.myLock = myLock;
        this.moneyAvailable = moneyAvailable;
        this.bank = bank;
    }

    @Override
    public void run(){

        try {
            myLock.lock();
            System.out.println("FirstLock lock: " + bank.getAccounts()[0].getBalance() + ";");
            while (bank.getAccounts()[0].getBalance() <= 11000) {
                System.out.println("FirstLock await: " + bank.getAccounts()[0].getBalance() + ";");
                moneyAvailable.await();
            }
            bank.execute(new Transaction(Transaction.Type.CASH_WITHDRAWAL, 1, bank.getAccounts()[0], null));
            System.out.println("FirstLock: CASH_WITHDRAWAL;" );
        } catch (Exception e){

        } finally {
            myLock.unlock();
            System.out.println("FirstLock unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
        }
    }
}
