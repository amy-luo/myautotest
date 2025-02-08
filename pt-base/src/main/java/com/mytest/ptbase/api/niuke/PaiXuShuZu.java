package com.mytest.ptbase.api.niuke;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//数组排序，
//给一串非负整数，重新排序后，返回一个最大数
public class PaiXuShuZu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
        String[] a=in.nextLine().split(" ");
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }});
        StringBuilder stb=new StringBuilder();
        for(String o:a){
            stb.append(o);
        }
        System.out.println(stb.toString());}
    }
    }
