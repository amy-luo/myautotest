package com.mytest.ptbase.api.oBai;

import java.util.*;

//字符统计及重排,https://renjie.blog.csdn.net/article/details/143824758
//自定义排序，HashMap的自定排序。个数相等时大写字母和小写字母要特殊处理。大写字母要比小写字母小默认排序是前面，所以要在自定义中改一下。
public class ZiFuTongJiYuChongPai {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            char[] zifu = in.nextLine().toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < zifu.length; i++) {
                map.put(zifu[i], map.getOrDefault(zifu[i], 0) + 1);
            }
            List<Map.Entry<Character,Integer>> list = new ArrayList<>();
            list.addAll(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>() {
                @Override
                public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2) {
                    if(o1.getValue()==o2.getValue()){
                        if(Character.isLowerCase(o1.getKey())&&Character.isLowerCase(o2.getKey())) {
                            return o1.getKey() - o2.getKey();
                        }
                        if(Character.isUpperCase(o1.getKey())&&Character.isUpperCase(o2.getKey())) {
                            return o1.getKey() - o2.getKey();
                        }
                        if(Character.isUpperCase(o1.getKey())&&Character.isLowerCase(o2.getKey())) {
                            return o2.getKey() - o1.getKey();
                        }
                        if(Character.isLowerCase(o1.getKey())&&Character.isUpperCase(o2.getKey())) {
                            return o2.getKey() - o1.getKey();
                        }
                    }
                        return o2.getValue()-o1.getValue();
                }
            });
            StringBuilder stb = new StringBuilder();
            for(Map.Entry<Character,Integer> entry:list){
                stb.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
            }
            System.out.println(stb.toString());
        }
    }

}
