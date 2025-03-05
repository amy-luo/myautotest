package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//字符串解密,https://renjie.blog.csdn.net/article/details/128455555
//正则匹配，去重后的个数排序，字典序排序。
public class ZiFuChuanJieMi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] validInput = in.nextLine().split("[0-9a-f]+");
            int count = quchong_length(in.nextLine());
            String[] resArr =Arrays.stream(validInput).filter(o->!o.equals("")&&quchong_length(o)<=count).toArray(String[]::new);
            Arrays.sort(resArr, (o1, o2) -> {
                if(quchong_length(o1) == quchong_length(o2)){
                    o2.compareTo(o1);
                }
                return quchong_length(o2) - quchong_length(o1);
            });

            System.out.println(resArr.length == 0 ? "Not Found" : resArr[0]);
        }

    }
    // 字符串去重后个数
    public static int quchong_length (String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
