package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//寻找链表的中间结点,https://hydro.ac/d/HWOD2023/p/OD002
//HashMap存储关系，LinkedList模拟过程
public class XunZhaoLianBiaoDeZhongJianJieDian {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            String firstJie = s[0];
            int n = Integer.valueOf(s[1]);
            HashMap<String, String[]> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] s1 = in.nextLine().split(" ");
                map.put(s1[0], s1);
            }
            LinkedList<String> deque = new LinkedList<>();
            while (deque.size() < n) {
                deque.addLast(map.get(firstJie)[1]);
                firstJie = map.get(firstJie)[2];
            }
            System.out.println(deque.get(n / 2));
        }
    }
}
