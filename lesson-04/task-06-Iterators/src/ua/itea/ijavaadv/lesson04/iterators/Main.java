//D
package ua.itea.ijavaadv.lesson04.iterators;

import ua.itea.ijavaadv.lesson01.format.Person;
import ua.itea.ijavaadv.lesson01.format.PhoneNumber;
import ua.itea.ijavaadv.lesson01.format.Temperament;
import java.util.*;

/**
 * Created
 * at 17:48
 * on 08.02.17
 * by Iurii Derevianko;
 *
 *
 * Iterators. Написать метод filter(..) который принимает множество Person и параметр возраст.
 * Возвращает новое множество, содержащее только людей равных и старше указаного возраста.
 * Продемонстрировать использование.
 *
 */

public class Main {

    static Set<Person> filter(Set<Person> personSet, int age) {
        Set<Person> resultSet = new HashSet<>();
        Iterator<Person> iterator = personSet.iterator();
        Person personTemp;
        while (iterator.hasNext()) {
            personTemp = iterator.next();
            if(personTemp.getAge() >= age) {
                resultSet.add(personTemp);
            }
        }
        return resultSet;

    }
    public static void main(String[] args) {

        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Iurii", "Derevianko", 25, true, new Date((1991-1900), (3-1), 23), Temperament.SANGUINE, new PhoneNumber((short)38, 95, 895, 7760)));
        personSet.add(new Person("firstName", "lastName", 26, false, new Date((1991-1900), (1-1), 1), Temperament.PHLEGMATIC, new PhoneNumber((short)38, 50, 123, 4567)));
        personSet.add(new Person("firstName", "lastName", 27, true, new Date((1990-1900), (1-1), 2), Temperament.SUPINE, new PhoneNumber((short)38, 67, 123, 4567)));
        personSet.add( new Person("firstName", "lastName", 23, false, new Date((1992-1900), (1-1), 3), Temperament.CHOLERIC, new PhoneNumber((short)38, 93, 123, 4567)));
        personSet.add( new Person("firstName", "lastName", 24, true, new Date((1991-1900), (1-1), 4), Temperament.MELANCHOLIC, new PhoneNumber((short)38, 44, 123, 4567)));



        System.out.println("\tSource Set is: ");
        Iterator<Person> iterator = personSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        Set<Person> set = filter(personSet, 25);
        System.out.println("\n\tResult Set is: ");
        iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
