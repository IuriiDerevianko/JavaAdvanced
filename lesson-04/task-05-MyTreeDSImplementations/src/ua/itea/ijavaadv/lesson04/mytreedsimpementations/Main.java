//I
package ua.itea.ijavaadv.lesson04.mytreedsimpementations;
import java.util.*;
import com.google.common.collect.*;

/**
 * Created
 * at 22:30
 * on 07.02.17
 * by Iurii Derevianko;
 *
 * MyTreeDSImplementations
 * MyNavigableMultiMap
 *
 */


public class Main {
    public static void main(String[] args) {

        MyNavigableMultiMap multiMap = new MyNavigableMultiMap();


        System.out.println(multiMap.put(1, new Integer[] {new Integer(1), new Integer(2)}));
        System.out.println(multiMap.put(1, new Integer[] {new Integer(1), new Integer(2)}));
        System.out.println(multiMap.put(2, new Integer[] {new Integer(1), new Integer(2), new Integer(3)}));
        System.out.println(multiMap.put(3, new Integer[] {new Integer(1), new Integer(2), new Integer(3), new Integer(4)}));
        System.out.println( multiMap.size());

        System.out.println("Hello my new commit");

    }
}
