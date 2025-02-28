package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//AB出牌，求A赢得B的最大点数https://renjie.blog.csdn.net/article/details/131380684
//贪心，排序后，A拿最小的点数去赢B的牌，如果a小于b就继续找，默认是a小于b的牌去抵掉b最大的牌。
//https://leetcode.cn/problems/assign-cookies/solutions/534281/fen-fa-bing-gan-by-leetcode-solution-50se/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
public class ShuZiXuLieBiDaXiao2 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {

            String[] a = in.nextLine().split(" ");

            int m = Integer.valueOf(a[0]);//row
            String[] b = in.nextLine().split(" ");
            String[] c = in.nextLine().split(" ");
            Integer[] pa = transfer(b);
            Integer[] pb = transfer(c);
            Arrays.sort(pa);
            Arrays.sort(pb);
            int count = 0;
            for (int i = 0, j = 0; i < m && j < m; i++, j++) {
                while (j < m && pa[i] < pb[j]) {
                    count--;
                    i++;
                }
                if (pa[i] > pb[j]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static Integer[] transfer(String[] a) {
        Integer b[] = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.valueOf(a[i]);
        }
        return b;
    }
}
