package ua.itea.ijavaadv.lesson07.bankexecutorservice;

import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;
import ua.itea.ijavaadv.lesson07.bank.TransactionProcessor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created
 * at 15:22
 * on 23.02.17
 * by Iurii Derevianko;
 *
 * Скопировать и модифицировать Bank: запускать обработку транзакций при помощи ExecutorService.
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Bank bank = Bank.loadMyBank();

        System.out.println(bank.getAccounts()[0].getBalance());  // Account balance BEFORE replenishment;
        Transaction[] list = new Transaction[] {
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 120, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 80, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 160, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 240, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 300, bank.getAccounts()[0], null),
                new Transaction(Transaction.Type.CASH_REPLENISHMENT, 100, bank.getAccounts()[0], null),
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Thread(new TransactionProcessor(list, bank)));
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        System.out.println(bank.getAccounts()[0].getBalance());   // Account balance AFTER replenishment;
    }
}
