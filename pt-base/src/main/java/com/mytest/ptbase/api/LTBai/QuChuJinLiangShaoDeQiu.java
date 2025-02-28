package com.mytest.ptbase.api.LTBai;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//取出尽量少的球,https://hydro.ac/d/HWOD2023/p/OD041
//二分法
public class QuChuJinLiangShaoDeQiu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int sum = Integer.valueOf(s[0]);//row
            int maxCap = Integer.valueOf(s[1]);//row
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int he = Arrays.stream(dataArray).sum();
            int right = Arrays.stream(dataArray).max().getAsInt();
            if (he > sum) {
                int left = 1;
                int mid = 1;
                int res=Integer.MIN_VALUE;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if(check(dataArray,mid,he,sum)){
                        left=mid+1;
                        res = Math.max(res, mid);
                    }else{
                        right=mid-1;
                    }
                }
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < dataArray.length; i++) {
                    if (dataArray[i] > mid) {
                        list.add(dataArray[i] - mid);
                    }else{
                        list.add(0);}
                }
                System.out.println(JSONObject.toJSONString(list));
            } else {
                System.out.println("[]");
            }
        }
    }

    private static boolean check(int[] dataArray, int mid, int he, int sum) {
        int count = 0;
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] > mid) {
                count += dataArray[i] - mid;
            }
        }
        if (he - count <=sum) {
            return true;
        } else {
            return false;
        }
    }
}
