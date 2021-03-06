//D
package ua.itea.ijavaadv.lesson07.moneylifedemo;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;
import ua.itea.ijavaadv.lesson07.bank.TransactionProcessor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created
 * at 14:08
 * on 20.02.17
 * by Iurii Derevianko;
 *
 * Для проекта Bank реализовать MoneyLifeDemo по циклическому пополнению аккаунта из одного потока
 * и циклическому снятию средств из другого. Чередовать вывод на консоль диагностических сообщений
 * с небольшой задержкой Thread.sleep(..).
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



        //MoneyLifeDemo;

        Lock myLock = new ReentrantLock();
        Condition moneyAvailable = myLock.newCondition();

        for (int i = 0; i < 5; i++) {
            new Thread(new FirstThread(myLock, moneyAvailable, bank)).start();
            Thread.sleep(1000);
            new Thread(new SecondThread(myLock, moneyAvailable, bank)).start();
            Thread.sleep(1000);
        }
    }
}
