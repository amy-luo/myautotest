package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//字符串加密,https://renjie.blog.csdn.net/article/details/128085257
//字符加减，偏移
public class ZiFuChuanJiaMi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            int m = Integer.valueOf(s);
            int[] a = new int[51];
            a[0]=1;
            a[1]=2;
            a[2]=4;
            for (int i = 3; i <= 50; i++) {
                a[i] = a[i - 1] + a[i - 2] + a[i - 3];
            }
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String str=in.nextLine();
                StringBuilder stb = new StringBuilder();
                for(int j=0;j<str.length();j++){
                    stb.append((char)((str.charAt(j)+a[j]-'a')%26+'a'));
                }
                list.add(stb.toString());
            }
            for(String o:list){
                System.out.println(o);
            }
        }
    }

}
