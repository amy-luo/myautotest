package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//光伏场地建设规划，荒地建设电站 / 区域发电量统计,https://renjie.blog.csdn.net/article/details/128585232
//二维矩阵前缀和
public class GuangFuChangDiJianSheGuiHuaDianZhan {
    public static int[][] matrix;
    public static int[][] sum;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = firstHang[0];//row
            int n = firstHang[1];//col
            int bian = firstHang[2];
            int minSum = firstHang[3];
            matrix = new int[m][n];
            sum = new int[m][n];
            int count = 0;
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = dataArray[j];
                }
            }
            //生成前缀和
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0) {
                        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
                    }
                    if (i == 0 && j == 0) {
                        sum[i][j] = matrix[i][j];
                    }
                    if (i == 0 && j != 0) {
                        sum[i][j] = sum[i][j - 1] + matrix[i][j];
                    }
                    if (i != 0 && j == 0) {
                        sum[i][j] = sum[i - 1][j] + matrix[i][j];
                    }
                }
            }
            for (int i = bian - 1; i < m; i++) {
                for (int j = bian - 1; j < n; j++) {
                    int sumTemp = 0;
                    if (bian == 1) {
                        sumTemp = matrix[i][j];
                    }
                    if (bian > 1&&i >= bian && j >= bian) {
                        sumTemp = sum[i][j] - sum[i][j - bian] - sum[i - bian][j] + sum[i - bian][j - bian];
                    }
                    if (i < bian && j < bian) {
                        sumTemp = sum[i][j];
                    }
                    if (i < bian && j >= bian) {
                        sumTemp = sum[i][j] - sum[i][j - bian];
                    }
                    if (i >= bian && j < bian) {
                        sumTemp = sum[i][j] - sum[i - bian][j];
                    }
                    if (sumTemp >= minSum) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
