package com.mytest.ptbase.api.niuke;

import java.util.*;

//手机防沉迷游戏，时间冲突的app，优先级高的app注册时会注销低优先级的app，如果时间冲突的app优先级不高于已启动的APP，根本就不会启动。
//list排序，根据数组中的某个值由大到小；

public class APPTime {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        int N = Integer.valueOf(in.nextLine());
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] s = in.nextLine().split(" ");
            String[] s1 = s[2].split(":");
            s[2]=String.valueOf(Integer.valueOf(s1[0]) * 60 + Integer.valueOf(s1[1]));
            String[] s2 = s[3].split(":");
            s[3]=String.valueOf(Integer.valueOf(s2[0]) * 60 + Integer.valueOf(s2[1]));
            list.add(s);
        }
        Collections.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.valueOf(o1[2])-Integer.valueOf(o2[2]);
            }
        });
        String[] time = in.nextLine().split(":");
        int T=Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);

        Integer priority = -1;
        int index=0;
        String appName="NA";
        for (int i = 0; i < N; i++) {
            if (Integer.valueOf(list.get(i)[2])<=T&&T<Integer.valueOf(list.get(i)[3])) {
                if(Integer.valueOf(list.get(i)[1])>priority&&(
                        (i+1<N&&Integer.valueOf(list.get(i)[2])<Integer.valueOf(list.get(i+1)[2])&&T<Integer.valueOf(list.get(i+1)[2]))
                ||(i+1<N&&Integer.valueOf(list.get(i)[1])>=Integer.valueOf(list.get(i+1)[1]))||
                        (i>0&&Integer.valueOf(list.get(i)[1])>Integer.valueOf(list.get(i-1)[1]) &&Integer.valueOf(list.get(i)[2])<Integer.valueOf(list.get(i-1)[3])))){
                    appName=list.get(i)[0];
                    priority=Integer.valueOf(list.get(i)[1]);
                    index=i;
                }
            }
        }
//        int sum=map.values().stream().mapToInt(Integer::intValue).sum();//不对，值没有除以100乘以15

        System.out.println(appName);
    }
}
