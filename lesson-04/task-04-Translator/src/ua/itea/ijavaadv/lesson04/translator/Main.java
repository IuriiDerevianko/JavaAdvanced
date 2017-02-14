//D
package ua.itea.ijavaadv.lesson04.translator;

import java.util.*;

/**
 * Created
 * at 22:23
 * on 07.02.17
 * by Iurii Derevianko;
 *
 * Translator. Написать программу переводчик, которая будет переводить текст,
 * написанный на одном языке, на другой язык согласно заранее составленному словарю.
 *
 */
public class Main {
    public static void main(String[] args) {

        Map<String, String > dictionary = new HashMap<>();
        dictionary.put("car","машина");
        dictionary.put("home","дом");
        dictionary.put("children","дети");
        dictionary.put("wife","жена");
        dictionary.put("money","деньги");
        dictionary.put("work","работа");
        dictionary.put("mission","миссия");


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

        System.out.println("\nPlease enter your English word.");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();


        if(dictionary.get(word) != null) {
            System.out.println("Translate \"" + word.toUpperCase() + "\" is \"" + dictionary.get(word).toUpperCase() + "\";");
        } else {
            System.out.println("Translate \"" + word.toUpperCase() + "\" is NOT FOUND;");
        }
    }
}
