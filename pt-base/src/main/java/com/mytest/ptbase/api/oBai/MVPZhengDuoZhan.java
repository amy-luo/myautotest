package com.mytest.ptbase.api.oBai;

import java.util.*;

//星际篮球争霸赛，MVP争夺战，https://renjie.blog.csdn.net/article/details/128259596
//等和子数组最小和,数组从大到小排序，分桶，小于等和，按大到小依次放置元素,递归回溯。
public class MVPZhengDuoZhan {
    public static Integer[] ar1;
    public static int sum;
    public static int he;
    public static int groupNum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = Integer.valueOf(s);
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ar1 = new Integer[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                ar1[i] = dataArray[i];
            }
            sum = Arrays.stream(dataArray).sum();
            Arrays.sort(ar1, ((o1, o2) -> o2 - o1));

            for (int i = m; i > 0; i--) {
                if (sum % i == 0) {
                    he = sum / i;
                    groupNum = i;
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < groupNum; j++) {
                        map.put(j, 0);
                    }
                    if (isCheckFen(map, 0)) {
                        System.out.println(he);
                        break;
                    }
                }
            }
        }
    }

    private static boolean isCheckFen(HashMap<Integer, Integer> map, int index) {
        if (index == ar1.length) {
            for (Integer o : map.values()) {
                if (o != he) {
                    return false;
                }
            }
            return true;
        } else {
            if (ar1[index] > he) {
                return false;
            }
            for (int i = 0; i < groupNum; i++) {
                if (map.getOrDefault(i, 0) + ar1[index] <= he) {
                    if (map.get(i) == 0 || (i > 0 && map.get(i) == map.get(i - 1))) {
                        map.put(i, map.getOrDefault(i, 0) + ar1[index]);
                        boolean res = isCheckFen(map, index + 1);
                        if (res) {
                            return true;
                        }
                        break;
                    } else {
                        map.put(i, map.getOrDefault(i, 0) + ar1[index]);
                        boolean res = isCheckFen(map, index + 1);
                        if (res) {
                            return true;
                        }
                        map.put(i, map.getOrDefault(i, 0) - ar1[index]);
                    }
                }
            }
        }
        if (index == ar1.length - 1) {
            for (Integer o : map.values()) {
                if (o != he) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
