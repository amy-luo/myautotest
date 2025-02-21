package com.mytest.ptbase.api.oBai;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//找等值元素,https://renjie.blog.csdn.net/article/details/128442197
//将元素左边存储到hashMap中，查找比较快，hashMap的key是二维数组元素值。
public class ZhaoDengZhiYuanSu {
    public static int[][] matrix;
    public static int[][] res;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            int m = Integer.valueOf(s1);
            int n = Integer.valueOf(s2);
            isVisited = new boolean[m][n];
            matrix = new int[m][n];
            res = new int[m][n];
            HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = dataArray[j];
                    ArrayList<int[]> list = map.getOrDefault(dataArray[j], new ArrayList<>());
                    list.add(new int[]{i, j});
                    map.put(dataArray[j], list);
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ArrayList<int[]> list = map.get(matrix[i][j]);
                    int minHe = Integer.MAX_VALUE;
                    boolean flag = false;
                    for (int[] o : list) {
                        if (o[0] == i && o[1] == j) {
                            continue;
                        } else {
                            if (Math.abs(o[0] - i) + Math.abs(o[1] - j) < minHe) {
                                minHe = Math.abs(o[0] - i) + Math.abs(o[1] - j);
                                res[i][j] = minHe;
                                flag = true;
                            }
                        }
                    }
                    if(!flag){res[i][j]=-1;}
                }
            }
            System.out.println(JSONObject.toJSONString(res));
        }
    }
}

