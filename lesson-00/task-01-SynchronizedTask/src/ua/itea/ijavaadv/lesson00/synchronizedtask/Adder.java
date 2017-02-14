package ua.itea.ijavaadv.lesson00.synchronizedtask;
public class Adder extends Thread {

    private GrowableList list;

    public Adder(GrowableList list) {
        this.list = list;
    }

    @Override
    public synchronized void run() {
        list.add(Main.ELEMENT);
    }
}
