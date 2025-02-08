package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//自由练习
public class FreeTest {
//    public static int[][] matrix;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = firstHang[0];//row
        int n = firstHang[1];//col
        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                }

            }

//        matrix = new int[m][n];
//        System.out.println("");
            ArrayList<Integer> list = new ArrayList<>();

        }
    }

}
