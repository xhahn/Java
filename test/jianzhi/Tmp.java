package com.xhahn.test.jianzhi;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;
public class Tmp {

    static boolean get = false;

    static void getN(int[]arr, int[] selectedData, int start, int end, int currIndex, int n, BitSet bitSet){



        if (end - start == n-currIndex-1){
            return ;
        }

        if (currIndex == n){
            int sum=0;
            for (int i=0;i<n;i++){
                sum += selectedData[i];
            }
            bitSet.set(sum);
            return;
        }
        selectedData[currIndex] = arr[start];
        getN(arr,selectedData,start+1,end,currIndex+1,n,bitSet);
        getN(arr,selectedData,start+1,end,currIndex,n,bitSet);

        return ;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("%f.2");
        int n = Integer.parseInt(in.nextLine());
        String[] arr_String = in.nextLine().split(" ");
        int [] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(arr_String[i]);
        }

        BitSet max = new BitSet();
        Arrays.sort(arr);

        for(int index : arr){
            max.set(index);
        }

        for(int i =2;i<=n;i++){
            if (get == false)
                getN(arr,new int[i],0,n-1,0,i,max);
            else
                break;
        }

        for (int i=1;i<max.size();i++){
            if (max.get(i) == false) {
                System.out.println(i);
                break;
            }
        }

        }
    }
