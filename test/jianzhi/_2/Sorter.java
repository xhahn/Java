package com.xhahn.test.jianzhi._2;

/**
 * User: xhahn
 * Data: 2016/6/30/0030
 * Time: 18:40
 */

interface myOrder{
        boolean isToSwap(int pram);
        }

class EvenOrder implements myOrder{

    @Override
    public boolean isToSwap(int n) {
        return (n & 0x1) == 1;
    }
}

public class Sorter {

    private static final int[] arr = new int[]{1,5,2,26,33,4,3,14,52,6,32,12};

    void swap(int[] arr, int from, int to){
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
    int partition(int[] arr, int start, int end) throws Exception {
        if (arr.length == 0 || start <0 || end > arr.length)
            //System.err.println("Invalid Parameters");
            throw new Exception(" ");
        int index = (int)(Math.random() * (end-start+1) + start);
        swap(arr, index, end);
        int small = start;
        for (int i = start;i<=end;i++){
            if (arr[i] <= arr[end]){
                if (i != small){
                    swap(arr, small, i);
                }
                small++;
            }
        }
        //swap(arr, small, end);
        return --small;
    }
    /*
    * int partition(int[] arr, int start, int end){
        if (arr.length == 0 || start <0 || end > arr.length)
            System.err.println("Invalid Parameters");
        int index = (int)(Math.random() * (end-start+1) + start);
        swap(arr, index, end);
        int small = start;
        for (int i = start;i<end;i++){
            if (arr[i] < arr[end]){
                if (arr[i] != arr[small]){
                    swap(arr, small, i);
                }
                small++;
            }
        }
        swap(arr, small, end);
        return small;
    }*/
    void quickSort(int[] arr,int start, int end) throws Exception {
        int index = partition(arr, start, end);
        if (index > start)
            quickSort(arr, start, index-1);
        if (index < end)
            quickSort(arr, index+1, end);
    }

    int fibonacci(int n){
        if (n <= 0)
            return 0;
        if (n == 1){
            return 1;
        }
        int first = 0;
        int second = 1;
        int result=0;
        for (int i=2;i<=n;i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    int countOne(int n){
        int result = 0;
        while(n != 0){
            n &= (n-1);
            result++;
        }
        return result;
    }

    void reorder(int[] arr, myOrder orderFunc){
        if (arr.length == 0)
            return;
        int first = 0, second = 0;
        while(second < arr.length){
            if (orderFunc.isToSwap(arr[second])){
                if (arr[second] != arr[first]){
                    int tmp = arr[first];
                    arr[first] = arr[second];
                    arr[second] = tmp;
                }
                first ++;
            }
            second ++;
        }
    }
    public static void main(String[] args) throws Exception {
        Sorter sorter = new Sorter();
        //sorter.reorder(arr, new EvenOrder());
        sorter.quickSort(arr, 0 , arr.length-1);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        System.out.println(sorter.countOne(0xFFFFF));

    }
}
