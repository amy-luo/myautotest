package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//最大矩阵和,https://renjie.blog.csdn.net/article/details/127974083
//暴力解法，遍历矩阵每个元素，将从0,0到该元素的矩阵和求出来；再固定上下行和左右列，求其框住的矩阵和；
//注意场景分析，i,j等于0的情况分析。
public class ZuiDaJuZhenHe {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int m = Integer.valueOf(s[0]);
            int n = Integer.valueOf(s[1]);
            matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = dataArray[j];
                }
            }
            int[][] sum = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i][j] = matrix[i][j];
                    if (i > 0 && j > 0) {
                        sum[i][j] += +sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                    } else if (i == 0 && j > 0) {
                        sum[i][j] += sum[i][j - 1];
                    } else if (i > 0 && j == 0) {
                        sum[i][j] += sum[i - 1][j];
                    }
                }
            }
            int maxSum = Integer.MIN_VALUE;
            for (int row1 = 0; row1 < m; row1++) {//固定上行
                for (int row2 = row1; row2 < m; row2++) {//固定下行
                    for (int col1 = 0; col1 < n; col1++) {//固定左列
                        for (int col2 = col1; col2 < n; col2++) {//规定右列
                            int he = sum[row2][col2];
                            if (col1 == 0 && row1 > 0) {
                                he += -sum[row1 - 1][col2];
                            } else if (col1 > 0 && row1 == 0) {
                                he += -sum[row2][col1 - 1];
                            } else if (col1 > 0 && row1 > 0) {
                                he += -sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
                            }
                            maxSum = Math.max(maxSum, he);
                        }
                    }
                }
            }
            System.out.println(maxSum);
        }
    }

}
