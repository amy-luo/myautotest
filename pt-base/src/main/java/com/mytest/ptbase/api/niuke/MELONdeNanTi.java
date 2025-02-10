package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//MELON的难题，动态规划，https://renjie.blog.csdn.net/article/details/131487950
//MELON有一堆精美的雨花石（数量为n，重量各异），准备送给S和W。MELON希望送给俩人的雨花石重量一致，请你设计一个程序，帮MELON确认是否能将雨花石平均分配。
public class MELONdeNanTi {
    public static int[] dataArray;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(dataArray).sum();
            int res = 0;
            if (sum % 2 == 1) {
                res = -1;
            }
            int[][] dp = new int[sum / 2 + 1][m + 1];
            for(int[] o:dp) {
                Arrays.fill(o, m);
            }
            for (int i = 1; i < sum / 2 + 1; i++) {//i表示重量，j表示是否商品。dp[i][j]表示访问j商品时，重量为i的商品的最小值。如果不存在这样的组合dp[i][j]=0;
                for (int j = 1; j < m + 1; j++) {
                    if (dataArray[j - 1] > i) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (dataArray[j - 1] == i) {
                        dp[i][j] = 1;
                    } else if (dataArray[j - 1] < i) {
//                        System.out.println(dp[i][j - 1]+" "+dp[i - dataArray[j - 1]][j - 1]);
                            dp[i][j] = Math.min(dp[i][j - 1], dp[i - dataArray[j - 1]][j - 1] + 1);//都不存在就都为m
                        }
                    }
                }
            //System.out.println(JSONObject.toJSONString(dp));
//            if(res==-1){System.out.println(-1);}else{
//                System.out.println(dp[sum / 2][m]==m?-1:dp[sum / 2][m]);
//            }
            System.out.println(res == -1 ? res : (dp[sum / 2][m]==m?-1:dp[sum / 2][m]));
            }
        }
    }