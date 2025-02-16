package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//最接最大输出功率的设备 /查找充电设备组合,https://renjie.blog.csdn.net/article/details/128570481
//二维动态规划
public class ChongDianSheBei {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int n = Integer.valueOf(in.nextLine());
            int[] shebei = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int P = Integer.valueOf(in.nextLine());//col
            int[][] dp=new int[P+1][n+1];
            dp[0][0]=0;
            for (int i = 1; i <=P; i++) {
                for (int j = 1; j <=n; j++) {
                    if(shebei[j-1]<=i) {
                        dp[i][j] = Math.max(dp[i - shebei[j-1]][j - 1] + shebei[j-1], dp[i][j - 1]);
                    }
                    if(shebei[j-1]>i) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        System.out.println(dp[P][n]);
        }
    }

}
