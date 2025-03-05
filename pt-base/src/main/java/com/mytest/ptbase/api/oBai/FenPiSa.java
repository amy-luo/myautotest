package com.mytest.ptbase.api.oBai;

import java.util.Scanner;

//分披萨，要用long型，总量肯定超出了int的范围2147483648，不是吃左边就是吃右边，要用回溯。用回溯算法解决。
//https://renjie.blog.csdn.net/article/details/135297269
//用两个指针，一个指针加，一个指针减。超出范围循环设置。两个指针相等时，最后一块由吃货吃，结束吃披萨。
//直接暴力回溯可能会爆栈，披萨个数可达500，再思考下。。。用一个二维数组记录每次（每次可供选择的index1和index2）回溯的状态，（吃左边还是hi右边）取最大值。
public class FenPiSa {
    public static long K;//吃货吃的披萨总数
    public static long[] ps;
    public static long maxCount;
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()) {
            int N = Integer.valueOf(String.valueOf(in.nextLong()));
//            System.out.println(497);
//            for(int i=3;i<500;i++) {
//                System.out.println(i);
//            }
            ps = new long[N];
            K = (N + 1) / 2;
            for (int i = 0; i < N; i++) {
                ps[i] = in.nextLong();
            }
            maxCount = Integer.MIN_VALUE;
            long[][] memory = new long[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    memory[i][j] = 0L;
                }
            }
            for (int i = 0; i < N; i++) {
                maxCount=Math.max(maxCount,ps[i]+backTrack(i + 1, i - 1, memory));
            }
            System.out.println(maxCount);
        }
    }

    public static long backTrack(int index1,int index2,long[][] memory){
        if(index1==ps.length){index1=0;}//超限重设置
        if(index2==-1){index2=ps.length-1;}//超限重设置
        if(index1==index2){//重设置后重判断
            memory[index1][index2]=ps[index1];
//            System.out.println();
            return memory[index1][index2];
        }
        if(ps[index1]>ps[index2]){
            index1++;//馋嘴吃最大的披萨
        }else{
            index2--;
        }

        if(index1==ps.length){index1=0;}//超限重设置
        if(index2==-1){index2=ps.length-1;}//超限重设置
        if(index1==index2){//重设置后重判断
            memory[index1][index2]=ps[index1];
//            System.out.println(count);
        }else {

            if(memory[index1][index2]<=0L) {//遇到该双指针位置有计算过吃到的最大披萨值，直接复用，无需再计算
                //吃货选择index1
                memory[index1][index2] = ps[index1] + backTrack(index1 + 1, index2, memory);
                //吃货选择index2,保存该双指针位置吃到的最大的披萨值，后续递归遇到，就不用计算了。
                memory[index1][index2] = Math.max(memory[index1][index2], ps[index2] + backTrack(index1, index2 - 1, memory));
            }
        }
        return memory[index1][index2];
    }
}
