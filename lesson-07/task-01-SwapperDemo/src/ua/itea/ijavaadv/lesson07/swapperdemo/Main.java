//D
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
    private static Integer count = 0;


    static class Swapper implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                int t = a;
                a = b;
                b = t;
            }
//            System.out.println(a + " " + b);    // a = 1; b = 2;
        }
    }

    public static void main(String[] args) throws InterruptedException {

/*
        for (int i = 0; i < 10; i++) {
            synchronized (count) {
                new Thread(new Swapper()).start();
                new Thread(new Swapper()).start();
                new Thread(new Swapper()).start();
                System.out.println(a + " " + b);
                if ((a == 1) && (b == 2)) count++;
                new Thread().sleep(500);
                a = 1;
                b = 2;
            }
        }
        System.out.println("Probability is: " + (double)count/10 +";");
        */

        new Thread(new Swapper()).start();
        new Thread(new Swapper()).start();
        new Thread(new Swapper()).start();
        System.out.println(a + " " + b);

    }
}
