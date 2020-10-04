package com.company;

public class MyArrayList<T> {
    private Object[] array = new Object[10];
    private int lastElementIndex= 0;

    public MyArrayList() {
    }

    public void add(T element){
        if(lastElementIndex < 10){
            array[lastElementIndex] = element;
        }
    else {
            Object[] newArray = new Object[lastElementIndex+1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[lastElementIndex] = element;
            array = newArray;
        }
        lastElementIndex++;
    }
    public T get(int index){
        T element = (T) array[index];
        return element;
    }
    public void delete(int index){
        array[index] = null;
        Object[] newArray = new Object[lastElementIndex-1];
        int k = 0;
        for (Object o : array) {
            if (o != null) {
                newArray[k] = o;
                k++;
            }
        }
        array = newArray;
    }
    public int size(){
        return array.length;
    }
}
