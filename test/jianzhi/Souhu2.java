package com.xhahn.test.jianzhi;

/**
 * User: xhahn
 * Data: 2016/9/21/0021
 * Time: 15:28
 */

import java.util.*;

public class Souhu2 {

    static int result = 0;

    public static void solve(int[] arr, int start,int len, ArrayList<Integer> selected, int t){

        if (len == 0) {
            int sum = 0;
            for (int i : selected)
                sum+=i;
            if (sum==t)
                result++;
            return;
        }
        if (start >= arr.length)
            return ;

        selected.add(arr[start]);
        solve(arr,start+1,len-1,selected,t);
        selected.remove(selected.size()-1);
        solve(arr, start+1,len,selected,t);

        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();

        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);


        for (int i =1;i<=arr.length;i++) {
            solve(arr, 0,i, new ArrayList<Integer>(), sum);
        }
        System.out.println(result);

    }
}
