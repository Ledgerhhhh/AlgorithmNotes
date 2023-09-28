package main;

import n.DoublyLinkedListSentinel;
import n.DynamicArray;
import n.SinglyLinkedList;
import n.SinglyLinkedListSentinel;

import java.util.Iterator;
import java.util.function.Consumer;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        DoublyLinkedListSentinel integers = new DoublyLinkedListSentinel();

        for (int i = 0; i < 10; i++) {
            integers.addLast(i);
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }

}
