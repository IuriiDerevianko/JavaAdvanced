package ua.itea.ijavaadv.lesson04.hashmapdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created
 * at 13:44
 * on 11.02.17
 * by Iurii Derevianko;
 *
 *
 * HashMapDemo. Добавить пару пар (K, V).
 * a) При итерировании по entrySet сделать в Map перевод значений на English language с entrySetValue.
 *    if Человек1 -> Human1;
 * b) Проитерироваться по коллекции значений и поудалять все пустые значения == null;
 *
 */

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("car"," ");
        dictionary.put("money"," ");
        dictionary.put("work"," ");
        dictionary.put("mission"," ");

        System.out.println("Dictionary (En/Ru) is:\n");

//        Iterator<Map.Entry<String, String>> itr = dictionary.entrySet().iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }

        Set<Map.Entry<String, String>> set = dictionary.entrySet();
        for(Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + " = " + entry.getValue() + ";");
        }
        System.out.println("\nSize dictionary is " + dictionary.size() + " a couple of words;");

        //a)
        System.out.println("\na)");
        set = dictionary.entrySet();
        for(Map.Entry<String, String> entry : set) {
            if(entry.getKey() == "money") {
                entry.setValue("деньги");
            }
            else {
                if (entry.getKey() == "work") {
                    entry.setValue("работа");
                } else {
                    if (entry.getKey() == "mission") {
                        entry.setValue("миссия");
                    } else {
                        entry.setValue(null);
                    }
                }
            }
        }
        for(Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + " = " + entry.getValue() + ";");
        }

        //b)
        System.out.println("\nb)");
        Iterator iterator = dictionary.values().iterator();
        while(iterator.hasNext()) {
           if(iterator.next() == null) {
               iterator.remove();
           }
        }

        System.out.println("Result dictionary (En/Ru) is:\n");
        set = dictionary.entrySet();
        for(Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + " = " + entry.getValue() + ";");
        }
    }
}
