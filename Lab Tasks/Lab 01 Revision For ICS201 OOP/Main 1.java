package com.company;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for(int i = 0; i < 20; i++){
            list.add(new Integer(i));
        }
        System.out.println(list.size());
        System.out.println(list.get(10));
        list.delete(10);
        System.out.println(list.size());
        System.out.println(list.get(10));

    }
}
