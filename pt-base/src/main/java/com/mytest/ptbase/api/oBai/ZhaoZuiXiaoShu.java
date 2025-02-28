package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//找最小数，https://renjie.blog.csdn.net/article/details/130792874
//贪心算法，比较难，从高位往低位看，哪一位开始下降了，就移除它的前一位，再判断前一位。完了之后，假如还有多数个没移除，就都从从最后一个开始移除。如果是递增就删除最后一个数。
public class ZhaoZuiXiaoShu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int K = Integer.valueOf(in.nextLine());
            int count = 1;
            LinkedList<Character> deque = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char dq = s.charAt(i);
                while (!deque.isEmpty() && count <= K && deque.peekLast() > dq) {
                    deque.pollLast();
                    count++;
                }
                deque.addLast(dq);
            }
            if (K - count > 0) {
                for (int i = 0; i < K - count; i++) {
                    deque.pollLast();
                }
            }
            StringBuilder stb = new StringBuilder();
            for (Character o : deque) {
                stb.append(o);
            }
            System.out.println(stb.length()==0?"0":Integer.valueOf(stb.toString()));
        }
    }
}
