import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created
 * at 23:15
 * on 21.02.17
 * by Iurii Derevianko;
 */
public class Replenishment implements Runnable{
    private Lock myLock;
    private Condition moneyAvailable;
    private Bank bank;
    private int amount;

    public Replenishment(Lock myLock, Condition moneyAvailable, Bank bank, int amount){
        this.myLock = myLock;
        this.moneyAvailable = moneyAvailable;
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {

        try {
            myLock.lock();
            System.out.println("Replenishment lock: " + bank.getAccounts()[0].getBalance() + ";");
            bank.execute(new Transaction(Transaction.Type.CASH_REPLENISHMENT, 5_000, bank.getAccounts()[0], null));
            System.out.println("Replenishment: CASH_REPLENISHMENT;");
            moneyAvailable.signalAll();
            System.out.println("Replenishment signal: " + bank.getAccounts()[0].getBalance() + ";");
        } finally {
            myLock.unlock();
            System.out.println("Replenishment unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
        }
    }
}