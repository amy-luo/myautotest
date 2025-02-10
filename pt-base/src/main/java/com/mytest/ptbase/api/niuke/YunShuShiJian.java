package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//运输时间,梳理追得上的条件，追得上，就是上量车的时间-1，追不上就是按自己速度走完的时间。
//动态规划，一维
//https://renjie.blog.csdn.net/article/details/135479843
public class YunShuShiJian {
    public static double[] cars;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = firstHang[0];//row
            int n = firstHang[1];//col
            cars=new double[m];
            for (int i = 0; i < m; i++) {
                 cars[i]= Integer.valueOf(in.nextLine());
            }
            double[] dp = new double[m+1];
            dp[0]=0;
            dp[1]=n/cars[0];
            for (int i = 2; i < m+1; i++) {
                if(cars[i-1]>cars[i-2]&&(n/cars[i-1])<(dp[i - 1]-1)) {//当这辆车的速度大于前辆车，且这辆车到达终点的时间小于上辆车到达终点的时间-1，就会追上
                    dp[i] = dp[i - 1] -1;
                }else {
                    dp[i] = n/cars[i-1];
                }
            }
            System.out.println(dp[m]);
        }
    }

}
