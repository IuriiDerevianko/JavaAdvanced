package ua.itea.ijavaadv.lesson09.bilderpattern;

/**
 * Created
 * at 13:39
 * on 27.02.17
 * by Iurii Derevianko;
 */

public class HTMLReportBuilder {
    private Report report;

    public HTMLReportBuilder create() {
        report = new Report();
        return this;
    }

    public HTMLReportBuilder setReportType(TypeReport typeReport) {
        report.typeReport = typeReport;
        return this;
    }

    public Report build() {
        return report;
    }
}
