package ua.itea.ijavaadv.lesson09.bilderpattern;

/**
 * Created
 * at 15:08
 * on 24.02.17
 * by Iurii Derevianko;
 */

class Director {
    ReportBuilder builder;

    void setBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    Report buildReport() {
        builder.createReport();
        builder.setTypeReport();
        builder.getReport();
        Report report = builder.getReport();
        return report;
    }
}
