package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
//寻找最大价值的矿堆,bfs
public class XunZhaoZuiDaJiaZhiKuangDui {
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[][] isVisited;
    public static int[] direct;
    public static int m;
    public static int n;
    public static int res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        list = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.equals("")) {
                break;
            }
            int[] dataArray = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (Integer o : dataArray) {
                list2.add(o);
            }
            list.add(list2);
        }
            m = list.size();//row
            n = list.get(0).size();//col
            isVisited = new boolean[m][n];
            direct = new int[]{0, 1, 0, -1, 0};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isVisited[i][j] && list.get(i).get(j) != 0) {
                        LinkedList<int[]> deque = new LinkedList<>();
                        deque.add(new int[]{i, j});
                        isVisited[i][j] = true;
                        bfsFind(deque);
                    }
                }
            }
        System.out.println(res);
        }


    private static void bfsFind(LinkedList<int[]> deque) {
        int count = 0;
        while (!deque.isEmpty()) {
            int[] pos = deque.poll();
            int i = pos[0];
            int j = pos[1];
            if (list.get(i).get(j) != 0) {
                count += list.get(i).get(j);
            }
            for (int k = 0; k < 4; k++) {
                int x = i + direct[k];
                int y = j + direct[k + 1];
                if (0 <= x && x < m && 0 <= y && y < n && !isVisited[x][y] && list.get(x).get(y) != 0) {
                    isVisited[x][y] = true;
                    deque.addLast(new int[]{x, y});
                }
            }
        }
        res = Math.max(res, count);
    }

}
