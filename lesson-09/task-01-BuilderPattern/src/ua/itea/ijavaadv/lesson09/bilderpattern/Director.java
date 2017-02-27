package ua.itea.ijavaadv.lesson09.bilderpattern;

/**
 * Created
 * at 15:08
 * on 24.02.17
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

public class Director {
    public static void main(String[] args) {
        XMLReportBuilder builder = new XMLReportBuilder();
        Report report = builder.create()
                .setReportType(TypeReport.XML)
                .build();

    }
}
