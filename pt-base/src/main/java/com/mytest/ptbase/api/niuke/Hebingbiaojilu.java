package com.mytest.ptbase.api.niuke;
import java.util.*;

//合并表记录，hashMap，排序，ArrayList
public class Hebingbiaojilu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum=Integer.parseInt(in.nextLine());
        HashMap<Integer,Integer> map=new HashMap<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] a = in.nextLine().split(" ");
            int key=Integer.parseInt(a[0]);
            int value=Integer.parseInt(a[1]);
            if(map.keySet().contains(key)){
                int newValue=map.get(key)+value;
                map.put(key,newValue);
            }else{map.put(key,value);}
        }
        ArrayList<Integer> list=new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(Integer o:list) {
            System.out.println(o+" " + map.get(o));
        }
    }
}
