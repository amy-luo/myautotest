package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//跳房子I,https://renjie.blog.csdn.net/article/details/131203588
//循环遍历求和,找到索引和最小的一对
public class TiaoFangZi1 {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());
            String s = in.nextLine();
            int[] array = Arrays.stream(s.substring(1, s.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
            int minSuoyinhe = Integer.MAX_VALUE;
            String res = "";
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] + array[j] == m) {
                        if (minSuoyinhe > i + j) {
                            minSuoyinhe = i + j;
                            res = "[" + array[i] + "," + array[j] + "]";
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }

}
