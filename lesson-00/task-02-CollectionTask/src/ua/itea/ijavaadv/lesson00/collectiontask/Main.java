//D
package ua.itea.ijavaadv.lesson00.collectiontask;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        /**
         * Изучить/разобрать:
         *
         * java.util.Iterator
         * java.util.Set
         * java.util.Map
         * MyHashMap
         * MyHashSet
         * MyIterator
         */

        //HashSet;
        System.out.println("\tSource array: ");
        String[] brand = {"Intel", "Dell", "Apple", "IBM", "LG", "Dell"};
        List<String> brandList = Arrays.asList(brand);
        System.out.printf("%s \n\n", brandList + ";");

        System.out.println("\tHashSet array:");
        Set<String> set = new HashSet<String>(brandList);
        System.out.printf("%s \n", set + ";");
        set.add("Google");
        set.add("Dell");
        set.add("IBM");
        System.out.printf("%s \n", set + ";");
        System.out.println("Size is: " + set.size() + ";");
        set.remove("IBM");
        System.out.printf("%s \n", set + ";");
        set.removeAll(set);
        System.out.printf("%s \n", set + ";");
        System.out.println("isEmpty: " + set.isEmpty() + ";");
        System.out.println("------------------------------------------------------------");

        //Iterator;
        System.out.println("\tUse iterator:");
        set = new HashSet<String>(brandList);
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()) {
            String element = itr.next();
            System.out.println(element + " ");
        }
        System.out.println("------------------------------------------------------------");

        //HashMap;
        System.out.println("\tHashMap array:");
        Map<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "Intel");
        hashMap.put(2, "Dell");
        hashMap.put(3, "Apple");
        hashMap.put(4, "IBM");
        hashMap.put(5, "LG");
        hashMap.put(6, "Dell");
        hashMap.put(1, "Google");

        System.out.println("key 1: " + hashMap.get(1) + ";");
        System.out.println("key 6: " + hashMap.get(6) + ";");
        hashMap.remove(6);
        System.out.println("key 6: " + hashMap.get(6) + ";");
        System.out.println("Size is: " + hashMap.size() + ";");

        System.out.println("Keys are:");
        Set<Integer> keys = hashMap.keySet();
        for(Integer k : keys){
            System.out.print(k + " ");
        }
        System.out.print(";\n");

        System.out.println("Values are:");
        for(String v : hashMap.values()){
            System.out.print(v + " ");
        }
        System.out.print(";\n");
    }
}
