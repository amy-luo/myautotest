package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//会议接待，代表团坐车，https://renjie.blog.csdn.net/article/details/130804633
//回溯法，找出不重复子序列，且子序列的和为一个设定的固定值。
public class DaiBiaoTuanZuoCheHuiSu {
    public static int[] firstHang;
    public static int rongLiang;
    public static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            firstHang = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            rongLiang = Integer.valueOf(in.nextLine());//col
            huisuFangan(0, 0);
            System.out.println(count);
        }

    }

    private static void huisuFangan(int num, int j) {
        if (j == firstHang.length) {
            return;
        }
        if (num == rongLiang) {
            count++;
            return;
        }
        //这种写法也行，好理解
//        huisuFangan(num + firstHang[j], j + 1);//带上这个元素
//        huisuFangan(num, j + 1);//不带上这个元素

        //依次选择j及以后的元素，如果选择了以后的元素，当前j这个元素就不会选。
        // 起始i=j保证了j以前的元素不会选，保证了选择顺序是从左到右的（即，去重）。如果选择了元素i，那么下一行j直接跳到i+1，因为i前面的元素没必要再选了。
        for(int i=j;i<firstHang.length;i++){
            huisuFangan(num + firstHang[i], i + 1);
        }
    }
}
