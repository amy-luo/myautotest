package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//传递悄悄话，https://renjie.blog.csdn.net/article/details/134767446
//求二叉树到子节点的最长路径。二叉树的根节点的左右子节点是2*i+1,2*i+2
public class ChuanDiQiaoQiaoHua {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static int maxSum;

    //    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            maxSum = Integer.MIN_VALUE;
            dfs(0, dataArray, 0);
            System.out.println(maxSum);
        }
    }

    private static void dfs(int i, int[] dataArray, int sum) {
        if(i>=dataArray.length||dataArray[i]==-1){
            maxSum = Math.max(maxSum, sum);
        return;
        }else{
            sum += dataArray[i];
            dfs(2 * i + 1, dataArray, sum);//左节点
            dfs(2 * i + 2, dataArray, sum);//右节点
        }
    }
}
