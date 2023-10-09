package main;

import n.*;

import java.util.Iterator;
import java.util.function.Consumer;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

//        DoublyLinkedListSentinel integers = new DoublyLinkedListSentinel();
//
//        for (int i = 0; i < 10; i++) {
//            integers.addLast(i);
//        }
//
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }

//        BidirectionalCircularLinkedList integers = new BidirectionalCircularLinkedList();
//
//        for (int i = 0; i < 10; i++) {
//            integers.addLast(i);
//        }
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }

        SinglyLinkedList integers = new SinglyLinkedList();

        for (int i = 0; i < 10; i++) {
            integers.addLast(i);
        }

        integers.loop(System.out::println,System.out::println);




    }

}
