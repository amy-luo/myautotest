package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//最多提取子串数目,https://blog.csdn.net/weixin_45611920/article/details/130473332
//从0遍历字符串1看是否与字符串2的字符相等，匹配完之后+1，然后重新右开始匹配一遍，上次匹配过的字符不能再被访问（所以之前匹配过的字符要打标记)
public class ZuiDuoTiQuZiChuanShuMu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            int k = 0;
            int sum = 0;
            boolean[] used = new boolean[26];
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(k) && !used[i]) {
                    used[i] = true;
                    k++;
                }
                if (k == str2.length()) {
                    sum++;
                    k = 0;
                    i = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
