package com.mytest.ptbase.api.oBai;

import java.util.*;

//选修课,https://renjie.blog.csdn.net/article/details/130790082
//字符串处理，HashMap存储和排序，细节处理：学号去重
public class XuanXiuKe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            HashMap<String, Integer> map1 = new HashMap<>();
            HashMap<String, ArrayList<String[]>> map = new HashMap<>();
            String[] s1=in.nextLine().split(";");
            String[] s2=in.nextLine().split(";");
            for (int i = 0; i < s1.length; i++) {
                String[] s3=s1[i].split(",");
                map1.put(s3[0],Integer.valueOf(s3[1]));
            }
            for (int i = 0; i < s2.length; i++) {
                String[] s3=s2[i].split(",");
                if(map1.get(s3[0])!=null) {
                    int he=map1.get(s3[0]) + Integer.valueOf(s3[1]);
                    String[] sar= new String[]{s3[0].substring(s3[0].length()-3),String.valueOf(he)};//后三位学号，两科成绩和
                    String key=s3[0].substring(0,s3[0].length()-3);//前5位学号
                    ArrayList<String[]> list = map.getOrDefault(key,new ArrayList<String[]>());
                    list.add(sar);
                    map.put(key, list);
                }
            }
            if(map.isEmpty()){System.out.println("NULL");}
            else{
            for(Map.Entry<String, ArrayList<String[]>> entry:map.entrySet()){
                ArrayList<String[]> list=entry.getValue();
                Collections.sort(list, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        if(Integer.valueOf(o2[1])==Integer.valueOf(o1[1])){
                           return o1[0].compareTo(o2[0]);
                        }
                        return Integer.valueOf(o2[1])-Integer.valueOf(o1[1]);
                    }
                });
                map.put(entry.getKey(), list);

            }
            ArrayList<Map.Entry<String, ArrayList<String[]>>> list=new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, ArrayList<String[]>>>() {
                @Override
                public int compare(Map.Entry<String, ArrayList<String[]>> o1, Map.Entry<String, ArrayList<String[]>> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });
            for(Map.Entry<String, ArrayList<String[]>> entry:list) {
                System.out.println(entry.getKey());
                StringBuilder stb = new StringBuilder();
                for (int i=0;i<entry.getValue().size();i++) {
                    if(i==0||(i>0&&!entry.getValue().get(i)[0].equals(entry.getValue().get(i-1)[0]))) {//去重
                        stb.append(entry.getKey() + entry.getValue().get(i)[0] + " ");
                    }
                }
                System.out.println(stb.toString());
            }
            }
        }
    }
}
