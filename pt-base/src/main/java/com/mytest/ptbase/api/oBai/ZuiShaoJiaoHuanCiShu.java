package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//自由练习
//先求所有小于k的数的长度，然后以这个长度滑行，找出其中小于k的数量最多的一个状态，然后里面不在的就是需要交换过来的
public class ZuiShaoJiaoHuanCiShu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {

            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int K = Integer.valueOf(in.nextLine());//row
            int count = 0;
            ArrayList<Integer> indexList = new ArrayList<>();
            int[] sum = new int[dataArray.length];//第i个元素前面有几个元素<k,记录下来。
            for (int i = 0; i < dataArray.length; i++) {
                if (dataArray[i] < K) {
                    indexList.add(i);
                    sum[i] = i == 0 ? dataArray[0] : sum[i - 1] + 1;
                    count++;
                } else {
                    sum[i] = i == 0 ? dataArray[0] : sum[i - 1];
                }
            }
            int minValue = Integer.MAX_VALUE;
            int[] index = new int[2];
            for (int i = indexList.get(0), j = indexList.get(0) + count - 1; j <= indexList.get(indexList.size() - 1); i++, j++) {//窗口固定长度，同时加，要写成一行
                int tihuan = i == 0 ? count - sum[j] : count - sum[j] + sum[i - 1];
                minValue = Math.min(tihuan, minValue);
            }
            System.out.println(minValue);

        }
    }

}
