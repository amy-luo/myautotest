package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//HashMap，HashSet，ArrayList
public class LiuLangDiQiu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s= in.nextLine();
        int N= Integer.valueOf(s.split(" ")[0]);
        int E= Integer.valueOf(s.split(" ")[1]);
//        System.out.println("N: "+N+" E: "+N);
        HashMap<Integer,Boolean> isOpen=new HashMap<>();//记录已启动的发动机位置P和状态
        //待启动
        HashSet<Integer> pp=new HashSet<>();//记录当前时刻启动的发动机位置P
        HashMap<Integer,ArrayList<Integer>> tp=new HashMap<>();//存储手动启动时刻和发动机编号
        int count=0;
        while (count<E&&in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
//            System.out.println("a: "+a);
//            if(a.isEmpty()){break;}
            int T = Integer.valueOf(a.split(" ")[0]);//启动时刻
            int P = Integer.valueOf(a.split(" ")[1]);//每次启动的编号
            ArrayList<Integer> list=tp.getOrDefault(T,new ArrayList<Integer>());
            list.add(P);
            tp.put(T,list);
            count++;
        }
        int t=0;
        while(isOpen.size()<N){
            HashSet<Integer> pp2=new HashSet<>();
            if(tp.get(t)!=null) {
                for (Integer p : tp.get(t)) {
                    if (isOpen.get(p) == null) {
                        isOpen.put(p, true);
                        pp2.add(p);
                    }
                }
            }
            if(!pp.isEmpty()){
                for(Integer o:pp){
                    if(o+1<=N-1){
                        int p1=o+1;
                        if(isOpen.get(p1)==null) {
                          isOpen.put(p1,true);
                          pp2.add(p1);}
                    }
                    if(o-1>=0){
                        int p1=o-1;
                        if(isOpen.get(p1)==null) {
                            isOpen.put(p1,true);
                            pp2.add(p1);}}
                }
            }
            pp.removeAll(pp);
            pp.addAll(pp2);
            t++;
        }
        System.out.println(pp.size());
        System.out.println(JSONObject.toJSONString(pp));
    }
}
