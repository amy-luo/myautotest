package com.mytest.ptbase.api.oBai;

import java.util.*;

//智能成绩表,https://renjie.blog.csdn.net/article/details/134760663
//Comparator，自定义排序
public class ZhiNengChengJiBiao {
    public static HashMap<String, ArrayList<Integer>> map;
    public static boolean[][] isVisited;
    public static int m;
    public static int n;
    public static int index;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(" ");
            m = Integer.valueOf(s[0]);
            n = Integer.valueOf(s[1]);
            map=new HashMap<String, ArrayList<Integer>>();
            String[] kemuAll=in.nextLine().split(" ");
            for (int i = 0; i < m; i++) {
                String[] dataArray = in.nextLine().split(" ");
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 1; j <=n; j++) {
                    list.add(Integer.valueOf(dataArray[j]));
                }
                map.put(dataArray[0], list);
            }
            String kemu=in.nextLine();
            index =-1;
            for(int i=0;i<kemuAll.length;i++){
                if(kemuAll[i].equals(kemu)){
                    index=i;
                    break;
                }
            }
            Set<Map.Entry<String, ArrayList<Integer>>> set=map.entrySet();
            ArrayList<Map.Entry<String, ArrayList<Integer>>> list = new ArrayList<>(set);
            //根据index的科目，从大到小
            Comparator comparator1=new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
                @Override
                public int compare(Map.Entry<String, ArrayList<Integer>> o1, Map.Entry<String, ArrayList<Integer>> o2) {
                    return o2.getValue().get(index) -o1.getValue().get(index);
                }
            };
            //求和，从大到小
            Comparator comparator2=new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
                @Override
                public int compare(Map.Entry<String, ArrayList<Integer>> o1, Map.Entry<String, ArrayList<Integer>> o2) {
                    return (o2.getValue().stream().mapToInt(Integer::intValue).sum()) -o1.getValue().stream().mapToInt(Integer::intValue).sum();
                }
            };

            if(index!=-1){
                Collections.sort(list, comparator1);
            }else{
                Collections.sort(list, comparator2);

            }
            for(Map.Entry<String, ArrayList<Integer>> o:list){
                System.out.print(o.getKey()+" ");
            }
        }
    }

}
