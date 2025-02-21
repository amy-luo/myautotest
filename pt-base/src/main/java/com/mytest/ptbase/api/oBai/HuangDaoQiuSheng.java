package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//自由练习，https://renjie.blog.csdn.net/article/details/131810875
//场上选手,如果大于0往前主队列取元素pk，如果小于0往待pk正数队列进行pk，如果正数队列为空，主场负数直接存负数队列。
public class HuangDaoQiuSheng {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = dataArray.length;//row
            LinkedList<Integer> list = new LinkedList<>();//主队列
            LinkedList<Integer> list3 = new LinkedList<>();//存放待pk的正数，往右过河
            for(int o:dataArray){
                list.addLast(o);
            }
            int first=list.pollFirst();//场上选手,如果大于0往前主队列取元素pk，如果小于0往待pk正数队列进行pk。
            int count_left=0;
            while (!list.isEmpty()||(list.isEmpty()&&first!=Integer.MIN_VALUE)) {
                if(first<0){
                    if(list3.isEmpty()) {
                        count_left++;
                        first = list.peekFirst()!=null?list.pollFirst():Integer.MIN_VALUE;
                        if(first==Integer.MIN_VALUE){break;}
                        continue;
                    }else{
                        int second=list3.pollLast();
                        if(first+second==0){first=list.peekFirst()!=null?list.pollFirst():Integer.MIN_VALUE;continue;}
                        if(first+second!=0){first=first+second;continue;}
                    }
                }else{
                    int second=list.peekFirst()!=null?list.pollFirst():Integer.MIN_VALUE;
                    if(second==Integer.MIN_VALUE){break;}
                    if(second<0){
                        if(first+second==0){first=list.peekFirst()!=null?list.pollFirst():Integer.MIN_VALUE;continue;}
                        if(first+second!=0){first=first+second;continue;}
                    }else{
                        list3.add(first);//待pk
                        first=second;//场上选手
                    }
                }
                if(first==Integer.MIN_VALUE){break;}
            }
            if(first!=Integer.MIN_VALUE){System.out.println(count_left+list3.size()+1);}else {
                System.out.println(count_left + list3.size());
            }
        }
    }
}
