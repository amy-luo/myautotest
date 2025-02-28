package com.mytest.ptbase.api.oBai;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

//整数编码，https://renjie.blog.csdn.net/article/details/128499271
//反码,数字范围很大，初始值用长整型来转换成二进制字符串
//二进制转十进制Integer.parseInt("111",2)
//二进制转十六进制BigInteger bigInteger =new BigInteger("111",2);bigInteger.toString(16)，
//十进制转2,16进制。
//Integer.toHexString();十进制转16进制
//Integer.toBinaryString();十进制转2进制
//Integer.toString(3,2);Integer.toString(3,16);十进制转2,16进制
public class ZhengShuBianMa {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String num=Long.toBinaryString(in.nextLong());//用长整型来转换成二进制字符串
            int n=num.length()%8==0?num.length()/8:num.length()/8+1;//字节数
            int yu=num.length()%8;
            String num_16 = "";
            StringBuilder stb = new StringBuilder();
            if(yu!=0) {
               BigInteger bigInteger =new BigInteger(num.substring(0, yu),2);
               num_16=bigInteger.toString(16);
            }else{
                BigInteger bigInteger =new BigInteger(num.substring(1, 8),2);
                num_16=bigInteger.toString(16);
                Integer.toString(3,2);
            }
            stb.insert(0,num_16);
            for(int i=1;i<n;i++){
                BigInteger bigInteger =new BigInteger("1"+num.substring(yu+8*(i-1)+1, yu+8*(i-1)+8),2);
                String num2_16=bigInteger.toString(16);
                stb.insert(0,num2_16);
            }
            if(stb.length()==1){
                System.out.println("0"+stb.toString().toUpperCase());
            }else {
                System.out.println(stb.toString().toUpperCase());
            }
        }
    }

}
