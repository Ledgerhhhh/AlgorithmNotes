package main.note;

import java.util.Arrays;
import java.util.LinkedList;

public class Hanoi {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();


    static void init(int n) {
        for (int i = n; i > 0; i--) {
            a.addLast(i);
        }
    }

    /**
     * 移动圆盘
     *
     * @param n 圆盘个数
     * @param a 源
     * @param b 借
     * @param c 目
     */
    public static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0) return;
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print();
        move(n - 1, b, a, c);
    }


    public static void main(String[] args) {
        init(64);
        print();
        move(64, a, b, c);
    }

    public static void print(){
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));
        System.out.println(Arrays.toString(c.toArray()));
        System.out.println("----------------------------");

    }


}
