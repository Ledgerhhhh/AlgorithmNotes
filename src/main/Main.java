package main;

import n.DynamicArray;
import n.SinglyLinkedList;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

//        DynamicArray dynamicArray = new DynamicArray();
//
////        dynamicArray.add(1);
////        dynamicArray.insert(0, 999);
////        dynamicArray.foreach(System.out::println);
////        System.out.println("=====================");
////        int remove = dynamicArray.remove(1);
////
////        dynamicArray.stream().forEach(System.out::println);
//
//
//        for (int i = 0; i < 90; i++) {
//            dynamicArray.add(i);
//        }
//
//
//
//        System.out.println(dynamicArray);


        SinglyLinkedList integers = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            integers.addFirst(i);
        }
        integers.foreach2(System.out::println);


    }


}
