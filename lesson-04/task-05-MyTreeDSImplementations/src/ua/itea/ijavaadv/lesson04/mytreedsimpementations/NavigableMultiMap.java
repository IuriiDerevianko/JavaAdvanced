package ua.itea.ijavaadv.lesson04.mytreedsimpementations;

/**
 * Created
 * at 22:52
 * on 11.02.17
 * by Iurii Derevianko;
 */

public interface NavigableMultiMap {

    public boolean put(Object o, Object[] o2);

    public int get(Object o);

    public int size();

    public boolean isEmpty();

    public Object remove(Object key);

    public void clear();

}