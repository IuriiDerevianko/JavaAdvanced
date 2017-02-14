package ua.itea.ijavaadv.lesson04.mytreedsimpementations;
import com.google.common.collect.*;
import java.util.*;

/**
 *
 * Created
 * at 16:05
 * on 09.02.17
 * by Iurii Derevianko;
 *
 */
public class MyNavigableMultiMap<K, V> implements NavigableMultiMap {
    private  int size = 0;
    private Object[][] main = new Object[16][16];
    private int keyIndex = 0;
    private int valueIndex = 0;


    @Override
    public boolean put(Object o1, Object[] o2) {
        for(int i = 0; i < main.length; i++){
            if(main[i][0].equals(o1)) {
                return false;
            }
        }
        main[keyIndex][valueIndex++] = o1;
        main[keyIndex++][valueIndex--] = o2;
        size++;
        return true;
    }


    @Override
    public int get(Object o) {
        return 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }
}

