package ua.itea.ijavaadv.lesson03.unmodifiable;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();
        List listSecond = Collections.unmodifiableList(list);
        //listSecond.add(123);

    }
}
