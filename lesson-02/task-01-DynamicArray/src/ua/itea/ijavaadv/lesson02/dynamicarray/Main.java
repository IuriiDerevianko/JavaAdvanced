//D
package ua.itea.ijavaadv.lesson02.dynamicarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 1.pro/generics/dynamic-array. Дано: generic array T[] and T element. Написать статический метод для подсчета количества
 * элементов в массиве меньших чем данный элемент. Будет ли тип T типом возвращаемого значения метода?
 *
 * 2.pro/generics/dynamic-array. Дополнить Array. Написать метод, который принимает коллекцию чисел, возвращает
 * отсортированный список чисел из каждого элемента которого вычли число, соответствующее среднему арифметическому
 * младших 16 разрядов элементов исходной collection. Соблюдать контроль типов на этапе компиляции. Исходная коллекция
 * должна состоять только из сравниваемых элементов типа: AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double,
 * DoubleAccumulator, DoubleAdder,Float, Integer, Long, LongAccumulator, LongAdder, Short или наследника какого-либо
 * вышеперечисленных классов.
 *
 */

public class Main {
    public static void main(String[] args) {
        //1.
        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer integerElement = new Integer(7);
        DynamicArray<Integer> dynamicIntegerArray = new DynamicArray<Integer>(integerArray, integerElement);
        System.out.println("T[] array is: " + Arrays.toString(integerArray) + ";");
        System.out.println("T[] array type is: " + integerArray.getClass().getSimpleName() +";");
        System.out.println();
        System.out.println("T element is: " + integerElement + ";");
        System.out.println("T element type is: " + integerElement.getClass().getSimpleName() +";");
        System.out.println();
        System.out.println("countLessElement is: " + dynamicIntegerArray.countLessElement() + ";");
        System.out.println();

        Double[] doubleArray = new Double[]{1.1, 2.2, 3.3, 4.4, 5.5, 6.7, 7.6, 8.8, 9.9, 10.1};
        Double doubleElement = new Double(7.7);
        DynamicArray<Double> dynamicDoubleArray = new DynamicArray<Double>(doubleArray, doubleElement);
        System.out.println("T[] array is: " + Arrays.toString(doubleArray) + ";");
        System.out.println("T[] array type is: " + doubleArray.getClass().getSimpleName() +";");
        System.out.println();
        System.out.println("T element is: " + doubleElement + ";");
        System.out.println("T element type is: " + doubleElement.getClass().getSimpleName() +";");
        System.out.println();
        System.out.println("countLessElement is: " + dynamicDoubleArray.countLessElement() + ";");
        System.out.println();
        System.out.println();


        //2.
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.round(Math.random() * 100_000)));
        }
        System.out.println("Collection<T> list is: " + list + ";");
        System.out.println("Collection<T> list type is: " + list.getClass().getSimpleName() +";");
        DynamicArray<Integer> dynamicIntegerCollection = new DynamicArray<Integer>(list);
        System.out.println("Collection<T> result list is: " +  dynamicIntegerCollection.substractionSortArray());
    }
}
