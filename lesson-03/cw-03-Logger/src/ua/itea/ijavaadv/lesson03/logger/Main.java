package ua.itea.ijavaadv.lesson03.logger;

import java.util.logging.Logger;

/**
 * Created by derevianko on 04.02.17.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        //logger.log(Level.INFO, "Iurii Derevianko!");
        logger.warning("Iurii Derevianko!");
        logger.warning("Iurii Derevianko!");

        Runnable runnable = System.out::println;        //лямда ссылка на метод;
        new Thread(runnable).start();
    }
}
