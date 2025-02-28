package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//找终点，https://renjie.blog.csdn.net/article/details/130852277
//先确定起始位置，在1到len/2之间，再根据每一个起始位置，遍历后面的，看是否能走到终点，如果可以，比较找到最小步数
public class ZhaoZhongDian {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int mixCount = Integer.MAX_VALUE;
            boolean flag = false;
            for (int j = 1; j < dataArray.length / 2; j++) {//确定起始步
                int count = 1;
                for (int i = j; i < dataArray.length; i++) {
                    i += dataArray[i];
                    count++;
                    if (i == dataArray.length - 1) {
                        flag = true;
                        mixCount = Math.min(mixCount, count);
                    }
                }
            }
            if (!flag) {
                System.out.println(-1);
            } else {
                System.out.println(mixCount);
            }
        }
    }

}
