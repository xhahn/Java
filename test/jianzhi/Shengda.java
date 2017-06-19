package com.xhahn.test.jianzhi;

/**
 * User: xhahn
 * Data: 2016/9/28/0028
 * Time: 20:22
 */
public class Shengda {
    public static void main(String[] args) {
        String s = "/coremail/xphone/index.jsp";

        char[] ss =s.toCharArray();
        int x = ss.length;
        int i =0;
        int seed = 131;
        int hash = 0;
        while(i<x){
            hash = hash * seed + ss[i];
            i++;
        }

        System.out.println(hash & 0x7FFFFFFF);
    }
}
