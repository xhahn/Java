package com.xhahn.test.jianzhi._8;

/**
 * User: xhahn
 * Data: 2016/7/6/0006
 * Time: 17:14
 */

class ListNode {
    int value;
    ListNode next = null;

    ListNode(int v) {
        value = v;
    }
}

public class LinkedList {

    void deleteDuplication(ListNode head) {
        if (head == null)
            return;
        ListNode curr = head;
        if (curr.next != null && curr.next.value == curr.value) {
            while (curr.next != null) {
                if (curr.next.value == curr.value)
                    curr = curr.next;
                else if (curr.next.next == null) {
                    head = curr.next;
                    break;
                } else if (curr.next.next.value == curr.next.value)
                    curr = curr.next;
                else {
                    head = curr.next;
                    break;
                }
            }
        }
        curr = head;
        if (curr.next != null) {
            ListNode pre = curr;
            curr = curr.next;

            while (curr != null) {
                if (curr.next != null && curr.value == curr.next.value) {
                    while (curr.next != null && curr.value == curr.next.value) {
                        curr = curr.next;
                    }
                    curr = curr.next;
                } else {
                    pre.next = curr;
                    pre = curr;
                    curr = curr.next;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode curr = head.next;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(4);
        curr = curr.next;
        curr.next = new ListNode(4);
        curr = curr.next;
        curr.next = new ListNode(5);

        l.deleteDuplication(head);
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
        }

    }
}
