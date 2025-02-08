package com.mytest.ptbase.api.niuke;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//给定非空字符串s，将该字符串分割成一些字串，使每个字串的ASC||码值的和为水仙花数。
public class ShuiXianHua {

    public static ArrayList<Integer> list;
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        int count=1;
        list =new ArrayList<>();
        find(s,count);
        int res=list.size()==1?list.get(0):-1;
        if(list.size()==0){res=0;}
        System.out.println(res);
    }

    public static void find(String s,int count){
        for(int i=1;i<s.length();i++){
            if(isHua(s.substring(0,i))){
                if(isHua(s.substring(i))){
                    count++;
                    list.add(count);
                }else{find(s.substring(i),count);}
            }
        }

    }

    public static boolean isHua(String s){
        char[] ch=s.toCharArray();
        int sum=0;
        for(char c:ch){
            sum+=c;
        }
        int num1=sum%10;
        int num2=sum/10%10;
        int num3=sum/10/10 ;
        return num1*num1*num1+num2*num2*num2+num3*num3*num3==sum;
    }
}
