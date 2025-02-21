package com.mytest.ptbase.api.oBai;

import java.lang.reflect.Array;
import java.util.*;

//第k个排列,https://renjie.blog.csdn.net/article/details/143802598
//字典序排列，字典序的第k个排列。较难。
//从右往左，找出第一个左边元素值小于右边元素值的位置也是，第一次出现arry[j]<arry[j+1]；j右边元素依次放入list（可知是从小到大排序的）
//j的右边部分(list中)找出大于arry[j]的数中最小（第一个找到的数）的一个将其插入j的位置。j和后面的数从小到大排序。
public class DiKGePaiLie {
    public static LinkedList<Integer> deque;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int n = in.nextInt();
            int K = in.nextInt();
            deque = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                deque.addLast(i);
            }
            for (int i = 2; i <= K; i++) {
                dfsFind();
            }
            StringBuilder stb = new StringBuilder();
            while (!deque.isEmpty()) {
                stb.append(deque.poll());
            }
            System.out.println(stb.toString());
        }
    }

    private static boolean dfsFind() {
        ArrayList<Integer> list = new ArrayList<>();
        int wei = deque.pollLast();
        list.add(wei);
        while (!deque.isEmpty()) {
            int bijiao = deque.pollLast();
            list.add(bijiao);
            if (bijiao < wei) {
                int minDayu = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) > bijiao) {
                        minDayu = j;
                        break;
                    }
                }
                deque.addLast(list.get(minDayu));
                list.remove(minDayu);
                Collections.sort(list);
                for (Integer o : list) {
                    deque.addLast(o);
                }
                return true;
            } else {
                wei = bijiao;
            }
        }
        return false;
    }
}
