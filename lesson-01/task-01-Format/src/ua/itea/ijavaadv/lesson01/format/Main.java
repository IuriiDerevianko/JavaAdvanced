//D
package ua.itea.ijavaadv.lesson01.format;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;


/**
 * Created
 * at 00:00
 * on 28.01.17
 * by Iurii Derevianko;
 *
 *
 * 1. Format. Дополнить класс Person внутренним enum (формат) с константами SHORT, MEDIUM, LONG
 *    и возможностью печатать Person в указанный PrintStream (например System.out или System.err),
 *    в указанном (одном из трех) формате. Выводимые поля и их конечный формат выберите на свое усмотрение.
 *    Дата рождения человека должна выводится в принятом у нас формате (в нашей локале).
 *
 *  2. Format. Дополнить класс Person реализацией ин-фейса Formattable для вывода через %s;
 *
 * [3. Format. При форматировании учитывать FormattableFlags
 *
 */


public class Main {
    public static void main(String[] args) {
        Person[] personArray = {
                new Person("Iurii", "Derevianko", 25, true, new Date((1991-1900), (3-1), 23), Temperament.SANGUINE, new PhoneNumber((short)38, 95, 895, 7760)),
                new Person("Iurii", "Derevianko", 24, true, new Date((1991-1900), (3-1), 23), Temperament.SANGUINE, new PhoneNumber((short)38, 95, 895, 7760)),
                new Person("Aurii", "Derevianko", 24, true, new Date((1991-1900), (3-1), 23), Temperament.SANGUINE, new PhoneNumber((short)38, 95, 895, 7760)),
                new Person("Aurii", "Arevianko", 24, true, new Date((1991-1900), (3-1), 23), Temperament.SANGUINE, new PhoneNumber((short)38, 95, 895, 7760)),
                new Person("Iurii", "Arevianko", 24, true, new Date((1991-1900), (3-1), 23), Temperament.SANGUINE, new PhoneNumber((short)38, 95, 895, 7760)),
                new Person("firstName", "lastName", 25, false, new Date((1991-1900), (1-1), 1), Temperament.PHLEGMATIC, new PhoneNumber((short)38, 50, 123, 4567)),
                new Person("firstName", "lastName", 24, true, new Date((1991-1900), (1-1), 2), Temperament.SUPINE, new PhoneNumber((short)38, 67, 123, 4567)),
                new Person("firstName", "lastName", 25, false, new Date((1991-1900), (1-1), 3), Temperament.CHOLERIC, new PhoneNumber((short)38, 93, 123, 4567)),
                new Person("firstName", "lastName", 25, true, new Date((1991-1900), (1-1), 4), Temperament.MELANCHOLIC, new PhoneNumber((short)38, 44, 123, 4567))
        };
        System.out.println(Arrays.toString(personArray));
        System.out.println();

        Arrays.sort(personArray, new PersonComparator());
        System.out.println(Arrays.toString(personArray));
        System.out.println("----------------------------------------------------------------------------------------------");


        //1.Formatter;
        System.out.println("\t1.Formatter:");
        Formatter formatter = new Formatter(System.out);
        for (int i = 0; i < personArray.length; i++) {
            formatter.format(new Locale("ua", "ua"), Person.PersonFormat.SHORT.mood(), personArray[i].getArgs());
        }
        System.out.println();

        for (int i = 0; i < personArray.length; i++) {
        formatter.format(new Locale("ua", "ua"), Person.PersonFormat.MEDIUM.mood(), personArray[i].getArgs());
        }
        System.out.println();

        for (int i = 0; i < personArray.length; i++) {
            formatter.format(new Locale("ua", "ua"), Person.PersonFormat.LONG.mood(), personArray[i].getArgs());
        }
        System.out.println();


        //2.Formattable;
        System.out.println("\t2.Formattable:");
        for (int i = 0; i < personArray.length; i++) {
            System.out.printf("%s", personArray[i]);
        }
        System.out.println();


        //[3.FormattableFlags;
        System.out.println("\t[3.FormattableFlags:");
        for (int i = 0; i < personArray.length; i++) {
            formatter.format("%1$-15s %2$-20s, %5$-15tD, %3$+05d = %3$#x = %3$#o (years)     , %4$-10B, %6$-15s, %7$s;%n", personArray[i].getArgs());
        }
        System.out.println();
        formatter.close();
    }
}
