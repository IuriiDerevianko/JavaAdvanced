package ua.itea.ijavaadv.lesson03.mobile;

/**
 *
 * Present mobile constants.
 *
 * @author Iurii Derevianko
 * @version 1.0
 * @since 2017-02-04
 *
 */

//javadoc -d ./docs -sourcepath ./src -subpackages .


public enum Mobile {
    IPHONE(30_000), GALAXY(20_000), PIXEL(10_000);

    private int price;

    Mobile(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}