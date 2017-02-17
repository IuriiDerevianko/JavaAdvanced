//D
package ua.itea.ijavaadv.lesson03.tryingOutList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Created
     * at 19:02
     * on 02.02.17
     * by Iurii Derevianko;
     *
     *
     * TryingOutList. Работа с ArrayList через интерфейс List.
     * Написать свой метод  asList(..) для конвертации массива строк, чисел в список.
     * Написать метод printRm(..), который создаст список (List) чисел, положит в него
     * 10 элементов, затем удалит первые 3 и последний, а затем выведет результат на экран.
     *
     */

    static ArrayList list;

    public static List asList(String[] array){
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public static void printRm(){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.round(Math.random() * 100)));
        }
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(6);
        System.out.println(list);
    }

    public static void main(String[] args) {
        list = new ArrayList<String>();
        String[] array = {"qwerty", "asdfgh", "zxcvbn"};
        System.out.println(asList(array));
        printRm();
    }
}
