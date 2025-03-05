package com.mytest.ptbase.api.oBai;

import java.util.*;

//最小的调整次数，https://fcqian.blog.csdn.net/article/details/128080305
//调整一次（是指排序，可以包括多次调换顺序）,用linkedList操作元素，增加元素的时候需要看是否破坏有序性，remove的时候检查是否有序flag，无序时就要操作排序。
public class ZuiXiaoDeTiaoZhengCiShu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int n = Integer.valueOf(in.nextLine());
            LinkedList<Integer> deque = new LinkedList<>();
            boolean flag = true;
            int count = 0;
            for (int i = 0; i < 2 * n; i++) {
                String s = in.nextLine();
                String[] sar = s.split(" ");
                if (sar[0].equals("head")) {
//                    if(deque.peekFirst()==null||Integer.valueOf(sar[2])+1==deque.peekFirst()){//deque为空时，添加元素默认有序
//                        flag=true;
//                    }else{flag=false;}
                    if (deque.size() == 0) {//deque为空时，添加元素默认有序
                        flag = true; } else { flag = false;}
                    deque.addFirst(Integer.valueOf(sar[2]));
                } else if (sar[0].equals("tail")) {//尾部添加不会改变有序性，因为是从1-n依次添加，头部添加会改变有序性，后加入的数一定比已有的数大，只有尾部添加才不会破坏顺序
//                    if(deque.peekLast()==null||Integer.valueOf(sar[2])==deque.peekLast()+1){
//                        flag=true;
//                    }else{flag=false;}
                    deque.addLast(Integer.valueOf(sar[2]));
                } else if (sar[0].equals("remove")) {
                    if (!flag) {
                        Collections.sort(deque);
                        flag = true;
                        count++;
                    }
                    deque.pollFirst();
                }
            }
            System.out.println(count);
        }
    }
}
