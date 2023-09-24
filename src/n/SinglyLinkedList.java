package n;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {
    //单项链表
    private Node head;


    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
            return;
        }
        Node v = new Node(value, null);
        Node c = head;
        while (c.next != null)
            c = c.next;

        c.next=v;
    }

    public void foreach(Consumer<Integer> consumer) {
        Node c = head;
        while (c != null) {
            consumer.accept(c.value);
            c = c.next;
        }
    }

    public void foreach2(Consumer<Integer> consumer) {
        for (Node c = head; c != null; c = c.next) {
            consumer.accept(c.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node c = head;

            @Override
            public boolean hasNext() {
                return c != null;
            }

            @Override
            public Integer next() {
                int v = c.value;
                c = c.next;
                return v;
            }
        };
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
