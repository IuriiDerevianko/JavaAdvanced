import ua.itea.ijavaadv.lesson07.bank.Bank;
import ua.itea.ijavaadv.lesson07.bank.Transaction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created
 * at 23:12
 * on 21.02.17
 * by Iurii Derevianko;
 */
public class Withdrawal implements Runnable {
    private Lock myLock;
    private Condition moneyAvailable;
    private Bank bank;
    private int amount;

    public Withdrawal(Lock myLock, Condition moneyAvailable, Bank bank, int amount){
        this.myLock = myLock;
        this.moneyAvailable = moneyAvailable;
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run(){

        try {
            myLock.lock();
            System.out.println("Withdrawal lock: " + bank.getAccounts()[0].getBalance() + ";");
            while ((bank.getAccounts()[0].getBalance() - amount) < 0) {
                System.out.println("Withdrawal await: " + bank.getAccounts()[0].getBalance() + ";");
                moneyAvailable.await();
            }
            bank.execute(new Transaction(Transaction.Type.CASH_WITHDRAWAL, 10_000, bank.getAccounts()[0], null));
            System.out.println("Withdrawal: CASH_WITHDRAWAL;" );
        } catch (Exception e){

        } finally {
            myLock.unlock();
            System.out.println("Withdrawal unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
        }
    }
}

