package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//最优芯片资源占用,https://renjie.blog.csdn.net/article/details/128779545,最优资源分配
//逻辑分析
public class XinPianZiYuanZhanYong {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int m =Integer.valueOf(in.nextLine()) ;//row
            int n =Integer.valueOf(in.nextLine()) ;//row
            String[] firstHang = in.nextLine().split("");
            int[] dataxinpian = new int[firstHang.length];
            for(int i=0;i<firstHang.length;i++){
                if(firstHang[i].equals("A")){dataxinpian[i]=1;}
                if(firstHang[i].equals("B")){dataxinpian[i]=2;}
                if(firstHang[i].equals("C")){dataxinpian[i]=8;}
            }

            int[] capability = new int[n];
            Arrays.fill(capability,m);//赋值芯片的初始容量
            for (int i = 0; i < dataxinpian.length; i++) {
                if(dataxinpian[i]>m){continue;}
                for(int j=0;j<n;j++){
                    if(capability[j]>=dataxinpian[i]) {
                        capability[j] -= dataxinpian[i];
                        break;
                    }
                }
            }
            for(int o:capability){
                StringBuilder stb = new StringBuilder();
               for(int i=0;i<m-o;i++){
                   stb.append("1");
               }
                for(int i=0;i<o;i++){
                    stb.append("0");
                }
                System.out.println(stb.toString());
            }
        }
    }

}
