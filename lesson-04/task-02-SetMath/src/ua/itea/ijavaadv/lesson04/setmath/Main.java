//D
package ua.itea.ijavaadv.lesson04.setmath;

import java.util.HashSet;
import java.util.Set;

/**
 * Created
 * at 18:06
 * on 07.02.17
 * by Iurii Derevianko;
 *
 * SetMath. Напишите класс с методами принимающими два множества
 * и возвращающими другое множество в соответствии с изображением.
 *
 * (*(*)*)  Union/Союз
 * ( (*) )  Intersection/В точке пересечения
 * (*( )*)  Difference/Разница
 *
 */
public class Main {
    public static void main(String[] args) {
        Set<Object> firstSet = new HashSet<>();
        firstSet.add(1);
        firstSet.add(2);
        firstSet.add(3);
        firstSet.add(4);
        firstSet.add(5);
        firstSet.add(6);
        firstSet.add(7);

        Set<Object> secondSet = new HashSet<>();
        secondSet.add(5);
        secondSet.add(6);
        secondSet.add(7);
        secondSet.add(8);
        secondSet.add(9);
        secondSet.add(10);

        System.out.println("FirstSet is: ");
        System.out.println(firstSet);

        System.out.println("\nSecondSet is: ");
        System.out.println(secondSet);

        System.out.println("\nResult union() is: ");
        System.out.println(SetMath.union(firstSet, secondSet));

        System.out.println("\nResult intersection() is: ");
        System.out.println(SetMath.intersection(firstSet, secondSet));

        System.out.println("\nResult difference() is: ");
        System.out.println(SetMath.difference(firstSet, secondSet));
    }
}
