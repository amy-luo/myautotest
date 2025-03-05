package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//靠谱的车，https://fcqian.blog.csdn.net/article/details/127418150
public class KaoPuDeChe {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            char[] ch = s.toCharArray();
            int count=0;
            for (int i = 0; i < ch.length; i++) {
                int num=ch[i]-'0';
                num=num>4?num-1:num;
                count += num * Math.pow(9, ch.length - 1-i);
            }
            System.out.println(count);
        }
    }

}
