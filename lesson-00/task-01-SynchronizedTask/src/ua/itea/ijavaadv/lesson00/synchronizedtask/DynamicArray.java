package ua.itea.ijavaadv.lesson00.synchronizedtask;
import static java.lang.System.*;
class DynamicArray implements GrowableList{
    private Object[] dynamicArray = new Object[0];

    public synchronized Object get(int index){
        Object element = null;
        synchronized (this) {
            if ((index < dynamicArray.length) && (index >= 0)) {
                element = dynamicArray[index];
            } else {
                //throw new IndexOutOfBoundsException("Элемент с таким индексом не сущестует");
                out.println("Элемент с таким индексом не сущестует");
            }
        }
        return element;
    }

    public synchronized void set(int index, Object element){
        if(index < 0){
            //throw new IndexOutOfBoundsException("Введен отрицательный индекс");
            out.println("Введен отрицательный индекс");
        }
        if (index >= dynamicArray.length){
            Object[] dynamicArrayTemp = new Object[index+1];
            arraycopy(dynamicArray, 0, dynamicArrayTemp, 0, dynamicArray.length);
            dynamicArray = dynamicArrayTemp;
            dynamicArray[index] = element;
        }
        else{
            dynamicArray[index] = element;
        }
    }

    public synchronized int size(){
        return dynamicArray.length;
    }

    @Override
    public synchronized void add(Object element) {
        set(size(), element);
    }
}
