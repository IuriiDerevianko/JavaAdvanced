//D
package ua.itea.ijavaadv.lesson07.moneylifedemowaitnotify;

import ua.itea.ijavaadv.lesson07.bank.Bank;

/**
 * Created
 * at 23:39
 * on 22.02.17
 * by Iurii Derevianko;
 *
 * WaitNotify. Скопировать и модифицировать ранее написанный код использующий условные переменные (Condition of the
 * java.util.concurrent package) на способ использующий методы общие для всех Java объектов.
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = Bank.loadMyBank();
        System.out.println("Account balance BEFORE replenishment/withdrawal: " + bank.getAccounts()[0].getBalance() + ";\n");

        for (int i = 0; i < 4; i++) {
            new Thread(new Withdrawal(bank, 10_000, 0)).start();
            Thread.sleep(500);

            new Thread(new Replenishment(bank, 5_000, 25_000)).start();
            Thread.sleep(500);
        }
    }
}