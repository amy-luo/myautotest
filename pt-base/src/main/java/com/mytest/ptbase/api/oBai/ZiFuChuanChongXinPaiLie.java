package com.mytest.ptbase.api.oBai;

import java.util.*;

//字符串重新排列,https://renjie.blog.csdn.net/article/details/127951051
//排序，两次排序，HashMap统计次数排序
public class ZiFuChuanChongXinPaiLie {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(" ");
            HashMap<String, Integer> map = new HashMap<>();
            for(String o:s){
                char[] ch = o.toCharArray();
                Arrays.sort(ch);
                String str=new String(ch);
                map.put(str,map.getOrDefault(str,0)+1);
            }
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if(o2.getValue()==o1.getValue()){
                        if(o1.getKey().length()==o2.getKey().length()){
                            for(int i=0;i<o1.getKey().length();i++){
                                return o1.getKey().compareTo(o2.getKey());
                            }
                        }
                        return o1.getKey().length()-o2.getKey().length();
                    }
                    return o2.getValue()-o1.getValue();
                }
            });
            for(Map.Entry<String, Integer> entry:list) {
                for(int i=0;i<entry.getValue();i++) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        }
    }
}
