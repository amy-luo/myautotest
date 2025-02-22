package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//查找接口成功率最优时间段,https://renjie.blog.csdn.net/article/details/130849485
//前缀和，循环遍历，j>=i,满足平均值最小的前提下，找出最大i,j的差值
public class ChaZhaoJieKouChengGongLvZuiYouShiJianDuan {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = Integer.valueOf(s);
            int[] data = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //前缀和
            int[] sumAr = new int[data.length];
            sumAr[0] = data[0];
            for (int i = 1; i < data.length; i++) {
                sumAr[i] = sumAr[i - 1] + data[i];
            }

            double maxCount = Integer.MIN_VALUE;
            ArrayList<int[]> index = new ArrayList<>();
            double sum = 0;
            for (int i = 0; i < data.length; i++) {
                for (int j = i; j < data.length; j++) {
                    if (i == 0) {
                        sum = sumAr[j];
                    } else {
                        sum = sumAr[j] - sumAr[i - 1];
                    }
                    double jun = sum / (j - i + 1);
                    if (jun <= m) {
                        if (j - i > maxCount) {
                            maxCount = j - i;
                            index.removeAll(index);
                            index.add(new int[]{i, j});
                        } else if (j - i == maxCount) {
                            index.add(new int[]{i, j});
                        }
                    }
                }
            }
            StringBuilder stb = new StringBuilder();
            for (int[] o : index) {
                stb.append(o[0] + "-" + o[1] + " ");
            }
            System.out.println(stb.toString());
        }
    }
}
