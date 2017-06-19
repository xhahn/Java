package com.xhahn.test.jianzhi;

import java.util.*;

/**
 * User: xhahn
 * Data: 2016/9/12/0012
 * Time: 15:02
 */
public class Sogou {

    public static int[] getArrayIndex(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = next[pos-1];

        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                pos++;
            }
        }
        return next;
    }

    public static int KMP_Index(char[] s, char[] t) {
        int[] next = getArrayIndex(s);
        int i = 0;
        int j = 0;
        while (i <= s.length - 1 && j <= t.length - 1) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String ts1 = sc.nextLine();
        String ts2 = new StringBuilder(ts1).reverse().toString();

        char[] s1 = ts1.toCharArray();
        char[] s2 = ts2.toCharArray();

        System.out.print(KMP_Index(s2, s1));

        }

}
