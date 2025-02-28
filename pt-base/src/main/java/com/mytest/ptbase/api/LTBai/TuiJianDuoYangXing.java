package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//推荐多样性，列表-窗口。先将列表中的元素分等份放入队列中，再按顺序放入window中，再按照要求的顺序答应。https://renjie.blog.csdn.net/article/details/135273761
public class TuiJianDuoYangXing {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static int N;
    public static int K;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        ArrayList<LinkedList<Integer>> list = new ArrayList<>();
        int N = Integer.valueOf(in.nextLine());//window数量
        int K = Integer.valueOf(in.nextLine());//window容量
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.equals("")) {
                break;
            }
            String[] firstHang = s.split(" ");
            LinkedList<Integer> deque = new LinkedList<>();
            for (String o : firstHang) {
                deque.addLast(Integer.valueOf(o));
            }
            list.add(deque);
        }
        LinkedList<Integer> dequeFang = new LinkedList<>();
        for (int i = 0; dequeFang.size() <= N * K; i = (i + 1) % list.size()) {//将列表元素均N等份(不够就结束跳到下一行)，排队放好在dequeFang中，dequeFang中有N*K个元素就够了。
            LinkedList<Integer> list2 = list.get(i);
            for (int j = 0; j < N; j++) {
                if (!list2.isEmpty()) {
                    dequeFang.addLast(list2.poll());
                } else {
                    break;
                }
            }
            list.set(i, list2);
        }

        matrix = new int[N][K];

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                matrix[j][i] =dequeFang.poll();//在window依次放置元素。

            }
        }
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                stb.append(matrix[i][j]+" ");
            }
        }
        System.out.println(stb.toString());

    }

}
