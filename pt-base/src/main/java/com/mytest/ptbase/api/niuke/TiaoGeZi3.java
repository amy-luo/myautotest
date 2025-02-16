package com.mytest.ptbase.api.niuke;

import java.util.Arrays;
import java.util.Scanner;

//跳格子3,https://renjie.blog.csdn.net/article/details/135275812
//动态规划，一唯
public class TiaoGeZi3 {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());//row
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.valueOf(in.nextLine());//col
            int[] dp = new int[m + 1];
            dp[0] = 0;
            dp[1] = firstHang[0];
            for (int i = 2; i < m+1; i++) {
                int maxCount=Integer.MIN_VALUE;
                for(int j=1;j<=k;j++) {//统计前面不同位置跳到i元素的最大值。
                    if(i>j) {
                        dp[i] = dp[i - j] + firstHang[i - 1];
                        maxCount=Math.max(maxCount,dp[i]);
                    }
                }
                dp[i]=maxCount;
            }
            System.out.println(dp[m]);
        }

    }

}
