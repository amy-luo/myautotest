package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//最大花费金额,https://renjie.blog.csdn.net/article/details/128499649
//暴力解法，三层循环
public class ZuiDaHuaFeiJinE {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            Integer[] ar2 = new Integer[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                ar2[i] = dataArray[i];
            }
            int m = Integer.valueOf(in.nextLine());//row
            Arrays.sort(ar2, (o1, o2) -> o2 - o1);
            boolean flag = false;
            int maxSum=Integer.MIN_VALUE;
            for (int i = 0; i <= ar2.length-3; i++) {
                for (int left = i + 1; left <= ar2.length-2;left++ ) {
                    for (int right = left + 1; right <= ar2.length-1;right++ ) {
                        int sum = dataArray[i] + dataArray[left] + dataArray[right];
                        if (sum <=m) {
                            maxSum = Math.max(maxSum, sum);
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) {
                System.out.println(-1);
            }else{System.out.println(maxSum);}

        }
    }
}