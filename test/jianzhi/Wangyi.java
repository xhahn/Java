package com.xhahn.test.jianzhi;

import java.util.*;

public class Wangyi {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] dist = new int[n][n];
        for (int i =0;i<n;i++)
            for (int j=0;j<n;j++){
                dist[i][j] = in.nextInt();
            }

        boolean[][] visited = new boolean[n][n];
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<n;i++)
        {
            int mindist = minDist(dist, visited, i, 0, n);
            if (mindist < min)
                min = mindist;
        }
        System.out.println(min);
    }

    private static int minDist(int[][] dist, boolean[][] visited,int start , int num, int n) {
        if (num == n*n)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if (dist[start][i] == 0 || visited[start][i] == true)
                continue;
            visited[start][i] = true;

            int mindist = minDist(dist, visited, i, num+1, n)+dist[start][i];
            if (mindist < min)
                min = mindist;
            visited[start][i] = false;
        }

        return min;
    }

}
