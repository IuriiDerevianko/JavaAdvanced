//I
import ua.itea.ijavaadv.lesson07.bank.Bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created
 * at 22:40
 * on 21.02.17
 * by Iurii Derevianko;
 *
 * Скопировать и модифицировать MoneyLifeDemo: применить условные переменные (имя должно отражать состояние,
 * например: isEmpty, isFull, sufficientBytes, bufferChanged, dataArrived). Поток снимающий деньги со счета,
 * не должен производить отрицательный баланс, вместо этого поток должен переходить в состояние WAITING и ожидать
 * поступления новых средств. Поток, пополняющий счет, не должен производить пополнение если деньги на счету
 * "не упали ниже критичекого уровня". Уровень определить по собственному усмотрению.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = Bank.loadMyBank();
        System.out.println("Account balance BEFORE replenishment/withdrawal: " + bank.getAccounts()[0].getBalance() + ";\n");

        Lock myLock = new ReentrantLock();
        Condition moneyAvailable = myLock.newCondition();

        for (int i = 0; i < 5; i++) {
            new Thread(new Withdrawal(myLock, moneyAvailable, bank, 5_000)).start();
            Thread.sleep(1500);

            new Thread(new Replenishment(myLock, moneyAvailable, bank, 10_000)).start();
            Thread.sleep(500);
        }
    }
}