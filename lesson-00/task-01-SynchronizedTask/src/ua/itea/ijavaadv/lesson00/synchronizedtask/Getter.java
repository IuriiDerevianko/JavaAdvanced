package ua.itea.ijavaadv.lesson00.synchronizedtask;
public class Getter extends Thread {

    private GrowableList list;

    static class State {
        long sum;
        int index;
    }

    private static State state = new State();

    public Getter(GrowableList list) {
        this.list = list;
    }

    @Override
    public synchronized void run() {
        synchronized(list) {
            Object el = list.get(state.index++);
            System.out.println("index = " + state.index + ", " + "value = " + el + ";");
            state.sum += (Integer) el;
        }
    }

    public synchronized static long getSum() {
        return state.sum;
    }
}
