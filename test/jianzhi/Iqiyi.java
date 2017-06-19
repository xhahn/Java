package com.xhahn.test.jianzhi;

import java.util.Scanner;

/**
 * User: xhahn
 * Data: 2016/9/27/0027
 * Time: 19:47
 */
public class Iqiyi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] item = new int[M];
        int[] value = new int[M];

        for (int i=0;i<M;i++){
            item[i] = in.nextInt();
            value[i] = in.nextInt();
        }

        int result = solution(item, value, M, N);
        System.out.println(result);


    }

    private static int solution(int[] item, int[] value, int M, int N) {

        int[][] damage = new int[M+1][N+1];

        for(int i=1;i<=M;i++){
            for (int j=1;j<=N;j++){
                if (item[i-1]<=j){
                    if (damage[i-1][j] < (damage[i-1][j-item[i-1]]+value[i-1]))
                        damage[i][j] = damage[i-1][j-item[i-1]]+value[i-1];
                    else
                        damage[i][j] = damage[i-1][j];
                }
                else
                    damage[i][j] = damage[i-1][j];
            }
        }

        return damage[M][N];

    }
}
