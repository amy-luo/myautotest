package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//最长子字符串的长度,https://renjie.blog.csdn.net/article/details/130894025
public class ZuiChangZiZiFuChuanDeChangDu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'o') {
                    sum++;
                }
            }
            if(sum%2==0){
                System.out.println(s.length());
            }else{
                System.out.println(s.length()-1);
            }
        }

    }
}
