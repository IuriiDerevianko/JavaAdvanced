//D
package ua.itea.ijavaadv.lesson04.queuewrapper;
import java.util.*;

/**
 * Created
 * at 21:25
 * on 07.02.17
 * by Iurii Derevianko;
 *
 *
 * QueueWrapper. Написать метод  asList(..) который принимает очередь любых generic элементов Queue,
 * но возвращает список List, при этом изменения вносимые в изначальную очередь отражаются на полученном списке.
 * Например, при удалении элемента из очереди, размер списка должен уменьшится на 1.
 *
 */
public class Main {

    static<T> List<T> asList(Queue<T> queue){
        List<T> list = (List)queue;
        return  list;
    }

    public static void main(String[] args) {
        Queue<Object> queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Input Queue is: ");
        System.out.println(queue);

        System.out.println("\nOutput List is: ");
        List<?> list = asList(queue);
        System.out.println(list);

        queue.remove(1);
        queue.remove(3);

        System.out.println("\nOutput modified List is: ");
        System.out.println(list);
    }
}
