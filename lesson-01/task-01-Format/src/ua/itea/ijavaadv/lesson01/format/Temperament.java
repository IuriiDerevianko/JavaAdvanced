package ua.itea.ijavaadv.lesson01.format;
public enum Temperament {
    SANGUINE, PHLEGMATIC, SUPINE, CHOLERIC, MELANCHOLIC;
    public boolean isEqualsTo(Temperament another) {
        boolean result = (this == another);
        return result;
    }
}
