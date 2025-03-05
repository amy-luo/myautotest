package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//寻找关键钥匙,https://renjie.blog.csdn.net/article/details/128303606
//密室逃生游戏
public class XunZhaoGuanJianYaoShiMiShiTaoSheng {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String target = in.nextLine();
            target = sortStr(target);//目标字符串已排序完成并赋值

            String[] s = in.nextLine().split(" ");
            int index=-1;
            for (int i = 0; i < s.length;i++) {
                s[i]=sortStr(s[i].replaceAll("[^a-zA-Z]+", "")).toLowerCase();
                if (s[i].equals(target)) {
                    index = i;
                    break;
                }
            }
//            StringBuilder stb = new StringBuilder();
            System.out.println(index==-1?index:index+1);
        }
    }
    private static String sortStr(String target){
        char[] ch_target = target.toCharArray();
        for(int i=0;i<target.length();i++){
            ch_target[i] = target.charAt(i);
        }
        Arrays.sort(ch_target);
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<ch_target.length;i++){
            stb.append(ch_target[i]);
        }
        target = stb.toString();//目标字符串已排序完成并赋值
        return target;
    }
}
