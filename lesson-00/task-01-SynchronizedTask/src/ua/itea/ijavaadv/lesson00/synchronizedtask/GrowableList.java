package ua.itea.ijavaadv.lesson00.synchronizedtask;

interface GrowableList {
    //Получить элемент по индексу
    //При пустом элементе возвращает null
    //При несуществующем элементе IndexOutOfBoundsException
    Object get(int index);
    //Установить элемент по индексу
    //При обращении к индексу, большему чем кол-во элементов, массив расширяется
    //При обращении к отрицательному индексу IndexOutOfBoundsException
    void set(int index, Object element);
    //Количество элементов, находящихся в массиве
    int size();

    void add(Object element);
}
