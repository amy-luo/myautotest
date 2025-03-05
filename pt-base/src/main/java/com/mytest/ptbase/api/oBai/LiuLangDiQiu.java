package com.mytest.ptbase.api.oBai;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//HashMap，HashSet，ArrayList,
//流浪地球,https://renjie.blog.csdn.net/article/details/141635388
public class LiuLangDiQiu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String s = in.nextLine();
            int N = Integer.valueOf(s.split(" ")[0]);
            int E = Integer.valueOf(s.split(" ")[1]);
//        System.out.println("N: "+N+" E: "+N);
            HashMap<Integer, Boolean> isOpen = new HashMap<>();//记录已启动的发动机位置P和状态
            //待启动
            HashSet<Integer> pp = new HashSet<>();//记录当前时刻启动的发动机位置P
            HashMap<Integer, ArrayList<Integer>> tp = new HashMap<>();//存储手动启动时刻和发动机编号
            int count = 0;
            while (count < E && in.hasNextLine()) { // 注意 while 处理多个 case
                String a = in.nextLine();
//            System.out.println("a: "+a);
//            if(a.isEmpty()){break;}
                int T = Integer.valueOf(a.split(" ")[0]);//启动时刻
                int P = Integer.valueOf(a.split(" ")[1]);//每次启动的编号
                ArrayList<Integer> list = tp.getOrDefault(T, new ArrayList<Integer>());
                list.add(P);
                tp.put(T, list);
                count++;
            }
            int t = 0;
            while (isOpen.size() < N) {
                HashSet<Integer> pp2 = new HashSet<>();//存放当前启动的发动机编号，包括手动启动和自动启动
                if (tp.get(t) != null) {//手动启动
                    for (Integer p : tp.get(t)) {
                        if (isOpen.get(p) == null) {
                            isOpen.put(p, true);
                            pp2.add(p);
                        }
                    }
                }
                if (!pp.isEmpty()) {//自动启动
                    for (Integer o : pp) {
                        int p1 = o + 1 <= N - 1 ? o + 1 : (o + 1) % N;
                        if (isOpen.get(p1) == null) {
                            isOpen.put(p1, true);
                            pp2.add(p1);
                        }

                        int p2 = o - 1 >= 0 ? o - 1 : o - 1 + N;
                        if (isOpen.get(p2) == null) {
                            isOpen.put(p2, true);
                            pp2.add(p2);
                        }
                    }
                }
                pp.removeAll(pp);
                pp.addAll(pp2);
                t++;
            }
            System.out.println(pp.size());
            StringBuilder stb = new StringBuilder();
            for (Integer o : pp) {
                stb.append(o + " ");
            }
            System.out.println(stb.toString());
        }
    }
}
