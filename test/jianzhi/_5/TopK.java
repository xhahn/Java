package com.xhahn.test.jianzhi._5;

/**
 * User: xhahn
 * Data: 2016/7/2/0002
 * Time: 16:19
 */
public class TopK {

    private static final int[] arr = new int[]{1, 5, 2, 26, 4, 34, 542, 225, 78, 46, 95, 42, 89, 62, 3, 14, 52, 6, 32, 12};

    void swap(int[] arr, int from, int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    int partition(int[] arr, int start, int end) {
        if (arr.length == 0 || start < 0 || end > arr.length)
            System.err.println("Invalid Parameters");
        int index = (int) (Math.random() * (end - start + 1) + start);
        swap(arr, index, end);
        int small = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                if (arr[i] != arr[small]) {
                    swap(arr, small, i);
                }
                small++;
            }
        }
        swap(arr, small, end);
        return small;
    }

    int[] getMinTopK(int[] arr, int k) {
        if (arr == null || k < 1)
            return null;
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k) {
            if (index > k) {
                end = index - 1;
                index = partition(arr, start, end);
            }
            if (index < k) {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = arr[i];
        return result;
    }


    private void reheap(int[] heap, int rootIndex) {
        int newNum = heap[rootIndex];
        int curr = rootIndex;
        int leftChild = curr * 2 + 1;
        while (leftChild < heap.length) {
            int position = leftChild;
            if (leftChild + 1 < heap.length && heap[leftChild] < heap[leftChild + 1]) {
                position = leftChild + 1;
            }
            if (newNum < heap[position]) {
                heap[curr] = heap[position];
                curr = position;
                leftChild = curr * 2 + 1;
            } else {
                break;
            }
        }
        heap[curr] = newNum;
    }

    int[] getMinTopKFromBigData(int[] arr, int k) {
        if (arr == null || k < 1)
            return null;
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
        }
        for (int i = k/2-1;i>=0;i--){
            reheap(heap, i);
        }
        for (int i = k; i < arr.length; i++) {
            if (heap[0] > arr[i]) {
                heap[0] = arr[i];
                reheap(heap, 0);
            }
        }

        return heap;
    }

    int num1(int n){
        int num = 0;
        for(int  i=1;i<n;i++)
            num += N(i);
        return num;
    }

    int N(int n){
        int num = 0;
        while(n != 0){
            if (n % 10 ==1)
                num ++;
            n = n / 10;
        }
        return num;
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        for (int i : topK.getMinTopKFromBigData(arr, 7))
            System.out.print(i + " ");
        System.out.println(topK.num1(21345) - topK.num1(1345));
    }
}
