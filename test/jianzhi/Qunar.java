package com.xhahn.test.jianzhi;

import java.util.Scanner;

/**
 * User: xhahn
 * Data: 2016/9/27/0027
 * Time: 10:21
 */
public class Qunar {

    public static int minNight(int[] arr, int total, int night){
        if (total == 0)
            return night;
        if (total < 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (Integer x : arr){
            int curr_min = minNight(arr, total-x, night+1);
            min = min>curr_min?curr_min:min;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().trim().split(" ");

        int[] arr = new int[nums.length-1];
        for (int i=0;i<nums.length-1;i++){
            arr[i] = Integer.parseInt(nums[i]);
        }
        int total = Integer.parseInt(nums[nums.length-1]);

        int min = minNight(arr, total, 0);
        min = min==Integer.MAX_VALUE?-1:min;
        System.out.println(min);
    }
}
