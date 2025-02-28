package com.mytest.ptbase.api.LTBai;

import java.util.*;

//观看文艺汇演问题，https://renjie.blog.csdn.net/article/details/130629641
//递归回溯，
//5
//720 600
//840 120
//1000 30
//1050 10
//1100 5
public class GuanKanWenYiHuiYan {

    public static int[][] matrix;
    public static int n;
    public static boolean[][] isVisited;
    public static ArrayList<Integer> list;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            n = Integer.valueOf(in.nextLine());
            matrix = new int[n][2];
            for (int i = 0; i < n; i++) {
                int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                matrix[i][0] = firstHang[0];
                matrix[i][1] = firstHang[0] + firstHang[1];
            }

            Arrays.sort(matrix, (Comparator.comparingInt(o -> o[0])));
            list = new ArrayList<>();
            calDiguiHuisu(0, 0, 0);
            System.out.println(Collections.max(list));
        }
    }

    private static void calDiguiHuisu(int row, int count, int endTime) {
        if (row == n) {
            list.add(count);
            return;
        } else {
            for (int i = row; i < n; i++) {
                if (i == 0 || (i > 0 && matrix[i][0] >= endTime)) {
                    int endTime1 = matrix[i][1] + 15;
                    calDiguiHuisu(i + 1, count + 1, endTime1);
                }
                if (row == n) {
                    list.add(count);
                    return;
                }
            }
        }
    }
}
