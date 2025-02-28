package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//求字符串中所有整数的最小和,https://renjie.blog.csdn.net/article/details/128130982
public class QiuZiFuChuanZhongSuoYouZhengShuDeZuiXiaoHe {
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
                char ch = s.charAt(i);
                if (ch == '-') {
                    i++;
                    int start = i;
                    while (Character.isDigit(s.charAt(i)) && i < s.length()) {
                        i++;
                    }
                    if (i >start) {
                        String sbs = s.substring(start, i);
                        sum -= Integer.parseInt(sbs);
                        i--;
                    }
                } else if (Character.isDigit(ch)) {
//                    sum += Integer.valueOf(ch);//不行，要用下面
                    sum += Character.digit(ch, 10);//不行，要用下面
                }
            }
            System.out.println(sum);
        }

    }

}
