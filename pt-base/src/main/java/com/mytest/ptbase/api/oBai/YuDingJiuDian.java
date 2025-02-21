package com.mytest.ptbase.api.oBai;

import java.util.*;

//预订酒店,https://renjie.blog.csdn.net/article/details/128376506
//排序，两次排序，价格差值从小到大排序，价格差值相等时，价格从小到大排序.取前5个元素放入list2.再将list2从小到达排序输出。
public class YuDingJiuDian {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(" ");
            int n = Integer.valueOf(s[0]);
            int k = Integer.valueOf(s[1]);
            int x = Integer.valueOf(s[2]);
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer[]> list = new ArrayList<>();
            for (int i = 0; i < dataArray.length; i++) {
                list.add(new Integer[]{Math.abs(dataArray[i]-x),dataArray[i]});
            }
            Collections.sort(list, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    if(o1[0]==o2[0]){
                        return o1[1] - o2[1];
                    }
                    return o1[0]-o2[0];
                }
            });
            ArrayList<Integer> list2 = new ArrayList<>();

            for(int i=0;i<k;i++){
                list2.add(list.get(i)[1]);
            }
            Collections.sort(list2);

            StringBuilder stb = new StringBuilder();
            for(int i=0;i<k;i++){
                stb.append(list2.get(i)+ " ");
            }
            System.out.println(stb.toString());
        }
    }
}
