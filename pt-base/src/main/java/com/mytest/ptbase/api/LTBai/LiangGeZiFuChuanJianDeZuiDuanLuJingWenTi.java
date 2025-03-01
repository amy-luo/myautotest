package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//两个字符串间的最短路径问题,https://renjie.blog.csdn.net/article/details/135697153
//bfs,3个方向，其中对角线方向是有条件的。
public class LiangGeZiFuChuanJianDeZuiDuanLuJingWenTi {
    public static String s1;
    public static String s2;
    public static int minCount;
    public static int[][] direct;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            s1 = s[0];
            s2 = s[1];
            direct = new int[][]{{0, 1}, {1, 0}, {1, 1}};
            minCount = Integer.MAX_VALUE;
            LinkedList<int[]> deque = new LinkedList<>();
            deque.addLast(new int[]{0, 0});
            dfsFind( 0, deque);
            System.out.println(minCount);
        }
    }

    private static void dfsFind(int count, LinkedList<int[]> deque) {
        boolean flag=false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            count++;
            for (int p = 0; p < size; p++) {
                int[] tmp = deque.poll();
                if (tmp[0] == s2.length() && tmp[1] == s1.length()) {
                    minCount = Math.min(minCount, count-1);
                    flag=true;
                    break;
                }
                for (int k = 0; k < direct.length; k++) {
                    int x = tmp[0] + direct[k][0];
                    int y = tmp[1] + direct[k][1];
                    if (0 <= x && x <= s2.length() && 0 <= y && y <= s1.length()) {
                        if (k != 2) {
                            deque.addLast(new int[]{x, y});
                        } else if (k == 2 && s1.charAt(y - 1) == s2.charAt(x - 1)) {
                            deque.addLast(new int[]{x, y});
                        }
                    }
                }
            }
            if(flag){break;}
        }
    }
}
