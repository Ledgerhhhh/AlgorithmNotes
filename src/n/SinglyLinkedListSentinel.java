package n;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 带哨兵的单项链表
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    //单项链表
    private final Node head = new Node(999, null);

    public void addFirst(int value) {
        head.next = new Node(value, head.next);
    }

    public void addLast(int value) {
        //找到尾节点,在后面增加元素
        findLast().next = new Node(value, null);
    }

    private Node findLast() {
        //头结点不为null
        Node c = head;
        //获取一个尾节点为null但是本身不为null的
        while (c.next != null)
            c = c.next;
        return c;
    }

    public int get(int index) {
        Node n = findNode(index);
        if (n == null) throw new IllegalArgumentException();
        return n.value;
    }

    public void insert(int index, int value) {
        Node p = findNode(index - 1);
        if (p != null)
            p.next = new Node(value, p.next);
        else throw illegalIndex(index);
    }

    public void removeFirst() {
        if(head.next!=null)
            head.next = head.next.next;
        else
            throw illegalIndex(0);
    }

    public void remove(int index) {
        Node c = findNode(index-1);
        if (c == null) throw illegalIndex(index);
        if (c.next == null) throw illegalIndex(index);
        c.next = c.next.next;
    }


    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index[%d] 不合法", index));
    }


    private Node findNode(int index) {
        int i = -1;
        for (Node c = head; c != null; i++, c = c.next)
            if (index == i) return c;
        return null;
    }


    public void foreach(Consumer<Integer> consumer) {
        // 避免遍历哨兵节点
        Node c = head.next;
        while (c != null) {
            consumer.accept(c.value);
            c = c.next;
        }
    }

    public void foreach2(Consumer<Integer> consumer) {
        for (Node c = head.next  /*避免遍历哨兵节点*/; c != null; c = c.next) {
            consumer.accept(c.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            /*避免遍历哨兵节点*/
            Node c = head.next;

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
