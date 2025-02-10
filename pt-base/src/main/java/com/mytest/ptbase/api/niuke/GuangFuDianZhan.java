package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//荒地建设电站 / 区域发电量统计,https://renjie.blog.csdn.net/article/details/128585232
//二维矩阵前缀和
public class GuangFuDianZhan {
    public static int[][] matrix;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = firstHang[0];//row
            int n = firstHang[1];//col
            int bian=firstHang[2];
            int minSum=firstHang[3];
            matrix=new int[m][n];
            int count=0;
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=dataArray[j];
                }
            }
            for (int i =bian-1 ; i < m; i++) {
                for (int j = bian-1; j < n; j++) {
                    int sum = 0;
                    if (bian == 1) {
                        sum = matrix[i][j];
                    }
                    if (bian > 1) {
                        int x1 = i - bian + 1;
                        int y1 = j - bian + 1;
                        int x2 = i;
                        int y2 = j - bian + 1;
                        int x3 = i - bian + 1;
                        int y3 = j;
                        int x4 = i;
                        int y4 = j;
                        sum = matrix[x1][y1] + matrix[x2][y2] + matrix[x3][y3] + matrix[x4][y4];
                    }
                    if (sum >= minSum) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
