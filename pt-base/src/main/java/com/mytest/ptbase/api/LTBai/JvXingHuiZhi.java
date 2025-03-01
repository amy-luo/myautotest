package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;

//矩形绘制，https://hydro.ac/d/HWOD2023/p/OD104
//用一个二维数组来记录整片区域，为1就是有面积，为0就是无面积，遍历每次操作的绘制矩形或擦除矩形的所有小格子，绘制就变1，擦除就变0
public class JvXingHuiZhi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = Integer.valueOf(s);
            matrix = new int[200][200];//二维数组来记录整片区域
            Character[] caozuo = new Character[m];
            Integer[][] data = new Integer[m][4];
            for (int i = 0; i < m; i++) {
                String[] dataArray = in.nextLine().split(" ");
                caozuo[i] = dataArray[0].charAt(0);
                for (int j = 1; j < dataArray.length; j++) {
                    data[i][j - 1] = Integer.valueOf(dataArray[j]);
                }
                if(caozuo[i] == 'd') {
                    for (int x = data[i][0]; x < data[i][2]; x++) {//填充图形，填入值1，原点位置是矩阵的100,100
                        for (int y = data[i][3]; y < data[i][1]; y++) {
                            matrix[100 + x][100 + y] = 1;
//                            System.out.println("100 + x: "+(100 + x)+"  100 + y: "+(100 + y));
                        }
                    }
                }else if(caozuo[i] == 'e'){
                    for (int x = data[i][0]; x < data[i][2]; x++) {//抹除图形，填入值0，原点位置是矩阵的100,100
                        for (int y = data[i][3]; y < data[i][1]; y++) {
                            matrix[100 + x][100 + y] = 0;
//                            System.out.println("100 + x: "+100 + x+"  100 + y: "+100 + y);
                        }
                    }
                }
            }
            int sum=0;
            for (int i = 0; i < 200; i++) {
                for (int j = 0; j < 200; j++) {
                    if(matrix[i][j]==1){
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
