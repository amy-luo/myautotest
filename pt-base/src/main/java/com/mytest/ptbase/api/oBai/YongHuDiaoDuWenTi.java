package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//用户调度问题,https://renjie.blog.csdn.net/article/details/130898635
//局部最优，多个满足条件时，选择最后一个
public class YongHuDiaoDuWenTi {
    public static int[][] matrix;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            int m = Integer.valueOf(s);
            int index=-1;
            int sumCount=0;
            matrix = new int[m][3];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int minHao=Integer.MAX_VALUE;
                int index2=-1;
                for (int j = 0; j < 3; j++) {
                    matrix[i][j]=dataArray[j];
                    if(j!=index&&matrix[i][j]<=minHao){//多个满足条件时，选择最后一个，要用小于等于
                    minHao=matrix[i][j];
                    index2=j;
                    }
                }
                index=index2;
                sumCount+=minHao;
            }
            System.out.println(sumCount);
        }
    }

}
