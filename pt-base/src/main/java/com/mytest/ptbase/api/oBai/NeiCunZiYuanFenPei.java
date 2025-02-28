package com.mytest.ptbase.api.oBai;

import java.util.*;

//内存资源分配,https://renjie.blog.csdn.net/article/details/130897414
//hashmap排序
public class NeiCunZiYuanFenPei {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            //String s=in.nextLine();
//            int m = Integer.valueOf(s[0]);
//            int n = Integer.valueOf(s[1]);
            HashMap<Integer, Integer> map = new HashMap<>();
            String[] firstHang = in.nextLine().split(",");
            for (int i = 0; i < firstHang.length; i++) {
                int[] tmp=Arrays.stream(firstHang[i].split(":")).mapToInt(Integer::parseInt).toArray();
                map.put(tmp[0], tmp[1]);
            }
            ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getKey()-o2.getKey();
                }
            });
            int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Boolean> res=new ArrayList<>();
            for (int i = 0; i < dataArray.length; i++) {
                boolean flag=false;
                for(Map.Entry<Integer, Integer> entry:list){
                    if(entry.getKey()>=dataArray[i]&&entry.getValue()>0){
                        flag=true;
                        map.put(entry.getKey(), entry.getValue() - 1);
                        break;
                    }
                }
                res.add(flag);
            }
            StringBuilder stb = new StringBuilder();
            for(Boolean o:res){
                stb.append(o + ",");
            }
            System.out.println(stb.substring(0,stb.length()-1));
        }
    }

}
