package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Scanner;

//动态规划，获取最大短信条数，完全背包问题；https://renjie.blog.csdn.net/article/details/128259675
public class DongTaiZuiDaDuanXinTiaoShu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M=Integer.valueOf(in.nextLine());
        String[] a = in.nextLine().split(" ");
        int[][] dp=new int[M+1][a.length+1];//表示金额为i时，覆盖当前商品j时的，此时的最大短信条数。
        int[] data=new int[a.length];
        for(int i=0;i<a.length;i++){
            data[i]=Integer.valueOf(a[i]);
        }
        dp[0][0]=0;

        for(int i=1;i<=M;i++) {
            for (int j = 1; j <=a.length; j++) {
                dp[i][0]=0;
                dp[0][j]=0;
                if(i>=j) {
                    dp[i][j] = Math.max(dp[i - 1][j] + data[0], Math.max(dp[i - j][j - 1] + data[j - 1], dp[i - 1][j - 1] + data[0]));
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j] + data[0], dp[i - 1][j - 1] + data[0]);
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[M][a.length]);
    }
}
