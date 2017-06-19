package com.xhahn.test.jianzhi;

import java.util.*;

public class Wangyi3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int item = in.nextInt();
        int user = in.nextInt();

        int[][] record = new int[user][item];
        for (int i=0;i<user;i++)
            for (int j=0;j<item;j++){
                record[i][j] = in.nextInt();
            }

        int[] sum = new int[item];
        for (int i=0;i<user;i++)
            for (int j=0;j<item;j++){
                sum[j] += record[i][j];
            }

        double[][] n_record = new double[item][user];
        for (int i=0;i<user;i++)
            for (int j=0;j<item;j++){
                if (sum[j]!=0)
                    n_record[j][i] = 1.0*record[i][j]/Math.sqrt(sum[j]);
                else
                    n_record[j][i] = 0.0;
            }

        Map<Integer,Integer> similar = new HashMap<>();
        for (int i=0;i<item;i++){
            double max = 0;
            for (int j=0;i<item;i++){
                if (j==i){
                    continue;
                }
                //double c_max = getCOS(n_record[i],n_record[j]);
                //max = max>c_max?max:c_max;
            }
            //similar.put(i,j);
        }

    }
}
