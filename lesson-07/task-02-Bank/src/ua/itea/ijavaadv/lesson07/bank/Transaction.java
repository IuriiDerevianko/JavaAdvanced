package ua.itea.ijavaadv.lesson07.bank;

public class Transaction {

    private Type type;
    private long amount;
    private Account source;
    /**
     * This field should be {@code null} when transaction type is CASH_REPLENISHMENT or CASH_WITHDRAWAL
     */
    private Account destination;

    public enum Type {
        CASH_REPLENISHMENT, CASH_WITHDRAWAL, TRANSFER;
    }

    public Transaction(Type type, long amount, Account source, Account destination) {
        this.type = type;
        this.amount = amount;
        this.source = source;
        this.destination = destination;
    }

    public Type getType() {
        return type;
    }

    public long getAmount() {
        return amount;
    }

    public Account getSource() {
        return source;
    }

    public Account getDestination() {
        return destination;
    }
}