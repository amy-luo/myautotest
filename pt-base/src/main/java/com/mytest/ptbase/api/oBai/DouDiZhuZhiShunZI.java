package com.mytest.ptbase.api.oBai;

import java.util.*;

//斗地主之顺子,https://renjie.blog.csdn.net/article/details/130894638
//hashmap记录特殊值，数组自定义排序，过程逻辑模拟
public class DouDiZhuZhiShunZI {
    public static int[][] matrix;
    public static HashMap<String,Integer> map;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            map = new HashMap<>();
            map.put("3", 3);
            map.put("4", 4);
            map.put("5", 5);
            map.put("6", 6);
            map.put("7", 7);
            map.put("8", 8);
            map.put("9", 9);
            map.put("10", 10);
            map.put("J", 11);
            map.put("Q", 12);
            map.put("K", 13);
            map.put("A", 14);
            map.put("2", 16);
            String[] dataArray =in.nextLine().split(" ");
            Arrays.sort(dataArray, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return map.get(o1)-map.get(o2);
                }
            });
            int count=1;
            StringBuilder stb = new StringBuilder();
            ArrayList<String> res = new ArrayList<>();
            stb.append(dataArray[0]+" ");
            boolean flag=false;
            for (int i = 1; i < dataArray.length; i++) {
                if(map.get(dataArray[i])!=map.get(dataArray[i-1])+1){
                    if(count>=5){
                        res.add(stb.toString());
                        flag = true;
                    }
                    count=1;
                    stb.setLength(0);
                    stb.append(dataArray[i]+" ");
                    continue;
                }else{
                    count++;
                    stb.append(dataArray[i]+" ");
                }
            }
            if(flag) {
                for (String o : res) {
                    System.out.println(o);
                }
            }else{System.out.println("No");}
        }
    }
}
