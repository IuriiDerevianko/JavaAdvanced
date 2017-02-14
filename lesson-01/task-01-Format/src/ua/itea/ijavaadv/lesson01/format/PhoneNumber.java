package ua.itea.ijavaadv.lesson01.format;
public class PhoneNumber {
    private short countryCode;
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(short countryCode, int areaCode, int prefix, int lineNumber) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public PhoneNumber(PhoneNumber other) {
        this.countryCode = other.countryCode;
        this.areaCode = other.areaCode;
        this.prefix = other.prefix;
        this.lineNumber = other.lineNumber;
    }

    @Override
    public String toString() {
        return String.format("+%d(%03d) %03d-%04d", countryCode, areaCode, prefix, lineNumber);
    }

    public short getCountryCode() {
        return countryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public int hashCode() {
        return 3 * countryCode +  5 * areaCode + 7 * prefix + 9 * lineNumber;
    }
}