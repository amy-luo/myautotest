package com.mytest.ptbase.api.oBai;

import java.util.*;

//手机防沉迷游戏，时间冲突的app，优先级高的app注册时会注销低优先级的app，如果时间冲突的app优先级不高于已启动的APP，根本就不会启动。
//https://renjie.blog.csdn.net/article/details/135228872
//list排序，根据数组中的某个值由大到小；

public class ShouJiFangChenMiYouXi {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int N = Integer.valueOf(in.nextLine());
            ArrayList<String[]> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] s = in.nextLine().split(" ");
                String[] s1 = s[2].split(":");
                s[2] = String.valueOf(Integer.valueOf(s1[0]) * 60 + Integer.valueOf(s1[1]));
                String[] s2 = s[3].split(":");
                s[3] = String.valueOf(Integer.valueOf(s2[0]) * 60 + Integer.valueOf(s2[1]));
                list.add(s);
            }
            Collections.sort(list, (o1, o2) -> Integer.parseInt(o1[2]) - Integer.valueOf(o2[2]));
            String[] time = in.nextLine().split(":");
            int T = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            LinkedList<String[]> deque = new LinkedList<>();//存在依次启动的app、优先级、启动开始时间、实际结束时间，不启动的不会存放进来
            String res = "";
            for (int i = 0; i < N; i++) {
                String[] tmp = list.get(i);
                if (i == 0) {
                    deque.addLast(tmp);
                } else {
                    String[] s = deque.pollLast();//上一个启动的app
                    if (tmp[2].compareTo(s[3]) < 0 && tmp[1].compareTo(s[1]) < 0) {//存在时间冲突是，后来着优先级低于前者时，不会启动，仅加回s，tmp直接去掉
                        deque.addLast(s);
//                        deque.addLast(tmp);
                    }
                    if (tmp[2].compareTo(s[3]) < 0 && tmp[1].compareTo(s[1]) > 0) {//存在时间冲突是，后来着优先级要高于前者时，才能启动，并去修改前者的结束时间。
                        s[3] = tmp[2];
                        deque.addLast(s);
                        if (Integer.valueOf(s[2]) <= T && T <= Integer.valueOf(s[3])) {//确定了上一个app的结束时间后，判断T是否在这个范围内
                            res=s[0];
                            break;
                        }
                        deque.addLast(tmp);
                    }
                    if (tmp[2].compareTo(s[3]) >= 0) {//不存在时间冲突时，不用看优先级，肯定能启动
                        deque.addLast(s);
                        if (Integer.valueOf(s[2]) <= T && T < Integer.valueOf(s[3])) {//确定了上一个app的结束时间后，判断T是否在这个范围内
                            res=s[0];
                            break;
                        }
                        deque.addLast(tmp);
                    }
                }
            }
            String[] sLast = deque.pollLast();//上一个启动的app.处理最后一个app，因为前面未判断过T
            if (Integer.valueOf(sLast[2]) <= T && T < Integer.valueOf(sLast[3])) {//确定了上一个app的结束时间后，判断T是否在这个范围内
                res=sLast[0];

            }
            System.out.println(res.equals("")?"NA":res);



//        Integer priority = -1;
//        int index=0;
//        String appName="NA";
//        for (int i = 0; i < N; i++) {
//            if (Integer.valueOf(list.get(i)[2])<=T&&T<Integer.valueOf(list.get(i)[3])) {
//                if(Integer.valueOf(list.get(i)[1])>priority&&(
//                        (i+1<N&&Integer.valueOf(list.get(i)[2])<Integer.valueOf(list.get(i+1)[2])&&T<Integer.valueOf(list.get(i+1)[2]))
//                ||(i+1<N&&Integer.valueOf(list.get(i)[1])>=Integer.valueOf(list.get(i+1)[1]))||
//                        (i>0&&Integer.valueOf(list.get(i)[1])>Integer.valueOf(list.get(i-1)[1]) &&Integer.valueOf(list.get(i)[2])<Integer.valueOf(list.get(i-1)[3])))){
//                    appName=list.get(i)[0];
//                    priority=Integer.valueOf(list.get(i)[1]);
//                    index=i;
//                }
//            }
//        }
//        int sum=map.values().stream().mapToInt(Integer::intValue).sum();//不对，值没有除以100乘以15

//        System.out.println(appName);
        }
    }
}
