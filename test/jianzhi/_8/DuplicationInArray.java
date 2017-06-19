package com.xhahn.test.jianzhi._8;

/**
 * User: xhahn
 * Data: 2016/7/6/0006
 * Time: 9:47
 */
public class DuplicationInArray {

    int duplicate(int[] arr){
        if (arr == null)
            return -1;

        for (int i = 0;i<arr.length;){
            if (i == arr[i]){
                i++;
                continue;}
            if (arr[i] == arr[arr[i]])
                return arr[i];

            int tmp = arr[i];
            arr[i] = arr[tmp];
            arr[tmp] = tmp;
        }

        return -2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,7,4,5,6,7};
        DuplicationInArray duplicationInArray = new DuplicationInArray();
        System.out.println(duplicationInArray.duplicate(arr));

    }
}
