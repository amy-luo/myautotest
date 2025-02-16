package com.mytest.ptbase.api.niuke;

import java.util.Scanner;

//分披萨，要用long型，总量肯定超出了int的范围2147483648，不是吃左边就是吃右边，要用回溯。用回溯算法解决。
//https://renjie.blog.csdn.net/article/details/135297269
//用两个指针，一个指针加，一个指针减。超出范围循环设置。两个指针相等时，最后一块由吃货吃，结束吃披萨。
//直接暴力回溯可能会爆栈，披萨个数可达500，再思考下。。。
public class FenPiSa {
    public static long K;//吃货吃的披萨总数
    public static long[] ps;
    public static long maxCount;
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int N = Integer.valueOf(String.valueOf(in.nextLong()));
        ps=new long[N];
        K=(N+1)/2;
        for(int i=0;i<N;i++){
            ps[i]=in.nextLong();
        }
        maxCount = 0;

        for(int i=0;i<N;i++){
            long count=ps[i];
            backTrack(i+1,i-1,count);
        }
        System.out.println(maxCount);
    }

    public static void backTrack(int index1,int index2,long count){
        if(index1==ps.length){index1=0;}
        if(index2==-1){index2=ps.length-1;}
        if(index1==index2){
            count+=ps[index1];
            maxCount=Math.max(maxCount,count);
//            System.out.println();
            return;
        }
        if(ps[index1]>ps[index2]){
            index1++;
        }else{
            index2--;
        }

        if(index1==ps.length){index1=0;}
        if(index2==-1){index2=ps.length-1;}
        if(index1==index2){
            count+=ps[index1];
            maxCount=Math.max(maxCount,count);
//            System.out.println(count);
            return;
        }
        //吃货选择index1
        count+=ps[index1];
        backTrack(index1+1,index2,count);
        count-=ps[index1];
        count+=ps[index2];
        backTrack(index1,index2-1,count);
        count-=ps[index2];
        //吃货选择index2
    }
}
