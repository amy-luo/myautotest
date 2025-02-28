package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//学生方阵，https://renjie.blog.csdn.net/article/details/127973216
//图论，遍历4个方向,分别是从左往右，从上往下，对角线，反对角线,反对角线的坐标不要弄错了
public class XueShengFangZhen {
    public static String[][] matrix;
    public static int m;
    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            m = firstHang[0];//row
            n = firstHang[1];//col
            matrix=new String[m][n];
            for (int i = 0; i < m; i++) {
                String[] dataArray = in.nextLine().split(",");
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=dataArray[j];
                }
            }
            int resultMax=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j].equals("M")){
                        int res=getMaxCount(i,j);
                        resultMax = Math.max(resultMax, res);
                    }
                }
            }
            System.out.println(resultMax);
        }
    }
    private static int getMaxCount(int i,int j){
        int[][] direct=new int[][]{{0,1},{1,0},{1,1},{1,-1}};//分别是从左往右，从上往下，对角线，反对角线,反对角线的坐标不要弄错了
        ArrayList<Integer> list = new ArrayList<>();//存储4个方向的男生和
        for(int k=0;k<4;k++){
            int count = 1;
            int x=i;//每次遍历各个方向，都要重设初始值为i，j
            int y=j;
            while(true) {
                x = x + direct[k][0];
                y = y + direct[k][1];
                if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y].equals("M")) {
                    count++;
                }else{
                    list.add(count);
                    break;
                }
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }

}
