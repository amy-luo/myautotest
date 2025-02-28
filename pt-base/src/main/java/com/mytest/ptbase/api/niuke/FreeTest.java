package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//自由练习
public class FreeTest {
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
//            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            int m = dataArray[0];//row
//            int n = dataArray[1];//col
            matrix = new int[m][n];
            isVisited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = dataArray[j];
                }
            }
            StringBuilder stb = new StringBuilder();
            System.out.println(stb.toString());
        }
    }

}
