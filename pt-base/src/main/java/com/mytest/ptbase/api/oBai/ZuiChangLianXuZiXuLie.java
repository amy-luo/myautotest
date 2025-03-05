package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//最长连续子序列,https://renjie.blog.csdn.net/article/details/131775315
//前缀和，双指针并排，伸缩
public class ZuiChangLianXuZiXuLie {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            Integer K = Integer.valueOf(in.nextLine());
            //前缀和
            int[] sum = new int[dataArray.length];
            sum[0] = dataArray[0];
            for (int i = 1; i < dataArray.length; i++) {
                sum[i] = sum[i - 1] + dataArray[i];
            }
            int length = -1;
            for (int i = 0, j = 0; i<=j&&j < dataArray.length; ) {
                int tmp = i == 0 ? sum[j] : sum[j] - sum[i - 1];
                if (tmp == K) {
                    int chang = j - i + 1;
                    length = Math.max(chang, length);
                    i++;
                    j++;
                } else if (tmp < K) {
                    j++;
                } else if (tmp > K) {
                    if (i == j) {
                        i = j++;
                    } else {
                        i++;
                    }
                }
            }
            System.out.println(length);
        }
    }
}

