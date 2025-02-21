package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//最远足迹，https://renjie.blog.csdn.net/article/details/128105233
//遍历，判断是否合法,注意x,y的限制条件。
public class ZuiYuanZuJi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s=in.nextLine();
            int index1=0;
            int index2=0;
            ArrayList<String> list=new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='('){
                    index1=i;
                }
                if(s.charAt(i)==')'){
                    index2=i;
                    list.add(s.substring(index1+1, index2));
                }
            }
            int max=Integer.MIN_VALUE;
            String res = "(0,0)";
            for(String str:list){
                String[] ar=str.split(",");
                if(ar[0].charAt(0)!='0'&&ar[1].charAt(0)!='0'){//判断是否合法
                    int x = Integer.valueOf(ar[0]);
                    int y = Integer.valueOf(ar[1]);
                    if(0<x&&x<1000&&0<y&&y<1000) {
                        if (x * x + y * y > max) {
                            max = x * x + y * y;
                            res = "(" + x + "," + y + ")";
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }

}
