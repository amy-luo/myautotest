package com.mytest.ptbase.api.oBai;

import java.util.*;

//优秀学员统计,https://renjie.blog.csdn.net/article/details/128500348
//自定义排序，hashMap统计，key为id，次数、最早打卡时间
public class YouXiuXueYuanTongJi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int N = Integer.valueOf(in.nextLine());
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HashMap<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < dataArray.length; i++) {
                if(dataArray[i]==1){
                    int id = Integer.valueOf(in.nextLine());
                    if(map.get(id)!=null){
                        int[] x = map.get(id);
                        x[0]++;
                        map.put(id, x);
                    }else {
                        int[] x = new int[2];
                        x[0]++;
                        x[1]=i;//第一次打卡是第几天
                        map.put(id, x);
                    }
                }else {
                    int[] daka = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    for(Integer id:daka){
                        if(map.get(id)!=null){
                            int[] x = map.get(id);
                            x[0]++;
                            map.put(id, x);
                        }else {
                            int[] x = new int[2];
                            x[0]++;
                            x[1]=i;//第一次打卡是第几天
                            map.put(id, x);
                        }
                    }
                }
            }
            List<Map.Entry<Integer, int[]>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, int[]>>() {
                @Override
                public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                    if(o2.getValue()[0]==o1.getValue()[0]){
                        if(o1.getValue()[1]==o2.getValue()[1]){
                            return o1.getKey() - o2.getKey();
                        }
                        return o1.getValue()[1]-o2.getValue()[1];
                    }
                    return o2.getValue()[0]-o1.getValue()[0];
                }
            });
            StringBuilder stb = new StringBuilder();
            for(int i=0;i<5;i++){
                if(list.size()>i){
                    stb.append(list.get(i).getKey() + " ");
                }
            }
            System.out.println(stb.toString());
        }
    }

}
