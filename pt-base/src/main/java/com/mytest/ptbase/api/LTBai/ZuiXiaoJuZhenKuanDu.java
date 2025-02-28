package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//最小矩阵宽度，https://hydro.ac/d/HWOD2023/p/OD421
//存放前i列的每种数字个数,前缀列各个数字个数，求列矩阵的最小宽度
public class ZuiXiaoJuZhenKuanDu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int m = Integer.valueOf(s[0]);
            int n = Integer.valueOf(s[1]);
            matrix = new int[m][n];
            //计算列矩阵前缀的各个数字的个数
            ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();//存放前j列的每种数字个数
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = dataArray[j];
                }
            }
            HashMap<Integer, Integer> map = new HashMap<>();//存放前i列的每种数字个数,前缀列各个数字个数
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map.put(matrix[j][i], map.getOrDefault(matrix[j][i], 0) + 1);
                }
                HashMap<Integer, Integer> map3 = new HashMap<>();
                map3.putAll(map);
                list.add(i, map3);
            }
            int k = Integer.valueOf(in.nextLine());
            int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HashMap<Integer, Integer> map2 = new HashMap<>();//存放数组中每种数字个数
            for (int i = 0; i < array.length; i++) {
                map2.put(array[i], map2.getOrDefault(array[i], 0) + 1);
            }
            //滑动窗口
            int minKuan = Integer.MAX_VALUE;
            for (int i = 0, j = 0; j < n; ) {
                if (i == 0) {
                    boolean flag = true;
                    for (int o : map2.keySet()) {
                        int tmp=list.get(j).get(o)==null?0:list.get(j).get(o);
                        if (map2.get(o) > tmp) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        minKuan = Math.min(minKuan, j+1);
                        if (i == j) {
                            i++;
                            j++;
                        } else {
                            i++;
                        }
                    }else{
                        j++;
                    }
                } else {//i>0
                    boolean flag = true;
                    for (int o : map2.keySet()) {
                        int tmp=list.get(j).get(o)==null?0:
                                list.get(i-1).get(o)==null?list.get(j).get(o):
                                        list.get(j).get(o)-list.get(i-1).get(o);
                        if (map2.get(o) > tmp) {//和i=0大体相同，就这句不同，要减去前缀元素个数
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        minKuan = Math.min(minKuan, j-i+1);//和i=0大体相同，就这句不同，算子矩阵宽度
                        if (i == j) {
                            i++;
                            j++;
                        } else {
                            i++;
                        }
                    }else{
                        j++;
                    }
                }
            }
            System.out.println(minKuan);
        }
    }
}
