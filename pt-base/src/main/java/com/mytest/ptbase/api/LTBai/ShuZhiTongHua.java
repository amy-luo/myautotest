package com.mytest.ptbase.api.LTBai;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

//DFS矩阵数值同化，https://blog.csdn.net/misayaaaaa/article/details/127947829
public class ShuZhiTongHua {
    public static int[] direct;
    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] a = in.nextLine().split(" ");

        int m = Integer.valueOf(a[0]);//row
        int n = Integer.valueOf(a[1]);//col
//        System.out.println(m+" "+n+" ");
        Integer fei1 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] s = in.nextLine().split(" ");
//            System.out.println(JSONObject.toJSONString(s));
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.valueOf(s[j]);
            }
        }
        direct = new int[]{0, 1, 0, -1, 0};
        dfs(0, 0, m, n);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int i, int j, int m, int n) {
        if (matrix[i][j] == 2) {
            return;
        }
        if (matrix[i][j] == 0) {
            matrix[i][j] = 1;
            for (int k = 0; k < 4; k++) {
                int x = i + direct[k];
                int y = j + direct[k + 1];
                if (0 <= x && x < m && 0 <= y && y < n) {
                    dfs(x, y, m, n);
                }
            }
        }
    }
}
