package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//英文输入法，前缀匹配字符串
//https://renjie.blog.csdn.net/article/details/130658361
public class YingWenShuRuFa {
    public static HashSet<String> set;

    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().replaceAll("[,'.]", " ").split(" ");
        set = new HashSet<>();
        for (String o : s) {
            if (!o.equals("")) {
                set.add(o);
            }
        }
        String input = in.nextLine();
        StringBuilder stb = new StringBuilder();
        for (String ss : set) {
            if (ss.startsWith(input)) {
                stb.append(ss).append(" ");
            }
        }
        System.out.println(stb.length() != 0 ? stb.toString() : input);
    }
}