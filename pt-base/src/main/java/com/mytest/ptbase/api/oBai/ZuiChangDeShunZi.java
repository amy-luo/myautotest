package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//最长的顺子，https://renjie.blog.csdn.net/article/details/128495802
//双指针，左指针是顺子起始，右指针是顺子结束
public class ZuiChangDeShunZi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s1 = in.nextLine().split("-");
            String[] s2 = in.nextLine().split("-");
            HashMap<String, Integer> map = new HashMap<>();
            String[] pai = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};//面向最长顺子来遍历
            for (String o : pai) {
                map.put(o, 4);
            }
            map = update(s1, map);
            map = update(s2, map);
            ArrayList<String> res = new ArrayList<>();//放最长最大的顺子
            ArrayList<String> tmp = new ArrayList<>();//放顺子
            for (int i = 0, j = 0; i <= 7 && j < pai.length; ) {//遍历顺子的起始位置
                if (map.get(pai[j]) > 0) {
                    tmp.add(pai[j]);
                    j++;
                }
                if(j==pai.length||map.get(pai[j])==0){
                    if (tmp.size() != 0) {
                        if (tmp.size() >= 5 && tmp.size() > res.size()) {
                            res.removeAll(res);
                            res.addAll(tmp);
                        }
                        if (tmp.size() >= 5 && tmp.size() == res.size()) {
                            if (tmp.get(0).compareTo(res.get(0)) > 0) {
                                res.removeAll(res);
                                res.addAll(tmp);
                            }
                        }
                    }
                    j++;
                    i=j;
                    tmp.removeAll(tmp);
                }
            }
            StringBuilder stb2 = new StringBuilder();
            for (String o : res) {
                stb2.append(o + "-");
            }
            if (res.size() == 0) {
                System.out.println("NO-CHAIN");
            } else {
                System.out.println(stb2.substring(0, stb2.length() - 1));
            }
        }
    }

    private static HashMap<String, Integer> update(String[] s, HashMap<String, Integer> map) {
        for (String o : s) {
            if (map.get(o) != null) {
                map.put(o, map.get(o) - 1);
            }
        }
        return map;
    }

}
