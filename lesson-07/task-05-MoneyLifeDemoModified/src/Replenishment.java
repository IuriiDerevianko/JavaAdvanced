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
    private int isFull = 25_000;

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
            System.out.println("Replenishment mode lock: " + bank.getAccounts()[0].getBalance() + ";");
            if((bank.getAccounts()[0].getBalance() + amount) <= isFull) {
                bank.execute(new Transaction(Transaction.Type.CASH_REPLENISHMENT, amount, bank.getAccounts()[0], null));
                System.out.println("Replenishment mode: CASH_REPLENISHMENT;");
            } else {
                System.out.println("Replenishment mode is full: " + bank.getAccounts()[0].getBalance() + ";");
            }
            moneyAvailable.signal();
            System.out.println("Replenishment mode signal: " + bank.getAccounts()[0].getBalance() + ";");
        }finally {
            myLock.unlock();
            System.out.println("Replenishment mode unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
        }
    }
}