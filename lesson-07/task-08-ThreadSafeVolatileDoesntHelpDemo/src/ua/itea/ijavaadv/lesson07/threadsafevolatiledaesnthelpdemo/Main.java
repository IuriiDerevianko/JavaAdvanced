//D
package ua.itea.ijavaadv.lesson07.threadsafevolatiledaesnthelpdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created
 * at 14:56
 * on 23.02.17
 * by Iurii Derevianko;
 *
 * ThreadSafeVolatileDoesntHelpDemo. Локализовать и исправить (или написать как исправить Th...DemoFix.txt)
 * ошибку в программе VolatileDoesntHelpDemo не применяя что-либо из java.util.concurrent.atomic.
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int N = 100;
        MiniBox box = new MiniBox();

        ExecutorService executor = Executors.newFixedThreadPool(N);
        System.out.println("---start---");
        for (int i = 0; i < N; i++) {
            executor.execute(new Incrementer(box));
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("---end---");
    }
}
