package com.mytest.ptbase.api.oBai;

import javax.swing.text.html.parser.Entity;
import java.util.*;

//热点网站统计,https://renjie.blog.csdn.net/article/details/128076046
//HashMap排序
public class ReDianWangZhanTongJi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.indexOf(".") != -1) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            } else {
                ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (o1.getValue() == o2.getValue()) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getValue() - o1.getValue();
                    }
                });
                for (int i = 0; i < Integer.valueOf(s); i++) {
                    System.out.print(list.get(i).getKey() + " ");
                }
            }
        }
    }

}
