package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//IPv4地址转换成整数，https://renjie.blog.csdn.net/article/details/128496681
//进制转换
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
                int count=0;
                boolean flag=true;
                for (int i = 0; i < str.length; i++) {
                    int tmp=Integer.valueOf(str[i]);
                    if(i==0&&(tmp<1||tmp>128)){
                        res = "invalid IP";
                        flag=false;
                        break;
                    }
                    if(i>0&&(tmp<0||tmp>255)){
                        res = "invalid IP";
                        flag=false;
                        break;
                    }
                    count+=tmp<<8*(3-i);
//                    String er = Integer.toString(Integer.valueOf(str[i]), 2);
//                    stb.append(er);
//                    count+=Integer.valueOf(str[i])*Math.pow(2,8*(3-i));
                }
                if(flag) {
                    res = String.valueOf(count);
                }
//                res = Integer.toString(Integer.valueOf(stb.toString()), 10);//超出了整型范围
            }
            System.out.println(res);
        }
    }

}
