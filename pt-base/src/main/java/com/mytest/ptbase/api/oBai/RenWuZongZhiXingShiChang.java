package com.mytest.ptbase.api.oBai;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//任务总执行时长,https://renjie.blog.csdn.net/article/details/128441821
//一层for循环遍历,TreeSet可以去重对元素排序。TreeMap是对key排序
public class RenWuZongZhiXingShiChang {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(",");
            int a = Integer.valueOf(s[0]);
            int b = Integer.valueOf(s[1]);
            int m = Integer.valueOf(s[2]);
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i <= m; i++) {
                int sum = i * a + (m - i) * b;
                set.add(sum);
            }
            System.out.println(JSONObject.toJSONString(set));
        }
    }
}
