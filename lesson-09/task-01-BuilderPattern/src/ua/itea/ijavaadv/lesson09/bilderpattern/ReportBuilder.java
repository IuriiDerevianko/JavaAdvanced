package ua.itea.ijavaadv.lesson09.bilderpattern;

/**
 * Created
 * at 14:16
 * on 27.02.17
 * by Iurii Derevianko;
 */
abstract class ReportBuilder {

    Report report;

    void createReport() {
        report = new Report();
    }

    abstract void setTypeReport();

    Report getReport() {
        return report;
    }
}
