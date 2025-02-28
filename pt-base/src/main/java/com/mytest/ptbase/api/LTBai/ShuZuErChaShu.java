package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//数组二叉数https://renjie.blog.csdn.net/article/details/128158988
//递归，用深度优先。两次递归。StringBuilder插入第一个位置，LinkedList插入第一个位置
public class ShuZuErChaShu {
    public static Integer[] b;
    public static LinkedList<Integer> deque;
    public static Integer minZi;
    public static Integer minZiP;
    public static  StringBuilder stb;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] a = in.nextLine().split(" ");
        b=transfer(a);

        deque=new LinkedList<>();
        minZi=99999999;
        minZiP=1;
        stb=new StringBuilder();
        digui(1);
        digui2(minZiP);

//        for(Integer o:deque){
//            stb.append(o).append(" ");
//        }
        System.out.println(stb.toString());
    }
//找到最小子节点
    public static void digui(Integer n){
            if(b[n-1]==-1){return;}
            if((2*n>b.length&&2*n+1>b.length)||(b[2*n-1]==-1&&b[2*n]==-1)||n==b.length||n==b.length-1){
                if(b[n-1]<minZi){
                    minZi=b[n-1];
                    minZiP=n;
                }
                return;
            } else if(2*n+1<=b.length||2*n<=b.length){
                digui(2*n);
                digui(2*n+1);
            }
    }

    //根据最小子节点的坐标，递归网上找，拼接字符。
    public static void digui2(Integer p){
        stb.insert(0,b[p-1]+" ");
//            deque.addFirst(b[p-1]);
            p=p/2;
            if(p==0){return;}
            digui2(p);
    }

    public static Integer[] transfer(String[] a){
        Integer b[]=new Integer[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.valueOf(a[i]);
        }
        return b;
    }
}
