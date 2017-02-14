package ua.itea.ijavaadv.lesson02.dynamicarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DynamicArray<T extends Number & Comparable<T>> {
    protected T [] array;
    protected T element;
    protected List<T> list;

    public DynamicArray() {
    }

    //1.
    public DynamicArray(T[] array, T element){
        this.array = array;
        this.element = element;
    }

    int countLessElement() {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i].compareTo(element) < 0) {
                counter++;
            }
        }
        return counter;
    }

    //2.
    public DynamicArray(List<T> list){
        this.list = list;
    }


    List<Double> substractionSortArray() {
        Double sum = 0.0;
        for (int i = 0; i < list.size() ; i++) {
            sum += (Short)list.get(i).shortValue();
        }
        Double average = sum/list.size();

        List<Double> listOut = new ArrayList<Double>();

        for (int i = 0; i < list.size() ; i++) {
            listOut.add(list.get(i).doubleValue());
        }

        for (int i = 0; i < listOut.size() ; i++) {
            listOut.set(i, listOut.get(i) - average);
        }

        Collections.sort(listOut);
        return listOut;
    }
}
