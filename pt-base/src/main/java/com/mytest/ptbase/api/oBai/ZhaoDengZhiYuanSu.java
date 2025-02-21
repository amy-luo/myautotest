package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//自由练习
public class ZhaoDengZhiYuanSu {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            //String s=in.nextLine();
//            int m = Integer.valueOf(s[0]);
//            int n = Integer.valueOf(s[1]);
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = firstHang[0];//row
            int n = firstHang[1];//col
            matrix=new int[m][n];
            isVisited=new boolean[m][n];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=dataArray[j];
                }
            }
        }
    }

}
