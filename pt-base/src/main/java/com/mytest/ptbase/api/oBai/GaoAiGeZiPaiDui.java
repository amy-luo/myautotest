package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//高矮个子排队,https://renjie.blog.csdn.net/article/details/128042936
//从高位开始排，序号分奇偶数，遇到不满足条件就交换顺序
public class GaoAiGeZiPaiDui {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            try {
                String s = in.nextLine();
                int[] dataArray = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int i = 1; i < dataArray.length - 1; i++) {
                    if (i % 2 == 0) {
                        if (dataArray[i] < dataArray[i + 1]) {
                            int tmp = dataArray[i];
                            dataArray[i] = dataArray[i + 1];
                            dataArray[i + 1] = tmp;
                        }
                    } else {
                        if (dataArray[i] > dataArray[i + 1]) {
                            int tmp = dataArray[i];
                            dataArray[i] = dataArray[i + 1];
                            dataArray[i + 1] = tmp;
                        }

                    }
                }
                StringBuilder stb = new StringBuilder();
                for (int i = 0; i < dataArray.length; i++) {
                    stb.append(dataArray[i] + " ");
                }
                System.out.println(stb.toString());
            } catch (Exception e) {
                System.out.println("[]");
            }
        }
    }
}
