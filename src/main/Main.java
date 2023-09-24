package main;

import n.DynamicArray;
import n.SinglyLinkedList;
import n.SinglyLinkedListSentinel;

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


//        SinglyLinkedList integers = new SinglyLinkedList();
//        for (int i = 0; i < 10; i++) {
//            integers.addLast(i);
//        }
////        integers.foreach2(System.out::println);
////        System.out.println(integers.get(1));
////        integers.insert(0,99999);
//        integers.remove(3);
//
//        integers.foreach2(System.out::println);


        SinglyLinkedListSentinel integers = new SinglyLinkedListSentinel();

        for (int i = 0; i < 10; i++) {
            integers.addLast(i);
        }
//        integers.foreach(System.out::println);
        for (Integer i : integers){
            System.out.println(i);
        }
        System.out.println(integers.get(0));

    }

}
