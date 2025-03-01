package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//贪心歌手，https://yule.sohu.com/a/770321029_121118947
//贪心，priorityQueue，按转钱的最大值，排序，取完后，重新排序，再取最大值。
// 实际上我们并不需要按照歌手的时间线来考虑问题，而是按照某一天能够在哪个城市获得的钱数最多来考虑问题的。
public class TanXinGeShou {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int daysSum = Integer.valueOf(s[0]);
            int citysNum = Integer.valueOf(s[1]);
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int days=daysSum-Arrays.stream(dataArray).sum();
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0]-o1[0];
                }
            });
            for (int i = 0; i < citysNum; i++) {
                int[] changge =  Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                queue.offer(changge);
            }
            int sumQian=0;
            for (int i = 0; i < days; i++) {
                int[] tmp=queue.poll();
                sumQian += tmp[0];
                queue.offer(new int[]{Math.max(0, tmp[0] - tmp[1]), tmp[1]});
            }
            System.out.println(sumQian);
        }
    }
}
