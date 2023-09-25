package n;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 普通的单链表
 */
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
        c.next = v;
    }

    public int get(int index) {
        Node n = findNode(index);
        if (n == null) throw new IllegalArgumentException();
        return n.value;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node p = findNode(index - 1);
        if (p != null)
            p.next = new Node(value, p.next);
        else throw illegalIndex(index);
    }

    public void removeFirst() {
        if (head == null) throw illegalIndex(0);
        head = head.next;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node c = findNode(index - 1);
        if (c == null) throw illegalIndex(index);
        if (c.next == null) throw illegalIndex(index);
        c.next = c.next.next;

    }


    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index[%d] 不合法", index));
    }


    private Node findNode(int index) {
        int i = 0;
        for (Node c = head; c != null; i++, c = c.next)
            if (index == i) return c;
        return null;
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
