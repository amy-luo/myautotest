package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//图论，二分查找法；广度优先搜索（bfs是使用deque来实现的，不是递归，栈空了就遍历完了。无需递归），LinkedList双向队列，智能驾驶，最少油量；
public class Bfs {

    public static int[] direct;
    public static int[][] matrix;
    public static int[][] maxFuel;

    public static void main(String[] args) {
        //linkedList是基于链表实现的，链表反序如下：
//        LinkedList<Integer> deque=new LinkedList<>();
//        deque.add(13);
//        deque.add(34);
//        deque.add(38);
//        deque.add(654);
//        System.out.println(JSONObject.toJSONString(deque));
//        int k=deque.size();
//        LinkedList<Integer> deque2=new LinkedList<>();
//        for(int i=0;i<k;i++){
//            deque2.addFirst(deque.poll());
//        }
//        System.out.println(JSONObject.toJSONString(deque2));

        Scanner in = new Scanner(System.in);

        String[] a = in.nextLine().split(" ");

        int m = Integer.valueOf(a[0]);//row
        int n = Integer.valueOf(a[1]);//col
//        System.out.println(m+" "+n+" ");
        ArrayList<Integer> list = new ArrayList<>();
        matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] s = in.nextLine().split(" ");
//            System.out.println(JSONObject.toJSONString(s));
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.valueOf(s[j]);
            }
        }
        direct = new int[]{0, 1, 0, -1, 0};//图中的坐标走向，i，i+1，4个走向
        int left = 0;
        int right = 100;
        int mid = 0;
        int result=-1;
        maxFuel=new int[m][n];
        //二分查找法
        while (left <=right) {//当左右指针相等时，遍历最后一个元素，左指针大于右指针时，结束查找
            mid = (left + right)/2;
            if (bfs(mid)) {
                result=mid;
                right=mid-1;//符合条件，缩小查找范围
            } else {
                left=mid+1;//不符合条件，缩小查找范围
            }
        }
        System.out.println(result);
    }

    public static boolean bfs(int mid) {
        //双向队列，有序存放当前走到的元素位置和当前位置的剩余燃油量
        LinkedList<int[]> deque = new LinkedList<>();
        if(matrix[0][0]==0){return false;}
        deque.offer(new int[]{0,0,matrix[0][0]==-1?100:mid-matrix[0][0]});
        for(int[] o:maxFuel){
            Arrays.fill(o,-1);
        }
        maxFuel[0][0]=mid-matrix[0][0];
        while (deque.size() > 0) {
//            System.out.println(JSONObject.toJSONString(deque));
            int[] p = deque.poll();
            int x = p[0];
            int y = p[1];
            int fuel = p[2];
            if (x == matrix.length-1 && y == matrix[0].length-1) {
                 return true;//找到了一条路径，此时队列中可能还有元素，但不需要走了，有一条走通就可以
            }
            //使用广度优先搜索遍历地图
            for (int i = 0; i < direct.length - 1; i++) {
                int nx = x + direct[i];
                int ny = y + direct[i + 1];
                int newFuel = fuel;
                if (0 <= nx && nx < matrix.length && 0 <= ny && ny < matrix[0].length && matrix[nx][ny] != 0) {
                    // 如果油量小于当前位置所需油量，无法通过当前位置，跳过
                    if (newFuel < matrix[nx][ny]) {
                        continue;
                    }else{
                        newFuel -= matrix[nx][ny];//计算当前位置剩余燃油量
                    }
                    if (-1 == matrix[nx][ny]) {
                        newFuel = 100;
                    }
                    // 如果到达新位置的油量大于之前记录的最大油量，更新最大油量并加入队列
                    if (newFuel>maxFuel[nx][ny]) {
                        maxFuel[nx][ny] = newFuel;
                        deque.offer(new int[]{nx, ny, newFuel});
                    }
                }
            }
        }
        return false;
    }
}
