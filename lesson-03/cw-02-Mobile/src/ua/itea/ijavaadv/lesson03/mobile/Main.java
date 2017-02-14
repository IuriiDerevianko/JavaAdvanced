package ua.itea.ijavaadv.lesson03.mobile;

/**
 * Created by derevianko on 04.02.17.
 *
 * 1. Объявить перем. массивного типа и присвоить ей список всех констант.
 * 2. Проитерировать, вывести название этой константы: марку с ценой.
 * 3. Присвоить final переменную получить порядковый номер, строковое представление имени константы,
 * 4. Объявите новую переменную х и присвоить значение ... со строково представления в тип.
 *
 */
public class Main {
    public static void main(String[] args) {

        //1.
        Mobile[] array = Mobile.values();

        //2.
        for (Mobile m : array) {
            System.out.println(m.ordinal() + ". " + m + " = " + m.getPrice() + ";");
        }
        System.out.println();

        //3.
        Mobile a = Mobile.IPHONE;
        System.out.println(a.ordinal());
        String s = Mobile.IPHONE.name();
        System.out.println(s);
        System.out.println();

        //4.
        Mobile b = Mobile.valueOf(s);
        System.out.println(b.ordinal() + ". " + b + " = " + b.getPrice() + ";");
    }
}
