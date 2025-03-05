package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//事件推送，https://renjie.blog.csdn.net/article/details/127974878
//双指针，i指A数组，j指B数组，判断条件是否相等，判断结果移动指针。右移j，找到满足的j，然后同时i++，j++，
//如果找不到满足的j就i++继续找
public class ShiJianTuiSong {
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
            int R = Integer.valueOf(s[2]);
            int[] dataArrayA = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] dataArrayB = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0, j = 0; i < m && j < n; ) {
                if (dataArrayB[j] >= dataArrayA[i]) {
                    if (dataArrayB[j] - dataArrayA[i] <= R) {
                        System.out.println(dataArrayA[i] + " " + dataArrayB[j]);
                        i++;
                        j++;
                    }else{
                        i++;
                    }
                } else {
                    j++;
                }
            }
        }
    }
}
