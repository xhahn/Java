package com.xhahn.test.jianzhi;

import java.util.*;

public class Shunfeng {

    static class Node{
        int num = 0;
        Node[] child = new Node[26];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine().trim());
        for (int i = 1;i<=N;i++){
            String[] line = in.nextLine().trim().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            Node root = new Node();
            for (int a=0;a<n;a++){
                Node node = root;
                char[] tokens = in.nextLine().trim().toCharArray();
                for (char c : tokens){
                    if (node.child[c-'a']==null){
                        node.child[c-'a'] = new Node();
                    }
                    node = node.child[c-'a'];
                    node.num++;
                }
            }

            System.out.println("Case #"+i+":");
            for (int b=0;b<m;b++){
                Node node = root;
                char[] tokens = in.nextLine().trim().toCharArray();
                boolean flag = true;
                for (char c : tokens){
                    if (node.child[c-'a']==null)
                    {
                        flag = false;
                    }
                    else
                        node = node.child[c-'a'];
                }

                if (flag)
                    System.out.println(node.num);
                else
                    System.out.println(0);
            }

        }
    }
}
