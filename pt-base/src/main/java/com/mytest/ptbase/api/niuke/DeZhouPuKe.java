package com.mytest.ptbase.api.niuke;

import java.util.Arrays;
import java.util.Scanner;

//德州扑克，过程模拟，https://renjie.blog.csdn.net/article/details/130779057
public class DeZhouPuKe {
    public static int[] nums;
    public static String[] huase;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nums = new int[5];
        huase = new String[5];
        while (in.hasNextLine()) {
            for (int i = 0; i < 5; i++) {
                String[] dataArray = in.nextLine().split(" ");
                String s = dataArray[0];
                huase[i] = dataArray[1];
                if(s.equals("J")){s="11";}
                if(s.equals("Q")){s="12";}
                if(s.equals("K")){s="13";}
                if(s.equals("A")){s="1";}
                nums[i] = Integer.valueOf(s);
            }
            Arrays.sort(nums);
            if(is_tonghua()&&is_shunzi()){System.out.println(1);continue;}
            if(is_sitiao()){System.out.println(2);continue;}
            if(is_hulu()){System.out.println(3);continue;}
            if(is_tonghua()&&!is_shunzi()){System.out.println(4);continue;}
            if(!is_tonghua()&&is_shunzi()){System.out.println(5);continue;}
            if(is_santiao()){System.out.println(6);continue;}
        }
    }
    private static boolean is_shunzi() {
        for (int i = 0; i < 4; i++) {
            if (nums[i] +1!= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    private static boolean is_tonghua() {
        for (int i = 0; i < 4; i++) {
            if (!huase[i] .equals(huase[i + 1])){
                return false;
            }
        }
        return true;
    }
    private static boolean is_sitiao() {
        if(nums[0]==nums[3]||nums[1]==nums[4]){
            return true;
        }
        return false;
    }
    private static boolean is_hulu() {
        if((nums[0]==nums[1]&&nums[1]==nums[2]&&nums[2]!=nums[3]&&nums[3]==nums[4])
                ||(nums[0]==nums[1]&&nums[1]!=nums[2]&&nums[2]==nums[3]&&nums[3]==nums[4])){
            return true;
        }
        return false;
    }
    private static boolean is_santiao() {
        if((nums[0]==nums[1]&&nums[1]==nums[2]&&nums[2]!=nums[3]&&nums[3]!=nums[4])
                ||(nums[0]!=nums[1]&&nums[1]==nums[2]&&nums[2]==nums[3]&&nums[3]!=nums[4])
                ||(nums[0]!=nums[1]&&nums[1]!=nums[2]&&nums[2]==nums[3]&&nums[3]==nums[4])){
            return true;
        }
        return false;
    }
}
