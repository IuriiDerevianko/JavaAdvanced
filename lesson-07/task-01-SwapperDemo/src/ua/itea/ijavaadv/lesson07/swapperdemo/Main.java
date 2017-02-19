package ua.itea.ijavaadv.lesson07.swapperdemo;

/**
 * Created
 * at 14:46
 * on 19.02.17
 * by Iurii Derevianko;
 */
public class Main {
    private static int a = 1;
    private static int b = 2;

    static class Swapper implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                int t = a;
                a = b;
                b = t;
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Swapper()).start();
        new Thread(new Swapper()).start();
        new Thread(new Swapper()).start();
        System.out.println(a + " " + b);
    }
}
