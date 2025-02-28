package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//计算疫情扩散时间,https://renjie.blog.csdn.net/article/details/128496761
// bfs，计算遍历层数。用两个队列，存储当前的1，和被感染的0（即下个1）.
//1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
//在一个地图中(地图由n*n个区域组成），有部分区域被感染病菌。 感染区域每天都会把周围（上下左右）的4个区域感染。 请根据给定的地图计算，多少天以后，全部区域都会被感染。 如果初始地图上所有区域全部都被感染，或者没有被感染区域，返回-1
public class JiSuanYiQingKuoSanShiJian {
    public static int[][] matrix;
    public static int[] direct;
    public static int n;
    public static int res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            String s = in.nextLine();
            res = 0;
            if (!s.contains("1") || !s.contains("0")) {
                res = -1;
            } else {
                int[] firstHang = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
                n = (int) Math.sqrt(firstHang.length);//row
                matrix = new int[n][n];
                LinkedList<int[]> deque = new LinkedList<>();
                for (int i = 0; i < firstHang.length; i = i + n) {
                    for (int j = 0; j < n; j++) {
                        matrix[i / n][j] = firstHang[i + j];
                        if (matrix[i / n][j] == 1) {
                            deque.addLast(new int[]{i / n, j});
                        }
                    }
                }
                direct = new int[]{0, 1, 0, -1, 0};
                bfsFind(deque);
            }
            System.out.println(res);
        }
    }

    private static void bfsFind(LinkedList<int[]> deque) {
        while (deque.size() != 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] position = deque.poll();
                for (int k = 0; k < 4; k++) {
                    int x = position[0] + direct[k];
                    int y = position[1] + direct[k + 1];
                    if (0 <= x && x < n && 0 <= y && y < n && matrix[x][y] == 0) {
                        matrix[x][y] = 1;
                        deque.addLast(new int[]{x, y});
                    }
                }
            }
            if(!deque.isEmpty()){res++;}
        }
    }
}
