package com.xhahn.test.jianzhi;

/**
 * User: xhahn
 * Data: 2016/9/21/0021
 * Time: 15:28
 */

import java.util.*;

public class Souhu {

    static class Node {
        int left;
        int right;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        while (n!=0){
            if (m == n)
                System.out.println(m+" "+n);
            else if (m<10){
                int sum =0;
                int x = n;
                while (n>0){
                    sum+=n%10;
                    n /=10;
                }
                if (sum > m)
                    System.out.println("error");
                else
                {
                    System.out.print(sum);
                    Stack<Integer> stack = new Stack<>();
                    while(x>0){
                        stack.push(x % 10);
                        x/=10;
                    }
                    while (!stack.empty())
                        System.out.print(" " + stack.pop());
                    System.out.println();
                }
            }
            else
                System.out.println("reject");

            m = in.nextInt();
            n = in.nextInt();
        }

    }


}
