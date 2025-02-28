package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//矩形相交的面积，https://renjie.blog.csdn.net/article/details/130853048
//找到左x最大值，右x最小值，上y最小值，下y最大值。不相交输出0。
public class JuXingXiangJiaoDeMianJi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            matrix = new int[3][4];
            for (int i = 0; i < 3; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = dataArray[j];
                }
                matrix[i][2] = matrix[i][0] + matrix[i][2];
                matrix[i][3] = matrix[i][1] - matrix[i][3];
            }
            int x1 = Math.max(Math.max(matrix[0][0], matrix[1][0]), matrix[2][0]);
            int x2 = Math.min(Math.min(matrix[0][2], matrix[1][2]), matrix[2][2]);
            int y1 = Math.min(Math.min(matrix[0][1], matrix[1][1]), matrix[2][1]);
            int y2 = Math.max(Math.max(matrix[0][3], matrix[1][3]), matrix[2][3]);
            int S = 0;
            if (x2 > x1 && y1 > y2) {//不相交
                S = (x2 - x1) * (y1 - y2);
            }
            System.out.println(S);
        }
    }
}
