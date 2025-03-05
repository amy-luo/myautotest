package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//项目排期/最少交付时间，https://renjie.blog.csdn.net/article/details/135195692
//暴力递归回溯，让需求去找人，一个需求只能选择一个人来完成。
//改成了二分递归回溯,以此为准
public class XiangMuPaiQi {
    public static int[] xuqiu;
    public static int m;
    public static ArrayList<Integer> timeMin;
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            xuqiu = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = xuqiu.length;
            n = Integer.valueOf(in.nextLine());//人
            int[] renwuhe = new int[n];//每人手里的任务和分别存储在这里

            timeMin = new ArrayList<>();//记得初始化，添加每种情况的完成天数，以方便找到最小值
            int right = Arrays.stream(xuqiu).sum();
            int left = right / n;
            int mid = 0;
            int result = Integer.MAX_VALUE;
            while (left <= right) {
                Arrays.fill(renwuhe,0);
                mid = (left + right) / 2;
                int res = backTrace(mid, 0, renwuhe);
                if (res != -1) {
                    right = mid - 1;
                    result = Math.min(result, res);
                } else {
                    left = mid + 1;
                }

            }
            System.out.println(result);
        }
    }

    private static int backTrace(int mid,int xuqiuIndex, int[] renwuhe) {
        if (xuqiuIndex == m) {//需求个数达到m时
            int maxSum =Arrays.stream(renwuhe).max().getAsInt();
            if (maxSum < mid) {
//            timeMin.add(maxSum);
                return maxSum;
            }
        }else {
            for (int i = 0; i < n; i++) {//每个需求任务可以选择一个人来完成。一个需求只能选择一个人。
                if (renwuhe[i] + xuqiu[xuqiuIndex] <= mid) {
                    renwuhe[i] = renwuhe[i] + xuqiu[xuqiuIndex]; //每人手里的需求任务和
                    int res = backTrace(mid, xuqiuIndex + 1, renwuhe);
                    if (res != -1) {
                        return res;
                    }
                    renwuhe[i] = renwuhe[i] - xuqiu[xuqiuIndex];
                }
            }
        }
        return -1;
    }

}
