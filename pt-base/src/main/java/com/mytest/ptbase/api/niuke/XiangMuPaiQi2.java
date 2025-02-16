package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//项目排期/最少交付时间，https://renjie.blog.csdn.net/article/details/135195692
//暴力递归回溯，让需求去找人，一个需求只能选择一个人来完成。
//改成了二分递归回溯
public class XiangMuPaiQi2 {
    public static int[] xuqiu;
    public static int m;
    public static int timeMin;
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            xuqiu = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = xuqiu.length;
            n = Integer.valueOf(in.nextLine());//人
            int[] renwuhe = new int[n];//每人手里的任务和分别存储在在合理
            timeMin = Integer.MAX_VALUE;//记得初始化，添加每种情况的完成天数，以方便找到最小值
            backTrace(0, renwuhe);
            System.out.println(timeMin);
        }
    }

    private static void backTrace(int xuqiuIndex, int[] renwuhe) {
        if (xuqiuIndex == m) {//需求个数达到m时
            int maxSum = Arrays.stream(renwuhe).max().getAsInt();
            timeMin = Math.min(timeMin, maxSum);
        } else {
            for (int i = 0; i < n; i++) {//每个需求任务可以选择一个人来完成。一个需求只能选择一个人。
                renwuhe[i] = renwuhe[i] + xuqiu[xuqiuIndex];//每人手里的需求任务和
                backTrace(xuqiuIndex + 1, renwuhe);
                renwuhe[i] = renwuhe[i] - xuqiu[xuqiuIndex];
            }
        }
    }
}
