package com.mytest.ptbase.api.niuke;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//解压报文，报文解压缩,正则匹配,循环匹配，从外往内，https://renjie.blog.csdn.net/article/details/128085502
//报文解压
//为了提升数据传输的效率，会对传输的报文进行压缩处理。
//输入一个压缩后的报文，请返回它解压后的原始报文。
//压缩规则：n[str]，表示方括号内部的 str 正好重复 n 次。
//注意 n 为正整数（0 < n <= 100），str只包含小写英文字母，不考虑异常情况
public class JieYaBaoWen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String firstHang=in.nextLine();
            Pattern pattern=Pattern.compile("(\\d+\\[[a-z]+\\])");
            Matcher matcher=pattern.matcher(firstHang);
            while (matcher.find()){
                String findRes=matcher.group();
                String pinhaoRes=jieYaSuo(findRes);
                firstHang=firstHang.replace(findRes,pinhaoRes);
                matcher=pattern.matcher(firstHang);
            }
            System.out.println(firstHang);
      }
    }

    private static String jieYaSuo(String findRes){
        int m=Integer.valueOf(findRes.substring(0,findRes.indexOf("[")));
        String s=findRes.substring(findRes.indexOf("[")+1,findRes.length()-1);
        StringBuilder stb=new StringBuilder();
        for(int i=0;i<m;i++){
            stb.append(s);
        }
        return stb.toString();
    }

}
