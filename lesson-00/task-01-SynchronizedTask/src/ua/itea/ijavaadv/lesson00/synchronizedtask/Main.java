//D
package ua.itea.ijavaadv.lesson00.synchronizedtask;
public class Main {

    private static final int ELEMENTS_COUNT = 100;
    public static final Integer ELEMENT = 10;

    public static void main(String[] args) throws InterruptedException {
        GrowableList list = new DynamicArray();
        GrowableList adders = new DynamicArray();
        GrowableList getters = new DynamicArray();


        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            Adder adder = new Adder(list);
            adders.add(adder);
            adder.start();
        }

        joinAll(adders);

        long startTimeSingle = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            Object e = list.get(i);
            if (e == null) {
                throw new AssertionError(i);
            }
            int val = ((Integer) e).intValue();
            sum += val;
        }
        long estimatedTimeSingle = System.nanoTime() - startTimeSingle;
        System.out.println("Single thread sum = " + sum + ";");
        System.out.println("Runtime in single thread mode is: " + estimatedTimeSingle + " ns;\n");

        long startTimeMulti = System.nanoTime();
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            Getter getter = new Getter(list);
            getters.add(getter);
            getter.start();
        }
        joinAll(getters);
        long estimatedTimeMulti = System.nanoTime() - startTimeMulti;
        System.out.println("\nMulti thread sum = " + Getter.getSum() + ";");
        System.out.println("Runtime in multi thread mode is: " + estimatedTimeMulti + " ns;");
        System.out.println("\nMulti threading/Single threading = " +
                + estimatedTimeMulti/estimatedTimeSingle + ";");


    }

    private synchronized static void joinAll(GrowableList threads) throws InterruptedException {
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            Thread thread;
            thread = (Thread) threads.get(i);
            thread.join();
        }
    }
}
