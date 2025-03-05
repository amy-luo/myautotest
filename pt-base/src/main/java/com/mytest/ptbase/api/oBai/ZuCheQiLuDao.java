package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//租车骑绿岛，https://renjie.blog.csdn.net/article/details/127972503
//贪心，从小到大排序，最小的和最大的进行组合，看是否可行。
public class ZuCheQiLuDao {
    public static int[] ren;
    public static int m;
    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = dataArray[0];
            n = dataArray[1];//col
            ren = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(ren);//排序
            int count = 0;
            for (int i = 0, j = n - 1; i <= j; ) {
                if (i == j || ren[i] + ren[j] <= m) {
                    i++;
                }
                j--;
                count++;
            }
            System.out.println(count);
//            int left = n / 2;
//            int right = n;
//            int mid = 0;
//            int res = Integer.MAX_VALUE;
//            while (left <= right) {
//                mid = (left + right) / 2;
//                if (isOk(mid)) {
//                    right = mid - 1;
//                    res = Math.min(res, mid);
//                } else {
//                    left = mid + 1;
//                }
//            }
//            System.out.println(res);

        }
    }

//    private static boolean isOk(int mid) {
//        int count = 0;
//        for (int i = 0, j = n - 1; i <= j; ) {
//            if (i == j || ren[i] + ren[j] <= m) {
//                i++;
//            }
//            j--;
//            count++;
//        }
//        if (count > mid) {
//            return false;
//        }
//        return true;
//    }

}
