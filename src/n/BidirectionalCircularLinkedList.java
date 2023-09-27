package n;

import java.util.Iterator;
import java.util.Set;

public class BidirectionalCircularLinkedList implements Iterable<Integer> {


    private final Node sentinel = new Node(null, -1, null);

    public BidirectionalCircularLinkedList() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }


    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node n = new Node(a, value, b);
        a.next = n;
        b.prev = n;
    }

    public void addLast(int value) {
        Node a = sentinel;
        Node b = sentinel.prev;
        Node node = new Node(b, value, a);
        a.prev = node;
        b.next = node;
    }

    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) throw IllegalIndexException(0);
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) throw IllegalIndexException(0);
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

        public Boolean removeByValue(int value) {
            Node removed = findNode(value);
            if (removed == null) return false;
            Node a = removed.prev;
            Node b = removed.next;
            a.next = b;
            b.prev = a;
            return true;
        }

    private Node findNode(int value) {
        Node c = sentinel.next;
        while (c.value != value) {
            if (c == sentinel) return null;
            c = c.next;
        }
        return c;
    }


    private IllegalArgumentException IllegalIndexException(int index) {
        return new IllegalArgumentException(String.format("非法的索引:[%d]", index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
