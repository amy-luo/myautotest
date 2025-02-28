package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;

//项目排期/最少交付时间，https://renjie.blog.csdn.net/article/details/135195692
//让需求去找人，一个需求只能选择一个人来完成。
//改成了二分递归回溯，如果有一个人手里的任务和超出了mid，就不再进行递归
public class XiangMuPaiQiErFen {
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

            timeMin = Integer.MAX_VALUE;//记得初始化，添加每种情况的完成天数，以方便找到最小值
            int right = Arrays.stream(xuqiu).sum();
            int left = right / n;
            int mid = 0;
            int res = Integer.MAX_VALUE;
            while (left <= right) {
                mid = (left + right) / 2;
                int[] renwuhe = new int[n];//每人手里的任务和分别存储在这里
                if (backTrace(0, renwuhe, mid)) {
                    right = mid - 1;
                    res = Math.min(mid, res);
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(res);
        }
    }

    private static boolean backTrace(int xuqiuIndex, int[] renwuhe, int mid) {
        if (xuqiuIndex == m) {//需求个数达到m时
            return true;
        } else {
            for (int i = 0; i < n; i++) {//每个需求任务可以选择一个人来完成。一个需求只能选择一个人。
                renwuhe[i] = renwuhe[i] + xuqiu[xuqiuIndex];//每人手里的需求任务和
                if (renwuhe[i] <= mid) {//任务和查出mid就不递归再找了。
                    boolean res = backTrace(xuqiuIndex + 1, renwuhe, mid);
                    if (res) {
                        return true;//找到了一个满足的组合就返回true；
                    }
                }
                renwuhe[i] = renwuhe[i] - xuqiu[xuqiuIndex];
            }
        }
        return false;//还没到m，且所有组合的任务都超出了mid，那么就返回false。
    }
}
