package com.xhahn.test.jianzhi._3;
/**
 * User: xhahn
 * Data: 2016/7/1/0001
 * Time: 14:42
 */

class ListNode{
    public int value;
    public ListNode next=null;
}

public class Merger {
    private static ListNode list1;
    private static ListNode list2;

    static{
        int i = 3;
        list1 = new ListNode();
        list1.value = 1;
        list1.next = null;
        ListNode node = list1;
        while(i<=7){
            node.next = new ListNode();
            node = node.next;
            node.value = i;
            i += 2;
        }
        i = 4;
        list2 = new ListNode();
        list2.value = 2;
        list2.next = null;
        ListNode node2 = list2;
        while(i<=8){
            node2.next = new ListNode();
            node2 = node2.next;
            node2.value = i;
            i += 2;
        }
    }

    ListNode merger(ListNode list1, ListNode list2){
        if (list1 == null && list2 == null)
            return null;
        else if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode head = null;
        if (list1.value < list2.value){
            head = list1;
            list1 = list1.next;
        }
        else {
            head = list2;
            list2 = list2.next;
        }
        head.next = merger(list1, list2);
        return head;
    }
    public static void main(String[] args) {
        Merger merger = new Merger();
        ListNode list = merger.merger(list1, list2);
        while(list != null){
            System.out.println(list.value);
            list = list.next;
        }
    }
}
