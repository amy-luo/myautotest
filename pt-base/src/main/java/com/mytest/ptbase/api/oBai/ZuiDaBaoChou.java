package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//最大报酬, https://renjie.blog.csdn.net/article/details/128331812
//动态规划,在i时间内，是否取j任务，计算此时取得的最大报酬
public class ZuiDaBaoChou {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int T = Integer.valueOf(s[0]);
            int n = Integer.valueOf(s[1]);
            matrix = new int[n][2];
            for (int i = 0; i < n; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                matrix[i] = dataArray;
            }
            int[][] dp = new int[T + 1][n + 1];
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[1][0] = 0;
            for (int i = 1; i <= T; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[j-1][0] <= i) {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - matrix[j - 1][0]][j - 1] + matrix[j - 1][1]);
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            System.out.println(dp[T][n]);
        }
    }

}
