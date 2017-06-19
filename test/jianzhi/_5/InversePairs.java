package com.xhahn.test.jianzhi._5;

/**
 * User: xhahn
 * Data: 2016/7/4/0004
 * Time: 17:49
 */
public class InversePairs {
    private static final int[] arr = new int[]{1, 5, 2, 26, 4, 34, 542, 225, 78, 46, 95, 42, 89, 62, 3, 14, 52, 6, 32, 12};

    int inversePairs(int[] arr, int[] copy, int start, int end){
        if (arr == null)
            return 0;
        if (start == end){
            copy[start] = arr[start];
            return 0;}
        int length = (end-start) / 2;
        int left = inversePairs(copy, arr, start, start + length);
        int right = inversePairs(copy, arr, start + length + 1, end);

        int i = start + length;
        int j = end;
        int count = 0;
        int copyIndex = end;
        while (i>=start && j!=start+length){
            if (arr[i] > arr[j]){
                count += j-start-length;
                copy[copyIndex--] = arr[i];
                i--;
            }
            else{
                copy[copyIndex--] = arr[j--];
            }
        }

        for(;j>= start+length+1;j--)
            copy[copyIndex--] = arr[j];
        for (;i>=start;i--)
            copy[copyIndex--] = arr[i];

        return left+right+count;
    }

    void change(Integer i){
        i++;
    }
    public static void main(String[] args) {
        int[] copy = arr.clone();
        System.out.println(new InversePairs().inversePairs(arr, copy, 0, arr.length - 1));

        Integer i = 0;
        new InversePairs().change(i);
        System.out.println(1 ^ 2 ^ 3 ^ 2 ^ 1 ^ 3 ^ 3);

        Integer num1 = 10;
        String num2 = Integer.toBinaryString(num1);

        int[] t = new int[]{1,2,3,4,3};
        int sum = 1;
        for (int j=1;j<5;j++)
            sum = sum ^ t[j];


    }
}
