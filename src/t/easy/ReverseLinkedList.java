package t.easy;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2));
        ListNode listNode1 = solution.change(listNode);
        System.out.println(listNode1);
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode n1 = null;
            while (head != null) {
                n1 = new ListNode(head.val, n1);
                head = head.next;
            }
            return n1;
        }

        public ListNode reverseList2(ListNode head) {

            List list2 = new List(null);
            while (head != null) {
                ListNode temp = head.next;
                list2.addFirst(head);
                head = temp;
            }
            return list2.head;
        }

        public ListNode reverse(ListNode head, List list) {
            if (head == null) {
                return list.head;
            }
            ListNode temp = head.next;
            list.addFirst(head);
            reverse(temp, list);
            return list.head;
        }

        public ListNode change(ListNode head) {
            List list = new List(head);
            while (true) {
                ListNode temp = head.next;
                list.addFirst(head);
                head.next = temp;
                if (temp.next == null) {
                    list.addFirst(temp);
                    head.next = null;
                    break;
                }
            }
            return list.head;
        }


    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode l = head;
            if (l != null) {
                head = head.next;
            }
            return l;
        }
    }

    static public class ListNode {
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

    static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
