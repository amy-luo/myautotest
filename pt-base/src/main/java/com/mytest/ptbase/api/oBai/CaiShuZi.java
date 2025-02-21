package com.mytest.ptbase.api.oBai;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//自由练习
public class CaiShuZi {
    public static String[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            int m = Integer.valueOf(s);
            ArrayList<ArrayList<HashSet<Character>>> list = new ArrayList<>();
            matrix = new String[m][2];
            for (int i = 0; i < m; i++) {
                String[] dataArray = in.nextLine().split(" ");
                matrix[i] = dataArray;
            }

            for(int wei=0;wei<4;wei++) {
                HashSet<Character> keneng = new HashSet<>();
                HashSet<Character> buke = new HashSet<>();
                for (int i = 0; i < m; i++) {
                    if (matrix[i][1].charAt(0) == '0') {
                        buke.add(matrix[i][0].charAt(wei));
                    }
                    if (matrix[i][1].charAt(0) == '0'&&matrix[i][1].charAt(2) == '0') {
                        for (int k = 0; k < 4; k++) {
                              buke.add(matrix[i][0].charAt(k));
                        }
                    }
                    if (matrix[i][1].charAt(0) == '0'&&matrix[i][1].charAt(2) != '0') {
                        for (int k = 0; k < 4; k++) {
                            if(wei!=k) {
                                keneng.add(matrix[i][0].charAt(k));
                            }
                        }
                    }
                    if (matrix[i][1].charAt(0) != '0'&&matrix[i][1].charAt(2) == '0') {
                        for (int k = 0; k < 4; k++) {
                            if(wei==k) {
                                keneng.add(matrix[i][0].charAt(k));
                            }
                        }
                    }
                    if (matrix[i][1].charAt(0) != '0'&&matrix[i][1].charAt(2) != '0') {
                        for (int k = 0; k < 4; k++) {
                            keneng.add(matrix[i][0].charAt(k));
                        }
                    }
                }
                keneng.removeAll(buke);
                ArrayList<HashSet<Character>> list2 = new ArrayList<>();
                list2.add(keneng);
                list2.add(buke);
                list.add(list2);
                System.out.println(JSONObject.toJSONString(list2));
            }
            System.out.println(JSONObject.toJSONString(list));
        }
    }
}
