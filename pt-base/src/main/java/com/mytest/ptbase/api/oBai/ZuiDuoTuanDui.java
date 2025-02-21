package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//最多团队，https://renjie.blog.csdn.net/article/details/128139390
//双向队列，先按从大到小排序
public class ZuiDuoTuanDui {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int m = in.nextInt();
            int[] ren = new int[m];
            LinkedList<Integer> deque = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                deque.addLast(in.nextInt());
            }
            int k = in.nextInt();
            Collections.sort(deque, ((o1, o2) -> o2 - o1));
            int count = 0;
            while (!deque.isEmpty()) {
                int value = deque.pollFirst();
                if (value >= k) {
                    count++;
                } else {
                    while (!deque.isEmpty() && value + deque.pollLast() >= k) {
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
