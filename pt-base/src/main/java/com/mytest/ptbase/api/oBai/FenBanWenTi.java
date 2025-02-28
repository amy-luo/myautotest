package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//分班问题，https://renjie.blog.csdn.net/article/details/130898810
//简单一维动态规划，排序
public class FenBanWenTi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int[] dp = new int[s.length + 1];
            dp[0] = 1;

            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 1; i < s.length; i++) {
                if (s[i].split("/")[1].equals("Y")) {
                    dp[i] = dp[i - 1];

                } else {
                    dp[i] = -dp[i - 1];
                }
                if (dp[i] == 1) {
                    list.add(i + 1);
                } else {
                    list2.add(i + 1);
                }
            }
            Collections.sort(list);
            Collections.sort(list2);
            StringBuilder stb1 = new StringBuilder();
            StringBuilder stb2 = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stb1.append(list.get(i) + " ");
            }
            for (int i = 0; i < list2.size(); i++) {
                stb2.append(list2.get(i) + " ");
            }
            System.out.println(stb1.toString());
            System.out.println(stb2.toString());
        }
    }
}

