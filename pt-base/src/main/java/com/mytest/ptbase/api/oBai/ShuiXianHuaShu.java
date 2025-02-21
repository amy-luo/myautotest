package com.mytest.ptbase.api.oBai;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//水仙花数，https://renjie.blog.csdn.net/article/details/128131996
//遍历，判断是否是水仙花数
//快捷方法，先生成所有水仙花数，再根据n位数和返回第m个满足条件的水仙花数。
public class ShuiXianHuaShu {
    public static String[] s1;
    public static ArrayList<Integer> shuxianhuaList;
    public static boolean[][] isVisited;
    public static int m;
    public static int n;
    public static String s_shui;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            n = Integer.valueOf(s[0]);
            m = Integer.valueOf(s[1]);
            if (n < 3 || n > 7) {
                System.out.println(-1);
            } else {
                System.out.println(getHuaFast());
                int start = (int)Math.pow(10, n-1);
                int end = (int)Math.pow(10, n);
                boolean flag=false;
                ArrayList<Integer> shuixianhua = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    if (isHua(i)) {
                        shuixianhua.add(i);
                        if (shuixianhua.size()-1 == m) {
                            System.out.println(i);
                            flag=true;
                            break;
                        }
                    }
                }
//                System.out.println(JSONObject.toJSONString(shuixianhua));
                if(!flag&&m>shuixianhua.size()-1){
                    System.out.println(shuixianhua.size()*shuixianhua.get(shuixianhua.size()-1));
                }
            }
        }
    }

    private static boolean isHua(int num) {
        int tmp = num;
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+= (int)Math.pow(tmp % 10, n);
            tmp = tmp / 10;
        }
        return num == sum;
    }

    private static Integer getHuaFast() {
        s_shui="[1,2,3,4,5,6,7,8,9,153,370,371,407,1634,8208,9474,54748,92727,93084,548834,1741725,4210818,9800817,9926315]";
        s1=s_shui.substring(1,s_shui.length()-1).split(",");
        int value=-1;
        int count=0;
        for(String str:s1){
            if(str.length()==n){
                value=Integer.valueOf(str);
                if(count==m){return value;}
                count++;
            }
        }
        if(count-1<m){value=count*value;}
        return value;
    }
}
