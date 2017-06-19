package com.xhahn.test;

import java.util.*;

class T2 {

    static class Consumer{
        int num = 0;
        int money = 0;

        public Consumer(int num, int money){
            this.num = num;
            this.money = money;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int maxValue = 0;
        int[] table = new int[n];
        Consumer[] consumers = new Consumer[m];
        for (int i =0;i<n;i++){
            table[i] = in.nextInt();
        }

        for (int i=0;i<m;i++){
            int num = in.nextInt();
            int money = in.nextInt();
            consumers[i] = new Consumer(num, money);
        }

        Arrays.sort(table);
        Arrays.sort(consumers, new Comparator<Consumer>() {
            @Override
            public int compare(Consumer o1, Consumer o2) {
                return o2.money > o1.money ? 1 : -1;
            }
        });
        for (int i =0;i<n;i++){
            System.out.println(table[i]);
        }
        for (int i =0;i<m;i++){
            System.out.println(consumers[i].money);
        }

        for (Consumer consumer : consumers){
            int index = 0;
            for (;index<n;index++){
//                if (table[index] == -1)
//                    continue;
                if (table[index] < consumer.num)
                    continue;
                else
                    break;
            }

            if (index < n){
                maxValue += consumer.money;
                table[index] = -1;
            }
        }


        System.out.println(maxValue);

    }
}