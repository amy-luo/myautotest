package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//编码能力提升计划，二分法
public class BianMaNengLiTiSheng {
    public static int[] firstHang;
    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            firstHang = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
             m = Integer.valueOf(in.nextLine());//row
            int left=0;
            int right=Arrays.stream(firstHang).sum();
            int mid=0;
            int res=0;
            while(left<=right) {
                mid = (left + right) / 2;
                if (isPass(mid) != -1) {
                    res = isPass(mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(res);

        }
    }
    private static Integer isPass(int mid){
        int sum=0;//用来统计每天的耗时
        int maxTime=0;//记录最大的耗时（已跳过每天的最耗时的题）
        int count=0;//记数，总共m天
        int kandaan=Integer.MIN_VALUE;//记录每天最耗时的看答案的题，当天最大耗时题
        for (int i = 0; i < firstHang.length; i++) {
            if(count>=m){return -1;}
            int kandaan2 = Math.max(kandaan, firstHang[i]);//记录包含当天的最大耗时的题
            sum+=firstHang[i];
            if(sum - kandaan2>mid){//减去最耗时题，加上当前元素时的sum - kandaan>mid。
                maxTime = Math.max(maxTime, sum-firstHang[i]-kandaan);//记录跳过后的最大耗时，sum-firstHang[i]-kandaan，sum减去去掉今天的最大耗时，减去当前元素
                count++;//指向下一天
                sum=0;//重置，为了计算第二天
                kandaan=Integer.MIN_VALUE;//重置，为了计算第二天
                i--;//做不完的题，放二天；
            }else{kandaan=kandaan2;}//包含今天的的最大耗时
        }
        return maxTime;
    }
}
