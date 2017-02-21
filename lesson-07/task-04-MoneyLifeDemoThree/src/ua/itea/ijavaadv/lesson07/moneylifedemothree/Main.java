//D
package ua.itea.ijavaadv.lesson07.moneylifedemothree;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;
import ua.itea.ijavaadv.lesson07.bank.TransactionProcessor;
import ua.itea.ijavaadv.lesson07.moneylifedemo.FirstThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created
 * at 21:39
 * on 21.02.17
 * by Iurii Derevianko;
 *
 * Скопировать и модифицировать MoneyLifeDemo:
 * 3 потока снимающих деньги,
 * 1 поток пополняющий.
 * Применить блокировки.
 *
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = Bank.loadMyBank();

        System.out.println(bank.getAccounts()[0].getBalance());  // my account balance BEFORE replenishment
        Transaction[] list = new Transaction[] {
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 120, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 80, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 160, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 240, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 300, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 100, bank.getAccounts()[0], null),
        };

        Thread[] threads = new Thread[list.length];
        for (int i = 0; i < threads.length; i++) {
            Transaction[] sublist = new Transaction[]{list[i]};
            threads[i] = new Thread(new TransactionProcessor(sublist, bank));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
        // Thread.sleep(1000); // it won't help!
        System.out.println(bank.getAccounts()[0].getBalance());   // my account balance AFTER replenishment



        //MoneyLifeDemoThree;

        Lock myLock = new ReentrantLock();
        Condition moneyAvailable = myLock.newCondition();

        for (int i = 0; i < 3; i++) {
            new Thread(new FirstThread(myLock, moneyAvailable, bank)).start();
            Thread.sleep(1000);
            new Thread(new SecondThread(myLock, moneyAvailable, bank)).start();
            Thread.sleep(1000);
            new Thread(new ThirdThread(myLock, moneyAvailable, bank)).start();
            Thread.sleep(1000);
            new Thread(new FourthThread(myLock, moneyAvailable, bank)).start();
            Thread.sleep(1000);
        }
    }
}
