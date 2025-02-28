package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//周末爬山,dfs
// 查最高的山，在最高的山的基础上再找最短路径。
// 需要依赖整个一条路径每个的值，对后面统计结果产生影响，所以要用dfs。 bfs不可行，无法统计出最高的山。
//https://renjie.blog.csdn.net/article/details/131947758
//5 4 1
//0 1 2 3
//8 7 6 3
//7 4 5 2
//6 3 2 1
//6 7 8 9
//res:9 19
public class ZhouMoPaShan {
    public static int[][] matrix;
    public static int[] direct;
    public static boolean[][] isVisited;
    public static int m;
    public static int n;
    public static int k;
    public static int maxShanRes;
    public static int minCountRes;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            m = Integer.valueOf(s[0]);//row
            n = Integer.valueOf(s[1]);//col
            k = Integer.valueOf(s[2]);//col
            matrix = new int[m][n];
            isVisited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = dataArray[j];
                }
            }
            direct = new int[]{0, 1, 0, -1, 0};
            isVisited[0][0] = true;
            maxShanRes=0;//记得初始化，总是忘了
            minCountRes=0;//记得初始化，总是忘了
            dfsFind(0, 0, Integer.MAX_VALUE, 0, 0);
            System.out.println(maxShanRes+" "+minCountRes);
        }
    }

    private static void dfsFind(int x, int y, int minCount, int count, int maxShan) {
        boolean flag=false;//用来判断是否这条路已经爬到终点了。
        for (int pos = 0; pos < 4; pos++) {
            int new_x = x + direct[pos];
            int new_y = y + direct[pos + 1];
            if (0 <= new_x & new_x < m && 0 <= new_y && new_y < n && !isVisited[new_x][new_y]
                    && Math.abs(matrix[new_x][new_y] - matrix[x][y]) <= k) {
                flag=true;//说明未到终点。
                count++;//计算当前步数
                isVisited[new_x][new_y] = true;
                int maxShan2 = Math.max(maxShan, matrix[new_x][new_y]);//出现了更高的山
                int minCount2 = 0;
                if (matrix[new_x][new_y] > maxShan) {
                    minCount2 = count;//如果出现了更高的山，要更新最小步数。
                }
                dfsFind(new_x, new_y, minCount2, count, maxShan2);
                count--;
                isVisited[new_x][new_y] = false;
            }
        }
        if(!flag){//flag为false，终点，更新最高山和最短路径
            if(maxShan>maxShanRes){
                maxShanRes=maxShan;
                minCountRes = minCount;
            }else if(maxShan==maxShanRes){
                minCountRes = Math.min(minCountRes, minCount);
            }
        }
    }
}
