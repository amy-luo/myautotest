package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//货币单位换算,https://renjie.blog.csdn.net/article/details/128401959
//字符串处理，正则匹配后split，switch枚举类型
public class HuoBiDanWeiHuanSuan {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            int m = Integer.valueOf(s);
            double sum=0;
            for (int i = 0; i < m; i++) {
                String data=in.nextLine();
                String[] leixing = data.split("\\d+");
                for(String type:leixing){
                    if(!type.equals("")) {
                        double money = Double.valueOf(data.substring(0, data.indexOf(type)));
                        sum += transfer(money, type);
                        data = data.substring(data.indexOf(type) + type.length());
                    }
                }
             }
            System.out.println((int)sum);
        }
    }
    private static double transfer(double money,String type){
        switch (type){
            case "CNY":
                return money*100;
            case "fen":
                return money;
            case "JPY":
                return 10000*money/1825;
            case "sen":
                return 100*money/1825;
            case "HKD":
                return 10000*money/123;
            case "cents":
                return 100*money/123;
            case "EUR":
                return 10000*money/14;
            case "eurocents":
                return 100*money/14;
            case "GBP":
                return 10000*money/12;
            case "pence":
                return 100*money/12;
        }
        return 0;
    }

}
