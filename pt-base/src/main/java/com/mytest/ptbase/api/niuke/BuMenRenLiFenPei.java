package com.mytest.ptbase.api.niuke;

import java.util.Arrays;
import java.util.Scanner;

//部门人力分配,https://renjie.blog.csdn.net/article/details/135033961
//二分法
public class BuMenRenLiFenPei {
    public static int[] dataArray;
    public static int m;
    public static int k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            k = Integer.valueOf(in.nextLine());

            dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = dataArray.length;//row
            Arrays.sort(dataArray);
            int left = dataArray[m - 1];
            int right = dataArray[m - 1] + dataArray[m - 2];
            int mid = 0;
            int res=Integer.MAX_VALUE;
            while (left <= right) {
                mid = (left + right) / 2;
                if (check(mid)) {
                    right=mid-1;
                    res=Math.min(res,mid);
                }else{
                    left=mid+1;}
            }
            System.out.println(res==Integer.MAX_VALUE?-1:res);
        }
    }

    private static boolean check(int mid) {
        int count = 0;
        for (int i = 0, j = m - 1; i <= j; ) {
            if (i==j||dataArray[i] + dataArray[j] <= mid) {
                i++;
            }
            j--;
            count++;
        }
        if(count>k){return false;}
        return true;
    }

}
