package com.mytest.ptbase.api.LTBai;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//跳房子II,https://renjie.blog.csdn.net/article/details/131023717
//排序（需存储排序后的索引）+双指针，求三数之和。
public class TiaoFangZi2 {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            int[] input = Arrays.stream(s.substring(1, s.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
            int m = Integer.valueOf(in.nextLine());
            int[][] array = new int[input.length][2];
            for (int i = 0; i < input.length; i++) {
                array[i][0] = i;
                array[i][1] = input[i];
            }
            Arrays.sort(array, (o1, o2) -> o1[1] - o2[1]);
            int minSuoyinhe = Integer.MAX_VALUE;
            ArrayList<int[]> res = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                for (int L = i + 1, R = array.length - 1; L < R; ) {
                    if (array[i][1] > m) {
                        break;
                    }
                    int tmp = array[i][1] + array[L][1] + array[R][1];
                    if (tmp < m) {
                        L++;
                    }
                    if (tmp > m) {
                        R--;
                    }
                    if (tmp == m) {
                        if (minSuoyinhe > array[i][0] + array[L][0] + array[R][0]) {
                            minSuoyinhe = array[i][0] + array[L][0] + array[R][0];
                            res.removeAll(res);
                            res.add(array[i]);
                            res.add(array[L]);
                            res.add(array[R]);
                        }
                        R--;
                    }
                }
            }
            Collections.sort(res, (o1, o2) -> o1[0] - o2[0]);
            ArrayList<Integer> res2 = new ArrayList<>();
            for (int[] o : res) {
                res2.add(o[1]);
            }
            System.out.println(JSONObject.toJSONString(res2));
        }
    }

}
