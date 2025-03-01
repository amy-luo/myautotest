package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;

//相同数字组成图形的周长,https://hydro.ac/d/HWOD2023/p/OD080
//找每个数字周围四个数字的值是否与自己相同，如果不同边长就加1
public class XiangTongShuZiZuChengDeTuXingZhouChang {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());
            matrix = new int[64][64];
            int[] targetData = new int[m];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int target = dataArray[0];
                targetData[i] = target;
                for (int j = 1; j < dataArray.length; j = j + 2) {
                    matrix[dataArray[j]][dataArray[j + 1]] = target;
                }
            }
            int[] sum = new int[m];
            for (int k = 0; k < m; k++) {
                int target = targetData[k];
                for (int i = 0; i < 64; i++) {
                    for (int j = 0; j < 64; j++) {
                        if (matrix[i][j] == target) {
                            if (j==63||matrix[i][j + 1] != target) { sum[k]++;}
                            if (j==0||matrix[i][j - 1] != target) { sum[k]++;}
                            if (i==63||matrix[i+1][j] != target) { sum[k]++;}
                            if (i==0||matrix[i-1][j] != target) { sum[k]++;}
                        }
                    }

                }
            }
            StringBuilder stb = new StringBuilder();
            for(int o:sum){
                stb.append(o + " ");
            }
            System.out.println(stb.toString());
        }
    }
}
