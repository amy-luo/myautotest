package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//数字涂色,https://renjie.blog.csdn.net/article/details/128076215
//排序后，取余
public class ShuZiTuSe {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = Integer.valueOf(s);
//            int n = Integer.valueOf(s[1]);
            int[] data = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> list = new ArrayList<>();
            Arrays.sort(data);
            list.add(data[0]);
            for (int i = 1; i < m; i++) {
                boolean flag = false;
                for (Integer o : list) {
                    if (data[i] % o == 0) {
                        flag=true;
                        break;
                    }
                }
                if (!flag) {
                    list.add(data[i]);
                }
            }
            System.out.println(list.size());
        }

    }
}

