package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//自由练习
public class DanCiJieLong {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            Comparator<String> comparator=new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length()==o2.length()){o1.compareTo(o2)}
                    return o1.length()-o2.length();
                }
            };
            int start =Integer.valueOf(in.nextLine());
            int m =Integer.valueOf(in.nextLine());
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(in.nextLine());
            }


        }
    }

}
