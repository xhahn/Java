package com.xhahn.test.jianzhi._8;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xhahn
 * Data: 2016/7/7/0007
 * Time: 15:39
 */
public class StackAndList {

    List<Integer> maxInWindows(int[] arr, int windows){
        if (arr == null || windows < 1 || arr.length < windows)
            return null;

        List<Integer> result = new ArrayList<>();
        List<Integer> max = new ArrayList<>();

        max.add(0);
        for (int i=1;i<arr.length;i++){
            while (max.size()>0 && arr[max.get(max.size()-1)] < arr[i]){
                max.remove(max.size()-1);
            }
            if (max.size()>0 && i - max.get(0) >= windows)
                max.remove(0);
            max.add(i);
            if (i>=windows-1)
                result.add(arr[max.get(0)]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,2,6,2,5,1};
        for (int i : new StackAndList().maxInWindows(arr, 3)){
            System.out.print(i+" ");
        }
    }
}
