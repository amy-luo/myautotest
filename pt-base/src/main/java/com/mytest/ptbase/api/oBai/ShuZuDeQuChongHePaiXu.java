package com.mytest.ptbase.api.oBai;

import java.util.*;
import java.util.stream.Collectors;

//数组去重和排序,https://renjie.blog.csdn.net/article/details/128153651
// 注意使用LinkedHashMap，这样可以保留数字出现的顺序
public class ShuZuDeQuChongHePaiXu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            //转为数组
            List<Integer> nums = Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 注意使用LinkedHashMap，这样可以保留数字出现的顺序
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < nums.size(); i++) {
                map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            }

            LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
            list.sort((a, b) -> b.getValue() - a.getValue());
            for (int i = 0; i < list.size(); i++) {
                Map.Entry<Integer, Integer> entry = list.get(i);
                if (i != list.size() - 1) {
                    System.out.print(entry.getKey() + ",");
                } else {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
