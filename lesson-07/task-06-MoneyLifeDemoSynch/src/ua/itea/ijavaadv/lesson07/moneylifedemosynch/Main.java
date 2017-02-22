package ua.itea.ijavaadv.lesson07.moneylifedemosynch;

import ua.itea.ijavaadv.lesson07.bank.Bank;

/**
 * Created
 * at 23:06
 * on 22.02.17
 * by Iurii Derevianko;
 *
 * Synchronized. Скопировать и модифицировать ранее написанный код применяющий блокировки java.util.cuncurrent
 * на более коипактный способ с применением ключевого слова synchronized.
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = Bank.loadMyBank();
        System.out.println("Account balance BEFORE replenishment/withdrawal: " + bank.getAccounts()[0].getBalance() + ";\n");


        for (int i = 0; i < 5; i++) {
            new Thread(new Withdrawal(bank, 5_000)).start();
            Thread.sleep(500);

            new Thread(new Replenishment(bank, 10_000)).start();
            Thread.sleep(500);
        }
    }
}