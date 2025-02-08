package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//评论转输出https://renjie.blog.csdn.net/article/details/131110521
//递归,树状结构
public class PingLunDiGui {
    public static String[] a;
    public static HashMap<Integer,ArrayList<String>> map;
    public static Integer count;//存放层级
    public static Integer i;//存放数组指针

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            a = in.nextLine().split(",");
            map = new HashMap<>();
            i=0;
            count=0;
            map=new HashMap<>();
            while(i<a.length) {
               digui();
               i=i+2;
            }
            System.out.println(map.size());
            for(int i=0;i<map.size();i++){
                StringBuilder stb=new StringBuilder();
                for(String o:map.get(i)){
                    stb.append(o).append(" ");
                }
                System.out.println(stb.toString());
            }

        }
    }
    public static void digui() {
        if (i >= a.length) {
            return;
        }
        ArrayList<String> list1 = map.getOrDefault(count,new ArrayList<String>());
        list1.add(a[i]);
        map.put(count,list1);
        int limit=Integer.valueOf(a[i + 1]);//子评论数；
        if(i+1>=a.length){return;}
        while(limit>0) {
            i=i+2;
            count++;
            digui();//递归查找自评论数；
            count--;
            limit--;
            if (i>= a.length) {
                  return;
           }
        }
    }
}
