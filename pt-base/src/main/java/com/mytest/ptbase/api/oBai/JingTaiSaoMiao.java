package com.mytest.ptbase.api.oBai;

import java.util.*;

//缓存需要最少金币数 /静态扫描,https://renjie.blog.csdn.net/article/details/128502753
//HashMap,比较扫描1次+缓存，扫描n次，这两钟方式，取花钱少的方式
public class JingTaiSaoMiao {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());
            int[] dataArray1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] dataArray2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < dataArray1.length; i++) {
                ArrayList<Integer> list = map.getOrDefault(dataArray1[i], new ArrayList<>());
                list.add(dataArray2[i]);
                map.put(dataArray1[i], list);
            }
            int count = 0;
            for (Map.Entry<Integer, ArrayList<Integer>> o : map.entrySet()) {
                int x = o.getValue().stream().mapToInt(Integer::intValue).sum();//扫描求和
                int y = o.getValue().get(0) + m;//扫描1一次+缓存
                count += Math.min(x, y);
            }
            System.out.println(count);
        }
    }
}

