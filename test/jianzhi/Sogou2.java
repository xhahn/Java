package com.xhahn.test.jianzhi;

import java.util.*;

/**
 * User: xhahn
 * Data: 2016/9/12/0012
 * Time: 15:02
 */
public class Sogou2 {

    public static BitSet getPrimes(int n) {

        BitSet arr = new BitSet(n);
        arr.set(0);
        arr.set(1);

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (arr.get(i) == false) {
                for (int j = i * i; j < n; j += i) {
                    arr.set(j);
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        BitSet primes = getPrimes(arr[n-1]);

        int sum = 0;

        for (int i=0;i<n-1;i++){
            int tmp = 0;
            for (int index = arr[i]+1;index < arr[i+1];index++){
                if (primes.get(index) == false){
                    tmp++;
                }
            }
            if (i == 0 || i == n-2)
                sum += tmp * (n-1);
            else
                sum += tmp * n;
        }
        System.out.print(sum);
    }

}
