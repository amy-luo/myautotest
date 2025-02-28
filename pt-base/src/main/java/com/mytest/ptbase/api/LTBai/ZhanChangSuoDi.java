package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//战场索敌,https://renjie.blog.csdn.net/article/details/131205246,
// bfs,广度搜索，记住搜索过的区域。
//4 7 2
//..#EE#E
//E.#E.##
//###..#E
//E#E#E#.
public class ZhanChangSuoDi {
    public static String[][] matrix;
    public static int[] direct;
    public static boolean[][] isVisited;
    public static int m;
    public static int n;
    public static int k;
    public static int res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = firstHang[0];//row
            n = firstHang[1];//col
            k = firstHang[2];//col
            matrix=new String[m][n];
            isVisited=new boolean[m][n];
            for (int i = 0; i < m; i++) {
                String[] dataArray = in.nextLine().split("");
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=dataArray[j];
                }
            }
            direct = new int[]{0, 1, 0, -1, 0};
            res=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(!isVisited[i][j]&&!matrix[i][j].equals("#")) {
                        LinkedList<int[]> deque = new LinkedList<>();
                        deque.add(new int[]{i, j});
                        dfsFind(deque);
                    }
                }
            }
            System.out.println(res);
        }
    }
    private static void dfsFind(LinkedList<int[]> deque){
        int count=0;
        while(!deque.isEmpty()){
            int[] postition=deque.poll();
            int posx=postition[0];
            int posy=postition[1];
            if(matrix[posx][posy].equals("E")){
                count++;
                isVisited[posx][posy]=true;
            }
            for(int i=0;i<4;i++){
                int x=posx+direct[i];
                int y=posy+direct[i+1];
                if(0<=x&&x<m&&0<=y&&y<n&&!isVisited[x][y]){
                    if(matrix[x][y].equals("E")||matrix[x][y].equals(".")) {
                        deque.add(new int[]{x, y});
                    }
                    isVisited[x][y] = true;
                }
            }
        }
        if(count<k){res++;}
    }
}
