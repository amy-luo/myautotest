package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//按单词下标区间翻转文章内容，https://renjie.blog.csdn.net/article/details/128497797
//双指针，按照指针移动分别交换顺序，对于输入的指针l和r超出边界时，要拉回到数组的边界后，再开始遍历。
public class AnDanCiXiaBiaoQuJianFanZhuanWenZhangNeiRong {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] input = in.nextLine().split(" ");
            int l = Math.max(Integer.valueOf(in.nextLine()),0);
            int r = Math.min(Integer.valueOf(in.nextLine()),input.length-1);
            for (int left=l,right=r;left<right;) {
                String tmp= input[right];
                input[right] = input[left];
                input[left] = tmp;
                left++;
                right--;
            }
            StringBuilder stb = new StringBuilder();
            for(String o:input){
                stb.append(o + " ");
            }
            System.out.println(stb.toString());
        }
    }

}
