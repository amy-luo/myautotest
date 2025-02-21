package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//分割数组的最大差值,https://renjie.blog.csdn.net/article/details/131203249
//先求出总会，指针右移，总和减去左移的部分为右数组和，左移部分加起来是左数组之和。两者差取绝对值，求最大。
public class FenGeShuZuZuiDaChaZhi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            int m = Integer.valueOf(s);
            String[] ar = in.nextLine().split(" ");
            Integer[] array = new Integer[m];
            int preSum=0;
            int afterSum=0;
            for (int i = 0; i < m; i++) {
                array[i]=Integer.valueOf(ar[i]);
                afterSum += array[i];
            }
            int maxCount = Integer.MIN_VALUE;
            for (int i = 0; i < m-1; i++) {
                preSum += array[i];
                afterSum -= array[i];
                maxCount=Math.max(maxCount,Math.abs(preSum-afterSum));
            }
            System.out.println(maxCount);
        }
    }

}
