package com.mytest.ptbase.api.oBai;

import java.util.*;

//运维日志排序,https://renjie.blog.csdn.net/article/details/128131684
//换算时间，排序
public class YunWeiRiZhiPaiXu {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int m=Integer.valueOf(in.nextLine());
            ArrayList<String[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String s = in.nextLine();
                String[] dataArray = s.split(":");
                    double sum=60*60*Double.valueOf(dataArray[0])+60*Double.valueOf(dataArray[1])+Double.valueOf(dataArray[2]);
                list.add(new String[]{s, String.valueOf(sum)});
            }
            Collections.sort(list, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return (int)(Double.valueOf(o1[1])-Double.valueOf(o2[1]));
                }
            });
            for(String[] o:list){
                System.out.println(o[0]);
            }
        }
    }

}
