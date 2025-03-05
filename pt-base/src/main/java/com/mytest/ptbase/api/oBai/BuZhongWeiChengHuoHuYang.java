package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//补种未成活胡杨，https://renjie.blog.csdn.net/article/details/128042733
//滑动窗口，只能连续补种K个坑，移动窗口，数坐标长度，注意边界值分析。
public class BuZhongWeiChengHuoHuYang {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s1=in.nextLine();
            String s2=in.nextLine();
            int N = Integer.valueOf(s1);
            int M = Integer.valueOf(s2);
            int[] buzhong = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int K = Integer.valueOf(in.nextLine());//row
            int maxlength=0;
            for (int i = 0,j=i+K; j <= buzhong.length; i++,j++) {//分别补种i:0个坑->j:K个坑。
               int length=0;
               if(i==0&&j<buzhong.length){length=buzhong[j]-1;}
               if(i==0&&j==buzhong.length){length=N;}
               if(i>0&&j==buzhong.length){length=N-buzhong[i-1];}
               if(i>0&&j<buzhong.length){length=buzhong[j]-buzhong[i-1]-1;}
                maxlength = Math.max(maxlength, length);
            }
            System.out.println(maxlength);
        }
    }

}
