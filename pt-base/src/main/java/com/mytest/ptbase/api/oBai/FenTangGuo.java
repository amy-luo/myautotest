package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//分糖果，https://renjie.blog.csdn.net/article/details/130654617
//要用long，递归
public class FenTangGuo {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static long m;
//    public static long count;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            m=in.nextLong();
            long chouti=m%2==0?0:1;
            long shou=m%2==0?m:m-1;
            int count=0;
            count=dfsFenTang(m,0);
            System.out.println(count);
        }
    }
    private static int dfsFenTang(long num,int count){
        if(num==0){return 0;}
        if(num==1){return count;}
        if(num%2==0){
            count++;
            return dfsFenTang(num>>1, count);}
        else{
            return Math.min(dfsFenTang(num+1,count+1),dfsFenTang(num-1,count+1));
        }
    }
}
