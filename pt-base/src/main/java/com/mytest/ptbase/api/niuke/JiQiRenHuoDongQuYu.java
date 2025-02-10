package com.mytest.ptbase.api.niuke;

import java.util.*;

//Bfs
//现有一个机器人，可放置于 M × N 的网格中任意位置，每个网格包含一个非负整数编号，当相邻网格的数字编号差值的绝对值小于等于 1 时，机器人可以在网格间移动。
//
//问题： 求机器人可活动的最大范围对应的网格点数目。
//
//​说明：​
//
//网格左上角坐标为 (0,0) ,右下角坐标为(m−1,n−1)
//机器人只能在相邻网格间上下左右移动
public class JiQiRenHuoDongQuYu {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static int[] direct;
    public static int m;
    public static int n;

//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = firstHang[0];//row
            n = firstHang[1];//col
            matrix=new int[m][n];
            isVisited=new boolean[m][n];//记录访问过的元素，用来去重
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=dataArray[j];
                    isVisited[i][j]=false;
                }
            }
            direct=new int[]{0,1,0,-1,0};
            ArrayList<Integer> list=new ArrayList<>();
            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(!isVisited[i][j]) {//遍历每个元素，从每一个元素开始bfs，如果元素曾被访问过就不需要bfs了，因为它跟别的元素已组成过连续区域了。
                        LinkedList<int[]> deque = new LinkedList<>();//双向队列
                        deque.addFirst(new int[]{i, j});//将起始位置放入队列中
                        isVisited[i][j]=true;//标记起始元素已经被访问
                        int count = bfsFind(deque);//返回改起始位置的活动区域数
                        list.add(count);
                    }
                }
            }
            System.out.println(Collections.max(list));
        }
    }
    private static int bfsFind(LinkedList<int[]> deque){
        int count=1;
        while(deque.size()!=0){
            int[] position=deque.poll();
            int x=position[0];
            int y=position[1];
            for(int i=0;i<4;i++){
                int new_x=x+direct[i];
                int new_y=y+direct[i+1];
                if(0<=new_x&&new_x<m&&0<=new_y&&new_y<n&&Math.abs(matrix[new_x][new_y]-matrix[x][y])<=1){//记得先判断边界值是否符合条件，再判断其它条件
                    if(!isVisited[new_x][new_y]){//只计算未访问过的元素
                        count++;
                        isVisited[new_x][new_y] = true;
                        deque.addFirst(new int[]{new_x, new_y});
                    }
                }
            }
        }
        return count;
    }
}
