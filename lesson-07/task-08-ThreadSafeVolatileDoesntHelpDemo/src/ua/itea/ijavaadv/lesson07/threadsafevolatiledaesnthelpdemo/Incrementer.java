package ua.itea.ijavaadv.lesson07.threadsafevolatiledaesnthelpdemo;

/**
 * Created
 * at 15:02
 * on 23.02.17
 * by Iurii Derevianko;
 */

public class Incrementer implements Runnable {
    private MiniBox box;

    public Incrementer(MiniBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        synchronized (box) {
            box.value++;
            System.out.println(box.value);
        }
    }
}


