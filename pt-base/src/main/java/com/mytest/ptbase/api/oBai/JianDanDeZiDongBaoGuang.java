package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//简单的自动曝光，https://renjie.blog.csdn.net/article/details/128365422
//考虑边界值越界0和255的情况，从k的范围-127到128遍历，找出最小插值，math.abs
//求平均值要用double，小数点后不能忽视，会影响结果
public class JianDanDeZiDongBaoGuang {
    public static int[]dataArray;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double minchazhi=128;
            int mink=Integer.MAX_VALUE;
            for(int k=-127;k<=128;k++){
                double chazhi=getChaZhi(k);
                if(chazhi<minchazhi) {
                    minchazhi = chazhi;
                    mink=k;
                }
            }
            System.out.println(mink);
        }
    }
    private static double getChaZhi(int k){
        double sum=0;
        for(int i=0;i<dataArray.length;i++){
            int a=Math.max(0,Math.min(dataArray[i]+k,255));
            sum+=a;
        }
        return Math.abs(sum/dataArray.length-128);
    }
}
