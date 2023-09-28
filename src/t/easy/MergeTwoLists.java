package t.easy;

import java.util.Iterator;

public class MergeTwoLists {


    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1,new ListNode(3,new ListNode(9)));
//        ListNode listNode2 = new ListNode(1,new ListNode(6,new ListNode(90)));
        ListNode listNode1 = null;
        ListNode listNode2 = new ListNode(0);

        ListNode listNode = mergeTwoLists(listNode1, listNode2);


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode listNode =new ListNode();
        ListNode c = listNode;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 < val2) {
                c.val = val1;
                list1 = list1.next;
            } else {
                c.val = val2;
                list2 = list2.next;
            }
            c.next = new ListNode();
            if (list1 != null && list2 != null) {
                c = c.next;
            }
        }
        if (list1 != null) {
            c.next = list1;
        }
        if (list2 != null) {
            c.next = list2;
        }
        return listNode;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}





























