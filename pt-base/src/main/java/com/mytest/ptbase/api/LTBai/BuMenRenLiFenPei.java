package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;

//部门人力分配,https://renjie.blog.csdn.net/article/details/135033961
//二分法，给每个最大的元素搭配一个最小的元素，看是否超出，如果还超出就只能处理这一个元素了。
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
            if (i==j||dataArray[i] + dataArray[j] <= mid) {//给每个最大的元素搭配一个最小的元素，如果还超出就只能处理这一个元素了。
                i++;
            }
            j--;
            count++;
        }
        if(count>k){return false;}
        return true;
    }

}
