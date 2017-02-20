package ua.itea.ijavaadv.lesson07.bank;

public class TransactionProcessor implements Runnable {
    private Transaction[] list;
    private Bank bank;

    public  TransactionProcessor(Transaction[] list, Bank bank) {
            this.list = list;
            this.bank = bank;
    }

    @Override
    public void run() {
        for (Transaction t : list) {
            bank.execute(t);
        }
    }
}