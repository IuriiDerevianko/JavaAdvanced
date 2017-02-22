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
    private int isEmty = 0;

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
            System.out.println("Withdrawal mode lock: " + bank.getAccounts()[0].getBalance() + ";");
            while ((bank.getAccounts()[0].getBalance() - amount) < isEmty) {
                System.out.println("Withdrawal mode await (WAITING mode): " + bank.getAccounts()[0].getBalance() + ";");
                moneyAvailable.await();
            }
            bank.execute(new Transaction(Transaction.Type.CASH_WITHDRAWAL, amount, bank.getAccounts()[0], null));
            System.out.println("Withdrawal mode: CASH_WITHDRAWAL;" );
        } catch (Exception e){

        } finally {
            myLock.unlock();
            System.out.println("Withdrawal mode unlock: " + bank.getAccounts()[0].getBalance() + ";\n");
        }
    }
}

