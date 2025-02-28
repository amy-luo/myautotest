package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//特殊加密算法，https://renjie.blog.csdn.net/article/details/135307154
//dfs
public class JiaMiSuanFa {
    public static int[][] matrix;
    public static int[] nums;
    public static int[][] direct;
    public static boolean[][] isVisited;

    public static ArrayList<String> result;
    public static int m;
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            n = in.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            m = in.nextInt();
            matrix = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            direct = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            boolean flag = false;
            result = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    StringBuilder stb=new StringBuilder();
                    if (matrix[i][j] == nums[0]) {
                        stb.append(i + " " + j + " ");
                        isFind(i, j, 1, stb);
                    }
                }
            }
            Collections.sort(result);
            if (result.isEmpty()) {
                System.out.println("error");
            } else {
                System.out.println(result.get(0));
            }

        }
    }

    private static void isFind(int i, int j, int count, StringBuilder stb) {
        if (count == n) {
            result.add(stb.toString());
        } else {
            for (int k = 0; k < 4; k++) {
                int x = i + direct[k][0];
                int y = j + direct[k][1];
                if (0 <= x && x < m && 0 <= y && y < m && matrix[x][y] == nums[count]) {
                    String s=x + " " + y + " ";
                    stb.append(s);
                    System.out.println(matrix[x][y] + " " + nums[count]);
                    System.out.println("找到了，x，y： " + x + " " + y);
                    isFind(x, y, count + 1, stb);
                    stb.delete(stb.length() - s.length(), stb.length());
                }
            }
        }
    }
}


//import java.util.Scanner;
//import java.util.*;
//import java.util.stream.Stream;
//import java.util.HashMap;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//public class Main {
//    public static int[][] directions = {{-1, 0},{0,-1} ,{0,1},{1,0}};
//    public static String result;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//
//        int m = in.nextInt();
//        int[][] matrix = new int[m][m];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = in.nextInt();
//            }
//        }
//
//        int flag = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                result = "";
//                if (matrix[i][j] == nums[0] && dfs(i, j, 0,n,m,nums,matrix)) {
//                	flag = 1;
//                    break;
//                }
//            }
//            if(flag == 1){
//                break;
//            }
//        }
//
//        if(flag == 1){
//            System.out.println(result.substring(0, result.length()-1));
//            return;
//        } else {
//            System.out.println("error");
//        }
//    }
//
//    public static int[] split(String input_str,String chars){
//        String[] tmp2 = input_str.split(chars);
//        int[] results = new int[tmp2.length];
//        for (int i = 0; i < tmp2.length; i++) {
//            results[i] = Integer.parseInt(tmp2[i]);
//        }
//        return results;
//    }
//
//    public static boolean dfs(int x, int y, int index,int n,int m,int[] nums,int[][] matrix) {
//        result += x +" "+ y + " ";
//        if (index == n - 1) {
//            return true;
//        }
//        int record = matrix[x][y];
//        matrix[x][y] = Integer.MAX_VALUE;
//        int i=0;
//        while(true){
//            if(i>=4){
//                break;
//            } else {
//                int new_x = x + directions[i][0];
//                int new_y = y + directions[i][1];
//                if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= m
//                    || matrix[new_x][new_y] != nums[index + 1]) {
//                        i+=1;
//                    continue;
//                }
//                if (dfs(new_x, new_y, index + 1,n,m,nums,matrix)) {
//                    return true;
//                }
//            }
//            i+=1;
//        }
//        matrix[x][y] = record;
//        result = result.substring(0, result.length()-4);
//        return false;
//    }
//}
