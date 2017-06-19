package com.xhahn.test.jianzhi._2;

import java.util.Stack;

/**
 * User: xhahn
 * Data: 2016/6/30/0030
 * Time: 15:21
 */
class ListNode{
    public int value;
    public ListNode next=null;
}

public class LinkedList {
    private static ListNode root;

    static{
        int i = 1;
        root = new ListNode();
        root.value = 0;
        root.next = null;
        ListNode  node = root;
        while(i<5){
            node.next = new ListNode();
            node = node.next;
            node.value = i++;
        }
    }

    void PrintListReveringly_Recursively(ListNode root){
        if (null == root)
            return;
        PrintListReveringly_Recursively(root.next);
        System.out.println(root.value);
    }
    void PrintListReveringly_Iteratively(ListNode root){
        if (null == root)
            return;
        Stack<ListNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().value);
        }
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.PrintListReveringly_Recursively(root);
        linkedList.PrintListReveringly_Iteratively(root);
    }
}
