package com.mytest.ptbase.api.oBai;

import java.util.*;

//最小数字,https://renjie.blog.csdn.net/article/details/128153738
//数组自定义排序。数字拼接后字符串字典序排序
public class ShuZuZuChengDeZuiXiaoShuZi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(dataArray);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if(dataArray.length>i) {
                    list.add(dataArray[i]);
                }
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1=o1+""+o2;
                    String s2=o2+""+o1;
                    return s1.compareTo(s2);
                }
            });
            StringBuilder stb = new StringBuilder();
            for(Integer o:list){
                stb.append(o);
            }
            System.out.println(Integer.valueOf(stb.toString()));
        }
    }
}
