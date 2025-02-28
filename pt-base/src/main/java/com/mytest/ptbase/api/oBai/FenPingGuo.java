package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//分苹果，https://renjie.blog.csdn.net/article/details/128041829
//按A的方式二进制异或计算，如果可以等分，那两边的异或总和肯定为0，所有苹果的异或总和为0。所有苹果从小到大排序，拿出最小重量的苹果数给A。剩下的苹果就是B的。
public class FenPingGuo {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = Integer.valueOf(s);
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(dataArray);
            int sumA = 0;
            int[] sumQianZhui = new int[dataArray.length];
            sumQianZhui[0] = dataArray[0];
            for (int i = 0; i < dataArray.length; i++) {
                sumA ^= dataArray[i];
                if (i > 0) {
                    sumQianZhui[i] = sumQianZhui[i - 1] + dataArray[i];//前缀和
                }
            }
            if(sumA==0){
                System.out.println(sumQianZhui[dataArray.length-1]-sumQianZhui[0]);
            }else{
                System.out.println(-1);
            }
//            double weightA = (double)sumA/ 2;//A想要的等分的苹果重量。
//            int calA = 0;
//            double cha = Integer.MAX_VALUE;
//            int shijiA = Integer.MAX_VALUE;
//            for (int i = 0; i < dataArray.length; ) {//计算从i到j的和，找出满足A的最小苹果重量。
//                for (int j = i; j < dataArray.length; ) {
//                    if (i == 0) {
//                        calA = sumQianZhui[j];
//                    } else {
//                        calA = sumQianZhui[j] - sumQianZhui[i - 1];
//                    }
//                    if (calA >= weightA) {
//                        if (calA - weightA < cha) {
//                            cha = calA - weightA;
//                            shijiA = calA;
//                        }
//                        if (i == j) {
//                            i++;
//                            j++;
//                        } else {
//                            i++;
//                        }
//                    } else {
//                        j++;
//                    }
//                }
//            }
//            System.out.println(shijiA == Integer.MAX_VALUE ? -1 : sumQianZhui[dataArray.length-1] - shijiA);
        }
    }
}
