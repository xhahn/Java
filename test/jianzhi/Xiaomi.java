package com.xhahn.test.jianzhi;

import java.util.*;

/**
 * User: xhahn
 * Data: 2016/9/23/0023
 * Time: 20:14
 */
public class Xiaomi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        while(n>0){
            char[] number = in.nextLine().toCharArray();
            int length = number.length;

            List<Integer> result = new ArrayList<>();

            for (int i=0;i<number.length&&length>0;i++){
                switch (number[i]){
                    case 'G':{
                        result.add(0);
                        length -= 5;
                        break;
                    }
                    case 'X':{
                        result.add(8);
                        length -= 3;
                        break;
                    }
                    case 'W':{
                        result.add(4);
                        length -= 4;
                        break;
                    }
                    case 'U':{
                        result.add(6);
                        length -= 4;
                        break;
                    }
                    case 'Z':{
                        result.add(2);
                        length -= 4;
                        break;
                    }
                    default:
                        break;
                }
            }

            for (int i =0;i<number.length&&length>0;i++){
                switch(number[i]){
                    case 'H':{
                        result.add(5);
                        length -= 5;
                        break;
                    }
                    case 'V':{
                        result.add(7);
                        length -= 4;
                        break;
                    }
                    case 'O':{
                        result.add(3);
                        length -= 3;
                        break;
                    }
                    default:
                        break;
                }
            }

            if (length>0){
                int k = length/4;
                while (k>0)
                    result.add(1);
            }

            Collections.sort(result);
            for (int x : result)
                System.out.print(x);
            System.out.println();
        }
    }
}
