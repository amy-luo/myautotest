package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//工号不够用了怎么办,https://renjie.blog.csdn.net/article/details/128003990
//数字计算，逻辑能力Math.pow(26, (double)n)，求10的n次方：乘以多少个10才能大于的等于目标值
public class GongHaoBuGouYongLeZenMeBan {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(" ");
            Long m = Long.valueOf(s[0]);
//            double m =Math.pow(2, 50);
            Long n = Long.valueOf(s[1]);
            double max = m/Math.pow(26, (double)n);
            double tmp=1;
            for (int i = 1; i <=max; i++) {
                tmp=10*tmp;
                if(tmp>=max){
                    System.out.println(i);
                    break;
                }
                }
            if(max<1){System.out.println(1);}
        }
            }
    }

