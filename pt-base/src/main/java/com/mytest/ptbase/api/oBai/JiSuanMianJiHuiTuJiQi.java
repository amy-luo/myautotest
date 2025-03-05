package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//绘图机器,计算面积,https://renjie.blog.csdn.net/article/details/128104976
//矩形面积
public class JiSuanMianJiHuiTuJiQi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(" ");
            int m = Integer.valueOf(s[0]);
            int e = Integer.valueOf(s[1]);
            int[][] matrix = new int[m][4];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                matrix[i][0]=dataArray[0];
                matrix[i][1]=dataArray[1];
            }
            Arrays.sort(matrix, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            int sum=0;
            for(int i=1;i<m;i++){
                matrix[i][1]=Math.abs(matrix[i][1]+matrix[i-1][1]);//获取纵坐标后取绝对值
                sum+=(matrix[i][0]-matrix[i-1][0])*matrix[i-1][1];
            }
            sum+=(e-matrix[m-1][0])*matrix[m-1][1];
            System.out.println(sum);
        }
    }
}
