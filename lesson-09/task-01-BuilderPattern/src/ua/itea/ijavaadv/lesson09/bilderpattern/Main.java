package ua.itea.ijavaadv.lesson09.bilderpattern;

/**
 * Created
 * at 14:51
 * on 27.02.17
 * by Iurii Derevianko;
 *
 * Builder Pattern. BugReportSystem.
 * Создать "сложный" объект, который является продуктом.
 * Имеем входной текстовый файл (xxx.txt), список багов имеющих свои идентификаторы.
 * Формат текстового файла выбираем произвольно. Выбрали XXX.txt.
 * Текстовый файл нужно порадить объектом. После пораждения парсим и пораждаем HTML или XML
 * в зависимости от выбора пользователя.
 * Два конкретных билдера XML и HTML конвертер.
 * В точке входа в программу (psvm) пользователь выбирает какой билдер создать XML или HTML. Затем передаем
 * в конструктор Director(<<interface>> Builder). Конструктор универсальный и принимает запрс на создание
 * как XML так и HTML файла.
 *
 */

public class Main {
    public static void main(String[] args) {
        Director firstDirector = new Director();
        firstDirector.setBuilder(new XMLReportBuilder());
        Report firstReport = firstDirector.buildReport();
        System.out.println(firstReport);

        Director secondDirector = new Director();
        secondDirector.setBuilder(new HTMLReportBuilder());
        Report secondReport = secondDirector.buildReport();
        System.out.println(secondReport);
    }
}
