package ua.itea.ijavaadv.lesson00.multithreading;
public class Multiplication implements Runnable {
    private int firstValue;
    private int secondValue;
    private static long resultValue;

    public Multiplication(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public void run(){
           resultValue = ((long)firstValue * (long)secondValue);
    }


    public static long getValue() {
        return resultValue;
    }
}
