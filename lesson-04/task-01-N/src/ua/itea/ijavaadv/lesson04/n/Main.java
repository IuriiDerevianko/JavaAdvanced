//D
package ua.itea.ijavaadv.lesson04.n;
import java.util.*;

/**
 * Created
 * at 10:54
 * on 07.02.17
 * by Iurii Derevianko;
 *
 *
 * Реализовывать итератор во всех своих коллекциях.
 * Сделать список из трех элементов. Получить итератор.
 * a) удалить первый и последний элемент через ссылку на коллекцию;
 * b) закоментировать предыдущий вариант, реализовать a) через ссылку на итератор;
 * c) вывести коллекцию через итератор;
 * d) вывести в обратном порядке;
 * e) сгенерировать random длину [5; 15], заполнить random целыми элементами;
 *    среднесеметричному элементу установить значение макс. элемента, а затертый среднесеметричный добавить
 *    с помощью итератора методом add();
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        ListIterator<Integer> iterator = array.listIterator();

        //a)
//        array.remove(0);
//        array.remove(1);


        //b)

        //удаляем элемент по значению;
//        while (iterator.hasNext()) {
//            Integer i = iterator.next();
//            if(i == 1) iterator.remove();
//            if(i == 3) iterator.remove();
//        }

        //удаляем элемент по индексу;
//        while (iterator.hasNext()) {
//            if(iterator.nextIndex() == 0) {
//                iterator.next();
//                iterator.remove();
//                break;
//            } else iterator.next();
//        }
//        iterator = array.listIterator();
//        while (iterator.hasNext()) {
//            if(iterator.nextIndex() == 1) {
//                iterator.next();
//                iterator.remove();
//                break;
//            } else iterator.next();
//        }



        //c)
        System.out.println("\tc) Прямой порядок: ");
        iterator = array.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();


        //d)
        System.out.println("\td) Обратный порядок: ");
        while(iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println();

        //e)
        System.out.println("\te) Random array: ");
        int arrayLength = (int)(5 + Math.round(Math.random() * 10));
        List<Integer> randomArray = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            randomArray.add((int)(Math.round(Math.random() * 100)));
        }
        System.out.println("randomLength randomArray's is: " + arrayLength + ";");
        System.out.println("randomArray is: ");
        System.out.println(randomArray);

        ListIterator <Integer> randomArrayIterator = randomArray.listIterator();
        Integer max = randomArrayIterator.next();
        while(randomArrayIterator.hasNext()){
            if(randomArrayIterator.next() > max) {
                max = randomArrayIterator.previous();
            }
        }
        System.out.println("Max is: " + max + ";");

        int mark;
        if((arrayLength % 2) != 0) {
            mark = (arrayLength / 2 + 1);
        } else mark = arrayLength / 2;
        System.out.println("Mark is: " + mark + ";");

        randomArrayIterator = randomArray.listIterator();
        Integer temp = 0;
        while (randomArrayIterator.hasNext()) {
            if(randomArrayIterator.nextIndex() == (mark - 1)) {
                temp = randomArrayIterator.next();
            } else randomArrayIterator.next();
        }
        randomArrayIterator.add(temp);

        randomArrayIterator = randomArray.listIterator();
        while (randomArrayIterator.hasNext()) {
            if(randomArrayIterator.nextIndex() == (mark - 1)) {
                randomArrayIterator.next();
                randomArrayIterator.set(max);
                break;
            } else randomArrayIterator.next();
        }

        System.out.println("\nResult randomArray is: ");
        System.out.println(randomArray);

        randomArrayIterator = randomArray.listIterator();
        System.out.print("[");
        while (randomArrayIterator.hasNext()) {
            System.out.print(randomArrayIterator.next());
            if(randomArrayIterator.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}