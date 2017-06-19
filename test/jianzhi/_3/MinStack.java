package com.xhahn.test.jianzhi._3;

import java.util.Stack;

/**
 * User: xhahn
 * Data: 2016/7/1/0001
 * Time: 15:57
 */

class Min<T extends Comparable>{
    private Stack<T> stack = new Stack<>();

    public void push(T value){
        if (stack.empty() || value.compareTo(stack.peek()) < 0) {
            stack.push(value);
        }
        else
            stack.push(stack.peek());
    }
    public T pop(){
        return stack.pop();
    }
}

public class MinStack {
    public static void main(String[] args) {
        Min<Integer> m = new Min<>();
        m.push(6);
        m.push(12);
        m.push(5);
        m.push(3);
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());

    }
}
