package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//递归回溯：https://renjie.blog.csdn.net/article/details/142267363
public class QuanPaiLIE2 {
    public static boolean[] isExist;
    public static List<String> solutions = new ArrayList<>();
    public static int N;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] s=in.nextLine().split(" ");
        char[] ch=s[0].toCharArray();//所有的字符
        N=Integer.valueOf(s[1]);//子字符串的长度


        StringBuilder stb = new StringBuilder();
        isExist = new boolean[ch.length];
        Arrays.sort(ch);//排序
        backtrack(ch, 0, stb);
        System.out.println(solutions);
        System.out.println(solutions.size());
    }

    public static void backtrack(char[] ch, int index, StringBuilder stb) {//index是全排列子数组的长度的指针
        if (index== N) {//终止，subList被填满数组长度时
            solutions.add(stb.toString());//将List<Integer> subList转为ArrayList<Integer>再被添加
            return;
        }
//        solutions.add(stb.toString());//如果不是全排列，是全排列+所有子数组，就要把中间过程的字符串加上。加上这句话。
        for (int i = 0; i < ch.length; ++i) {
            if (isExist[i] || (i > 0 && ch[i] == ch[i - 1] && !isExist[i - 1])||(index>0&&ch[i]==stb.charAt(index-1))) {//相同元素如果左边的元素没加过，后面相同的这个元素就不能加，优先左边元素，有序，目的是去重
                continue;//如果元素已存在就跳过。相同元素如果左边没加就跳过，左边加了可以加。相同元素是要有序的，目的是去重。如果该元素与已加的上个元素相同则跳过该元素
            }
            stb.append(ch[i]);//增加该元素
            isExist[i] = true;//数组中某元素的索引已被添加
            backtrack(ch,  index + 1, stb);//递归
            isExist[i] = false;//数组中某元素的索引已被删除
            stb.deleteCharAt(index);//删除该元素，跳过该元素的情况
        }
    }
}
