package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//因为输入法，前缀匹配字符串
public class ShuRuFa {
    public static HashSet<String> set;
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        set =new HashSet<>();
        for(String o:s){
            if(o.indexOf("'")!=-1){
                String[] s1=o.split("'");
                set.addAll(Arrays.asList(s1));
            }else{set.add(o);}
        }
        String input=in.nextLine();
        StringBuilder stb=new StringBuilder();
        for(String ss:set){
            if(ss.contains(input)){
                stb.append(ss).append(" ");
            }
        }
        System.out.println(stb.length()!=0?stb.toString():input);
    }

}
