package ua.itea.ijavaadv.lesson07.moneylifedemothree;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created
 * at 22:17
 * on 21.02.17
 * by Iurii Derevianko;
 */
public class FourthThread implements Runnable {
    Lock myLock;
    Condition moneyAvailable;
    Bank bank;

    public FourthThread(Lock myLock, Condition moneyAvailable, Bank bank){
        this.myLock = myLock;
        this.moneyAvailable = moneyAvailable;
        this.bank = bank;
    }

    @Override
    public void run() {

        try {
            myLock.lock();
            System.out.println("FourthLock lock: " + bank.getAccounts()[0].getBalance() + ";");
            bank.execute(new Transaction(Transaction.Type.CASH_REPLENISHMENT, 4, bank.getAccounts()[0], null));
            System.out.println("FourthLock: CASH_REPLENISHMENT;");
            moneyAvailable.signalAll();
            System.out.println("FourthLock signal all: " + bank.getAccounts()[0].getBalance() + ";");
        } finally {
            myLock.unlock();
            System.out.println("FourthLock unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
        }
    }
}
