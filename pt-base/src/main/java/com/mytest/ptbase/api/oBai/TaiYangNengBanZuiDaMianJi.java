package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//太阳能板最大面积,https://renjie.blog.csdn.net/article/details/130712562
//双指针，类似于水槽。每次移动高度小的指针。
public class TaiYangNengBanZuiDaMianJi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] str = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int maxS=0;
            for (int left = 0,right=str.length-1; left<=right;) {
               int s=Math.min(str[left],str[right])*(right-left);
                maxS = Math.max(maxS, s);
                if(str[left]<str[right]){
                    left++;
                }else{right--;}
            }
            System.out.println(maxS);
        }
    }

}
