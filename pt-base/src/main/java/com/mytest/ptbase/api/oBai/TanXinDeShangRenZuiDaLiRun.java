package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//贪心的商人，最大利润,https://renjie.blog.csdn.net/article/details/128244039
//贪心，有利润时全买全卖
public class TanXinDeShangRenZuiDaLiRun {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());
            int n = Integer.valueOf(in.nextLine());
            int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            matrix=new int[m][n];

            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=dataArray[j];
                }
            }
            int count=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n-1; j++) {
                   if(matrix[i][j]<matrix[i][j+1]){
                       count+=(matrix[i][j+1]-matrix[i][j])*nums[i];
                   }
                }
            }
            System.out.println(count);
        }
    }

}
