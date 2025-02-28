package com.mytest.ptbase.api.oBai;

import sun.awt.image.ImageWatched;

import java.util.*;

//数组拼接,https://renjie.blog.csdn.net/article/details/130752422
//使用linkedlist双向队列，模拟元素弹出过程。注意终止条件，res的长度为所有元素个数时，可以终止。
public class ShuZuPinJie {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int k = Integer.valueOf(in.nextLine());
            int n = Integer.valueOf(in.nextLine());
            ArrayList<LinkedList<Integer>> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
                LinkedList<Integer> deque = new LinkedList<>();
                for (int j = 0; j < dataArray.length; j++) {
                    deque.add(dataArray[j]);
                    sum++;
                }
                list.add(deque);
            }
            ArrayList<Integer> res = new ArrayList<>();
            while (res.size() < sum) {
                for (LinkedList<Integer> deque : list) {
                    for (int i = 0; i < k; i++) {
                        if (!deque.isEmpty()) {
                            res.add(deque.pollFirst());
                        } else {
                            break;
                        }
                    }
                }
            }
            StringBuilder stb = new StringBuilder();
            for (Integer o : res) {
                stb.append(o + ",");
            }
            System.out.println(stb.substring(0, stb.length() - 1));
        }
    }
}
