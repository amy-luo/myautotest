package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//计算网络信号,深度优先遍历，求某个位置的信号强弱，只有一个信号源。这道题我用的时dfs，博客里面用的bfs
//https://renjie.blog.csdn.net/article/details/128351616
public class JiSuanWangLuoXinHao {
    public static int[] direct;
    public static int I;
    public static int J;
    public static int Y;
    public static int x;
    public static int y;
    public static int m;
    public static int n;
    public static int xinhao;
    public static LinkedList<int[]> deque;
    public static int[][] pos;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = in.nextLine().split(" ");
        String[] b = in.nextLine().split(" ");
        String[] c = in.nextLine().split(" ");
        Integer[] a1 = transfer(a);
        Integer[] b1 = transfer(b);
        Integer[] c1 = transfer(c);
        m = a1[0];//row
        n = a1[1];//col
        x = c1[0];//row
        y = c1[1];//col
        pos=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pos[i][j]=b1[5*i+j];
                if(pos[i][j]>0){
                    I=i;
                    J=j;
                    Y=pos[i][j];
                }
            }
        }
        direct=new int[]{0,1,0,-1,0};
        xinhao=0;
        digui(I,J);
        System.out.println(xinhao);
    }

    public static void digui(int i,int j){
            if (i == x && j == y) {
                xinhao=pos[i][j];
                return;
            }
            if (pos[i][j] == 0) {
                return;
            }
            for(int k=0;k<4;k++){
                int new_i = i + direct[k];
                int new_j = j + direct[k + 1];
                if(0<=new_i&&new_i<m&&0<=new_j&&new_j<n&&pos[new_i][new_j]!= -1){
                    if (pos[new_i][new_j] == 0) {
                        pos[new_i][new_j]=pos[i][j]-1;
                            digui(new_i,new_j);
                }
                }
        }
    }

    public static Integer[] transfer(String[] a){
        Integer b[]=new Integer[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.valueOf(a[i]);
        }
        return b;
    }
}
