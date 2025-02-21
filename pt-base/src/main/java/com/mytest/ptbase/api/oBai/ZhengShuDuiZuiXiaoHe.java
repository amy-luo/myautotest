package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//整数对最小和,https://renjie.blog.csdn.net/article/details/128499698
//从两个数组中各取一个数字，进行求和，求和和按从小到大排序，输出前k个和。
public class ZhengShuDuiZuiXiaoHe {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {

            int m = in.nextInt();//row
            int[] ar1 = new int[m];
            for (int i = 0; i < m; i++) {
                ar1[i] = in.nextInt();
            }
            int n = in.nextInt();//col
            int[] ar2 = new int[n];
            for (int i = 0; i < n; i++) {
                ar2[i] = in.nextInt();
            }
            int k = in.nextInt();//col
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    list.add(ar1[i] + ar2[j]);
                }
            }
            Collections.sort(list);
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += list.get(i);
            }
            System.out.println(sum);
        }
    }

}
