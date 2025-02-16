package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//寻找最优的路测线路，https://renjie.blog.csdn.net/article/details/135483183
//二分法+DFS,记录已访问的位置。
public class LuCeLuXian {
    public static int[][] matrix;
    public static int[] direct;
    public static int m;
    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            m = in.nextInt();//row
            n = in.nextInt();//row
            matrix=new int[m][n];
            int maxValue=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=in.nextInt();
                    maxValue=Math.max(maxValue,matrix[i][j]);
                }
            }
            int left=0;
            int right = maxValue;
            int mid=0;
            int res=-1;
            direct = new int[]{0, 1, 0, -1, 0};
            while(left<=right){
                mid=(left+right)/2;
//                mid=3;
                int res1=dfsFind(0,0,mid,new boolean[m][n],matrix[0][0]);
                if(res1!=-1){
                    res=Math.max(res,res1);
                    left=res1+1;
                }else{right=mid-1;}
            }
            System.out.println(res);

        }
    }
    private static int dfsFind(int i,int j, int mid,boolean[][]isVisited,int minFen){
        if(i==m-1&&j==n-1){return minFen;}
        for(int k=0;k<4;k++){
            int x = i + direct[k];
            int y = j + direct[k+1];
            if(0<=x&&x<m&&0<=y&&y<n&&matrix[x][y]>=mid&&!isVisited[x][y]){
                int minFen2=Math.min(minFen,matrix[x][y]);
                isVisited[x][y]=true;
                int isFind=dfsFind(x,y,mid,isVisited,minFen2);
                if(isFind>0){return isFind;}//找到后，返回最低质量分值
                isVisited[x][y]=false;
            }
        }
        return -1;
    }
}
