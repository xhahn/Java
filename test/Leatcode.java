package com.xhahn.test;

import java.util.*;

/**
 * User: xhahn
 * Data: 2016/6/15/0015
 * Time: 15:06
 */
public class Leatcode {

    public int jump(int[] nums) {
        if(nums.length<2)
            return 0;
        int end = nums.length-1;
        int index = end;
        int max = 0;
        int count = 0;
        int maxindex = -1;
        while(true){
            index--;
            while(index>=0){
                if(nums[index]>=(end-index)){
                    if((end-index) > max){
                        maxindex = index;
                        max = (end-index);
                    }
                }
                index--;
            }

            index = maxindex;
            max = 0;
            end = index;
            count++;
            if(index == 0){
                break;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        Leatcode leatcode = new Leatcode();
        Stack<Integer>[] s = new Stack[2];
        s[0] = new Stack<>();
        System.out.println(s[0]==null);
        int[][] a = {{1,2},{2,3},{3,4}};
        int[] b = new int[3];
        System.out.println(b[2]);
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> requisites = new HashMap<>();
        requisites.put(1, new ArrayList<Integer>());
        requisites.get(1).add(1234);
        System.out.println(requisites.get(1).get(0));
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println("12345".substring(0, 2));
        requisites.keySet().size();
        Stack<Integer>stack = new Stack<>();
        char[] ss = new char[3];
        System.out.println(leatcode.jump(new int[]{2, 3, 1}));

    }
}
