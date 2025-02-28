package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//日志首次上报最多积分，https://renjie.blog.csdn.net/article/details/128199329
//一维动态规划，注意日志累计达100条，必须上报
public class RiZhiShouCiShangBaoZuiDuoJiFen {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] dp = new int[dataArray.length+1];
            dp[0]=0;
            int sum=0;
            for (int i = 1; i < dataArray.length+1; i++) {//第i条日志
                sum += dataArray[i - 1];
                int present=0;
                if(sum>=100){//日志累计达100条，必须上报
                    for (int j = 0; j <= i-2; j++) {
                        present+=dataArray[j]-dataArray[j]*(i-1-j);
                    }
                    present+=100-(sum-dataArray[i-1]);
                    dp[dataArray.length]=Math.max(dp[i - 1], present);
                    break;
                }else {//累计未达100条
                    for (int j = 0; j <= i - 1; j++) {
                        present += dataArray[j] - dataArray[j] * (i - 1 - j);
                    }
                }
                    dp[i] = Math.max(dp[i - 1], present);
            }
            System.out.println(dp[dataArray.length]);
        }
    }
}

