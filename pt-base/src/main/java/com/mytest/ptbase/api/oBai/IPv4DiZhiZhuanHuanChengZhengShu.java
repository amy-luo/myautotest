package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//自由练习
public class IPv4DiZhiZhuanHuanChengZhengShu {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            String res = "";
            if(s.indexOf("#")==-1){
                res = "invalid IP";}
            String[] str=s.split("#");
            if(str.length!=4){res = "invalid IP";}
            if(!res.equals("invalid IP")) {
                StringBuilder stb = new StringBuilder();
                for (int i = 0; i < str.length; i++) {
                    String er = Integer.toString(Integer.valueOf(str[i]), 2);
                    stb.append(er);
                }
                res = Integer.toString(Integer.valueOf(stb.toString()), 10);
            }
            System.out.println(res);
        }
    }

}
