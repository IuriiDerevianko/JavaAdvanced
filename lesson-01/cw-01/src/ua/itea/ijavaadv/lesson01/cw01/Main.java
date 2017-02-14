package ua.itea.ijavaadv.lesson01.cw01;

import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.printf("%h %n", "Hello World");
        System.out.printf("%H %n", "Hello World");
        System.out.printf("%s %n", null);
        System.out.printf("%s %n", new Date());
        double real = Math.PI;
        System.out.printf(new Locale("ua", "ua"), "%20.10f %n", real);
        System.out.printf("%tC %n", new Date());
        System.out.printf("%s %n", new Date(2020-1900, 4-1, 1));
        System.out.printf("%s %n", new Date(-1999, 4-1, 1));


    }
}
