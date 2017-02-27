package ua.itea.ijavaadv.lesson09.bilderpattern;

/**
 * Created
 * at 13:55
 * on 27.02.17
 * by Iurii Derevianko;
 */

public class XMLReportBuilder {
    private Report report;

    public XMLReportBuilder create() {
        report = new Report();
        return this;
    }

    public XMLReportBuilder setReportType(TypeReport typeReport) {
        report.typeReport = typeReport;
        return this;
    }

    public Report build() {
        return report;
    }
}
