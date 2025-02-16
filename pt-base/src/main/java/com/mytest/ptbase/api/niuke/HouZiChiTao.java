package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.ceil;

//猴子吃桃，爱吃蟠桃的孙悟空，https://renjie.blog.csdn.net/article/details/128139473
//二分法
public class HouZiChiTao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = firstHang[firstHang.length - 1];//row//r
            firstHang[firstHang.length - 1] = 0;
            int sum = Arrays.stream(firstHang).sum();
            int left = (int)Math.ceil((double)sum / (double)m );
            int right = Arrays.stream(firstHang).max().getAsInt();
            int mid = left;
            int res = Integer.MAX_VALUE;
            while (left <= right) {
                mid = (left + right) / 2;
                int he = 0;
                for (int i=0;i<firstHang.length-1;i++) {
                    he += (int) Math.ceil((double) firstHang[i] / (double) mid);
                }
                if (he <= m) {
                    res = Math.min(res, mid);
                    right = mid - 1;
                } else if (he > m) {
                    left = mid + 1;
                }
            }
            System.out.println(res == Integer.MAX_VALUE ? -1 : res);
        }
    }
}
