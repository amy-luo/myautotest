package com.mytest.ptbase.api.oBai;

import java.util.*;

//免单统计,https://renjie.blog.csdn.net/article/details/130851007
//只需统计每秒内的最早时间，key是.的左侧，value是右侧。key相同，value最小时的个数就是当前秒的获奖个数。再把所有每秒内获奖个数相加。
public class MianDanTongJi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int n = Integer.valueOf(in.nextLine());
            HashMap<String, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] s = in.nextLine().split("\\.");
                ArrayList<Integer> list = map.getOrDefault(s[0], new ArrayList<>());
                list.add(Integer.valueOf(s[1]));
                map.put(s[0], list);
            }

            int count = 0;
            for (Map.Entry<String, ArrayList<Integer>> o : map.entrySet()) {
                ArrayList<Integer> list = o.getValue();
                int zuizao = Integer.MAX_VALUE;
                int num = 0;
                for (Integer miao : list) {
                    if (miao < zuizao) {
                        zuizao = miao;
                        num = 1;
                    } else if (miao == zuizao) {
                        num++;
                    }
                }
                count += num;
            }
            System.out.println(count);
        }
    }
}
