package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//攀登者2，https://renjie.blog.csdn.net/article/details/135557083
//过程模拟，注意很多边界条件。左上右下，右上左下，左上左下，右上右下，左边界的山只有右上右下，有边界的山只有左上左下。
public class PanDengZhe2 {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int tili = Integer.valueOf(in.nextLine());
            int left_right = 0;//左上右下
            int right_left = 0;//右上左下
            int left_left = 0;//左上左下
            int right_right = 0;//右上右下
            boolean flag = false;
            int sumCount = 0;
            String type = "M";//"M","L","R","R"代表只能从右侧上的山
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < dataArray.length; i++) {
                if (i == 0 && dataArray[i] != 0) {//开始登山，需要计算，//只能右侧登山
                    type = "R";
                    flag = true;
                }
                if (i>0&&dataArray[i] != 0 && dataArray[i - 1] == 0) {//开始登山，需要计算
                    flag = true;
                }
                if (flag) {
                    int tmp=i>0?dataArray[i] - dataArray[i - 1]:0;
                    left_right += tmp > 0 ? 2 * tmp : Math.abs(tmp);//左侧上山
                    right_left += tmp > 0 ? tmp : Math.abs(2 * tmp);//右侧上山
                    if (!type.equals("R")&&i>0&&i < dataArray.length - 1 && dataArray[i - 1] < dataArray[i] && dataArray[i] > dataArray[i + 1]) {
                        left_left = left_right + right_left;
                        list.addLast(left_left);
                    }
                    if (!type.equals("R")&&i == dataArray.length - 1 && dataArray[i - 1] < dataArray[i]) {
                        left_left = left_right + right_left;
                        list.addLast(left_left);
                    }
                    if (type.equals("R")&&(i==0||(i < dataArray.length - 1 && dataArray[i - 1] < dataArray[i] && dataArray[i] > dataArray[i + 1]))) {
                        left_left = left_right+right_left;
                        list.addLast(left_left);
                    }
                }
                if (i>0&&dataArray[i] == 0 && dataArray[i - 1] != 0) {//登山结束，需要做一次结算，无需计算
                    if (type == "R") {//登山结束，需要做一次结算，无需计算,只能右侧侧登山的情况，山靠左边界
                        while (!list.isEmpty()) {
                            if (left_right + right_left - list.poll() <= tili) {
                                sumCount++;
                            }
                        }
                        flag = false;
                        left_right = 0;//左上右下
                        right_left = 0;//右上左下
                        type = "M";
                        continue;
                    }
                    else{//山在中间的情况
                        while (!list.isEmpty()) {
                            left_left=list.poll();
                            right_right = left_right + right_left -left_left;//右上右下
                            int minTili = Math.min(right_right, Math.min(left_left, Math.min(left_right, right_left)));
                            if (minTili <= tili) {
                                sumCount++;
                            }
                        }
                    }
                    flag = false;
                    left_right = 0;//左上右下
                    right_left = 0;//右上左下
                    type = "M";
                    continue;
                }
                if (!type.equals("R")&&i == dataArray.length - 1&&dataArray[i] != 0) {//登山结束，需要做一次结算，无需计算,只能左侧登山的情况，山靠右边界
                    while (!list.isEmpty()) {
                        if (list.poll() <= tili) {
                            sumCount++;
                        }
                    }
                    flag = false;
                    left_right = 0;//左上右下
                    right_left = 0;//右上左下
                    type = "M";
                    continue;
                }
            }
            System.out.println(sumCount);
        }
    }

}
