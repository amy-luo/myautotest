package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//滑动窗口最大值,滑动窗口，https://renjie.blog.csdn.net/article/details/128138904
public class HuaDongChuangKouZuiDaZhi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int m=Integer.valueOf(in.nextLine());//数组长度
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n=Integer.valueOf(in.nextLine());//窗口大小
            int maxSum = 0;
            for(int i=0;i<n;i++){
                maxSum += dataArray[i];
            }
            for (int i = n; i < m; i++) {
                int sum_new=maxSum+dataArray[i]-dataArray[i-n];
                maxSum=Math.max(maxSum,sum_new);
            }
        System.out.println(maxSum);

        }
    }

}
