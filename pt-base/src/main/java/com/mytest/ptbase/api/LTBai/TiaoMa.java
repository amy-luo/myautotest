package com.mytest.ptbase.api.LTBai;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
//跳马，bfs，https://renjie.blog.csdn.net/article/details/135018519
//2 3
//.11
//...
public class TiaoMa {
    public static String[][] matrix;
    public static int[][] result;
    public static int[][] direct;
    public static int m;
    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            m = Integer.valueOf(s[0]);
            n = Integer.valueOf(s[1]);
            matrix=new String[m][n];//记得初始化
            for (int i = 0; i < m; i++) {
                String[] dataArray = in.nextLine().split("");
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=dataArray[j];
                }
            }
            direct=new int[][]{{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
            result = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(!matrix[i][j].equals(".")) {
                        int[][] resultEach = new int[m][n];//存放每匹马跳的结果，到各个可能的位置是多少步。
                        for(int[] o:resultEach) {
                            Arrays.fill(o, -1);
                        }
                        resultEach=bfsFind(i, j, resultEach);
//                        System.out.println(JSONObject.toJSONString(resultEach));
                        getResult(resultEach);
//                        System.out.println(JSONObject.toJSONString(result));
                    }
                }
            }
            int minStepSum=Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(result[i][j]!=-1) {
                        minStepSum = Math.min(minStepSum, result[i][j]);
                    };
                }
            }
            System.out.println(minStepSum==Integer.MAX_VALUE?-1:minStepSum);//没有结果，不能跳到同一个地方返回-1
        }
    }
    private static void getResult(int[][] resultEach){//更新每匹马遍历完整个地图后的结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(resultEach[i][j]==-1){//只要有一匹马不能跳到这个地方，就将结果记录为-1，以后也不能改，因为这个地方就不可能被所有马同时跳到
                    result[i][j]=-1;
                }else if(resultEach[i][j]!=-1&&result[i][j]==-1){
                    continue;
                }else if(resultEach[i][j]!=-1&&result[i][j]!=-1){
                    result[i][j] += resultEach[i][j];}
            }
        }

    }
    private static int[][] bfsFind(int i,int j,int[][] resultEach){
        resultEach[i][j]=0;//这匹马的原位只需要0步，这个初始化的条件记得加上
        int step=1;
        LinkedList<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{i,j});
        while(true){
            if((step>Integer.valueOf(matrix[i][j]))||deque.isEmpty()){break;}
            int size=deque.size();
            for(int k=0;k<size;k++){//循环队列里的下一步
                int pos[]=deque.pollFirst();
                int x = pos[0];
                int y = pos[1];
                for(int d=0;d<8;d++){
                    int new_x=x+direct[d][0];
                    int new_y=y+direct[d][1];
                    if(0<=new_x&&new_x<m&&0<=new_y&&new_y<n&&resultEach[new_x][ new_y]==-1){//记录已访问过的位置，-1代表没访问过，其它数字代表步数，也代表已访问过。同一匹马不能重复跳一个地方。
                        resultEach[new_x][new_y]=step;
                        deque.addLast(new int[]{new_x,new_y});
                    }
                }
            }
            step++;//记录跳的步数
        }
        return resultEach;

    }
}
