package com.mytest.ptbase.api.oBai;

import java.util.*;

//响应报文时间，https://renjie.blog.csdn.net/article/details/130168348
//16进制与运算，或运算，二进制移位运算
public class XiangYingBaoWenShiJian {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
           int m=in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int num1=in.nextInt();
                int num2=in.nextInt();
                int num=num1+num2;
                if(num2>=128){
                    int mant=num2&0x0F;//最大相应时间和16进制15做与运算，再做二进制右移计算
                    int exp=(num2&0x70)>>4;//最大相应时间和16进制7做与运算，再做二进制右移计算
                    num = num1+(mant | 0x10) << (exp + 3);//与16进制的或运算
                }
                list.add(num);
            }
            System.out.println(Collections.min(list));
        }
    }
}
