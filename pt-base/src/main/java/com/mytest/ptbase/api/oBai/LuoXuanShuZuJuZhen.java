package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//螺旋数组矩阵，https://renjie.blog.csdn.net/article/details/135253014
//设置好路径方向，模拟过程，注意判断边界条件，满足条件时改变方向
public class LuoXuanShuZuJuZhen {
    public static String[][] matrix;
    public static boolean[][] isVisited;
    public static int[][] direct;
    public static int m;
    public static int n;
    public static int N;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            direct=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            String[] s=in.nextLine().split(" ");
            N = Integer.valueOf(s[0]);
            m = Integer.valueOf(s[1]);
            n = N%m==0?N/m:N/m+1;
            matrix=new String[m][n];
            isVisited=new boolean[m][n];
            dfs(1,0,0,0);

            for(int i=0;i<m;i++) {
                StringBuilder stb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    stb.append(matrix[i][j]);
                }
                System.out.println(stb);
            }
        }
    }
    private static void dfs(int index,int i,int j,int p){
        if(index>m*n){return;}
        if(index>N&&index<=m*n){
            matrix[i][j]="*";
            isVisited[i][j]=true;
        }
        if(index>=1&&index<=N) {
            matrix[i][j] = String.valueOf(index);
            isVisited[i][j]=true;//设置状态
        }
        int x =i+ direct[p][0];
        int y =j+ direct[p][1];
        if(x<0||x>=m||y<0||y>=n||isVisited[x][y]) {//超出边界时，改变方向
            p=(p+1)%4;
            x =i+ direct[p][0];
            y =j+ direct[p][1];
        }
        dfs(index+1,x,y,p);
    }
}
