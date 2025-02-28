package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//找单词,https://renjie.blog.csdn.net/article/details/130807542
//dfs
public class ZhaoDanCi {
    public static Character[][] matrix;
    public static boolean[][] isVisited;
    public static int[][] resultPos;
    public static int[] direct;
    public static int m;
    public static String danci;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            m = Integer.valueOf(in.nextLine());
            matrix=new Character[m][m];
            isVisited=new boolean[m][m];
            for (int i = 0; i < m; i++) {
                String[] table = in.nextLine().split(",");
                for (int j = 0; j < m; j++) {
                    matrix[i][j]=table[j].charAt(0);
                }

            }
            danci = in.nextLine();
            resultPos=new int[danci.length()][2];
            direct = new int[]{0, 1, 0, -1, 0};
            int index=0;
            if(matrix[0][0]==(danci.charAt(0))){//先判断矩阵的(0,0)个元素和字符串第0个字符的匹配情况
                resultPos[0]=new int[]{0,0};
                isVisited[0][0]=true;
                index++;
            }
            boolean res=dfsFind(0, 0,index, isVisited,resultPos);
            if(res) {
                StringBuilder stb = new StringBuilder();
                for (int i = 0; i < danci.length(); i++) {
                    for (int j = 0; j < 2; j++) {
                        stb.append(resultPos[i][j]).append(",");
                    }
                }
                System.out.println(stb.toString());
            }else{System.out.println("N");}

        }
    }
    private static boolean dfsFind(int i,int j,int index,boolean[][] isVisited,int[][] resultPos){
        if(index==danci.length()){
            return true;
        }
        for(int k=0;k<4;k++){
            int x = i + direct[k];
            int y = j + direct[k+1];
            if(0<=x&&x<m&&0<=y&&y<m&&!isVisited[x][y]&&matrix[x][y]==danci.charAt(index)){
                isVisited[x][y]=true;
                resultPos[index]=new int[]{x,y};
                boolean res=dfsFind(x,y,index+1,isVisited,resultPos);
                if(res){
                    return true;//找到了就返回，不用继续再找了，因为就题设只可能存在一个，如果继续找可能会改变结果数组值。
                }
                isVisited[x][y]=false;
            }
        }
        return false;
    }
}
