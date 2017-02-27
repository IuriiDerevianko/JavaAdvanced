package ua.itea.ijavaadv.lesson09.bilderpattern;

/**
 * Created
 * at 13:35
 * on 27.02.17
 * by Iurii Derevianko;
 */

class Report {
    private TypeReport typeReport;

    void setTypeReport(TypeReport typeReport) {
        this.typeReport = typeReport;
    }

    @Override
    public String toString(){
        return "Report [TypeReport is: " + typeReport + "];";
    }
}
