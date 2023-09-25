package n;

import java.util.Iterator;

/**
 * 双向链表
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {
    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel() {
        head = new Node(null, 1, null);
        tail = new Node(null, 1, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;
        // 头节点和尾节点不参与便利
        for (Node c = head; c != tail; i++, c = c.next) {
            if (index == i) return c;
        }
        return null;
    }

    public void insert(int index, int value) {
        Node node = findNode(index - 1);
        if (node != null)
            //尾节点的存在不需要配置node.next为空指针
            node.next = node.next.prev = new Node(node, value, node.next);
        else
            throw illegalIndexException(index);
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void addLast(int value) {
        Node prev = tail.prev;
        Node c = new Node(prev, value, tail);
        prev.next = c;
        tail.prev = c;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) throw illegalIndexException(index);
        Node removed = prev.next;
        if (removed == null) throw illegalIndexException(index);
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public void removeFirst() {
        remove(0);
    }


    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) throw illegalIndexException(0);
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    private IllegalArgumentException illegalIndexException(int index) {
        return new IllegalArgumentException(String.format("索引[%d]不合法", index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node c = head.next;

            @Override
            public boolean hasNext() {
                return c != tail;
            }

            @Override
            public Integer next() {
                int value = c.value;
                c = c.next;
                return value;
            }
        };
    }

    static class Node {
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
