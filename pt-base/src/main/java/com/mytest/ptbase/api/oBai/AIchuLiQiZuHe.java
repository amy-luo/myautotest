package com.mytest.ptbase.api.oBai;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//AI处理器组合,https://renjie.blog.csdn.net/article/details/128199445
//根据优先级选择可以处理的链路，递归回溯该链路找到所有可能的组合
public class AIchuLiQiZuHe {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] s = Arrays.stream(in.nextLine().split("[\\[\\],\\s]"))
                    .filter(o -> !o.equals(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int m = Integer.valueOf(in.nextLine());
            ArrayList<Integer> lianlu1 = new ArrayList<>();
            ArrayList<Integer> lianlu2 = new ArrayList<>();
            ArrayList<Integer> digui = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                if (s[i] < 4) {
                    lianlu1.add(s[i]);
                } else {
                    lianlu2.add(s[i]);
                }
            }
            int length1 = lianlu1.size();
            int length2 = lianlu2.size();
            String youxianji = "1324";
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            if (m == 1 || m == 2 || m == 4 || m == 8) {
                if (length1 >= m && length2 < m) {
                    digui.addAll(lianlu1);
                    dfsFind(digui, 0, m, new ArrayList<Integer>(), res);
                }
                if (length1 < m && length2 >= m) {
                    digui.addAll(lianlu2);
                    dfsFind(digui, 0, m, new ArrayList<Integer>(), res);
                }
//            if (length1 < m && length2 < m) {
//                //为空
//            }
                if (length1 >= m && length2 >= m) {
                    switch (m) {
                        case 1:
                            youxianji = "1324";
                            int youxianji1=youxianji.indexOf(String.valueOf(length1));
                            int youxianji2=youxianji.indexOf(String.valueOf(length2));
                            if (youxianji1 < youxianji2) {
                                digui.addAll(lianlu1);
                            } else if (youxianji1> youxianji2) {
                                digui.addAll(lianlu2);
                            } else if (youxianji1 == youxianji2) {
                                digui.addAll(lianlu1);
                                digui.addAll(lianlu2);
                            }
                            dfsFind(digui, 0, m, new ArrayList<Integer>(), res);
                            break;
                        case 2:
                            youxianji = "243";
                            int youxian1=youxianji.indexOf(String.valueOf(length1));
                            int youxian2=youxianji.indexOf(String.valueOf(length2));
                            if (youxian1 < youxian2) {
                                digui.addAll(lianlu1);
                            } else if (youxian1 > youxian2) {
                                digui.addAll(lianlu2);
                            } else if (youxian1 == youxian2) {
                                digui.addAll(lianlu1);
                                digui.addAll(lianlu2);
                            }
                            dfsFind(digui, 0, m, new ArrayList<Integer>(), res);
                            break;
                        case 4:
                            dfsFind(lianlu1, 0, m, new ArrayList<Integer>(), res);
                            dfsFind(lianlu2, 0, m, new ArrayList<Integer>(), res);
                            break;
                    }
                }
                if(m==8&&length1+length2==8){
                    digui.addAll(lianlu1);
                    digui.addAll(lianlu2);
                    dfsFind(digui, 0, m, new ArrayList<Integer>(), res);
                }
            }
            System.out.println(JSONObject.toJSONString(res));
        }
    }

    private static void dfsFind(ArrayList<Integer> digui, int index, int m, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res) {
        if (tmp.size() == m) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        } else {
            for (int i = index; i < digui.size(); i++) {
                tmp.add(digui.get(i));
                dfsFind(digui, i + 1, m, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }

    }

}
