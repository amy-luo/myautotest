package com.mytest.ptbase.api.oBai;

import java.util.*;

//报数游戏，https://renjie.blog.csdn.net/article/details/131724709
//使用LinkedList，双向队列，取出头元素后放到尾部，并数数，M的数丢掉。
public class BaoShuYouXi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            Integer M = Integer.valueOf(in.nextLine());
            int count = 1;
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 1; i <= 100; i++) {
                list.add(i);
            }
            while(list.size()>=M){
                if(count==M){
                    count=1;
                    list.pollFirst();
                }else{
                    list.addLast(list.pollFirst());
                    count++;
                }
            }
            Collections.sort(list);
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stb.append(list.get(i) + ",");
            }
            System.out.println(stb.toString().substring(0, stb.length() - 1));
        }
    }

}
