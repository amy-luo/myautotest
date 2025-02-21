package com.mytest.ptbase.api.oBai;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

//路灯照明，https://renjie.blog.csdn.net/article/details/128041922
//找到最大间距除以2；第一个与前面的距离，最后一个路灯与后面的距离不需要除以2；
// 保留2位小数，DecimalFormat decimalFormat=new DecimalFormat("#.00");
public class LuDengZhaoMing {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
                    String[] s=in.nextLine().split(" ");
            int m = Integer.valueOf(s[0]);
            int k = Integer.valueOf(s[1]);
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(dataArray);
            double res=Math.max(dataArray[0],k-dataArray[m-1]);
            for (int i = 1; i < m; i++) {
                res= Math.max(res,((double)dataArray[i]-(double)dataArray[i-1])/2);}
            DecimalFormat decimalFormat=new DecimalFormat("#.00");//保留2位小数
            String sres=decimalFormat.format(res);
            System.out.println(sres);
        }
    }

}
