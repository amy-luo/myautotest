package com.mytest.ptbase.api.LTBai;

import java.util.*;

//最少数量线段覆盖，linkedlist模拟过程，先排序，每次拿3个元素进行比对
//https://fcqian.blog.csdn.net/article/details/128159052
public class ZuiShaoShuLiangXianDuanFuGai {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = Integer.valueOf(s);
            LinkedList<int[]> linkedList = new LinkedList<>();//元素队列
            LinkedList<int[]> linkedList2 = new LinkedList<>();//结果队列
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
                linkedList.addLast(new int[]{dataArray[0],dataArray[1]});
            }
            Collections.sort(linkedList, Comparator.comparing(o->o[0]));
            int[] tmp1=linkedList.pollFirst();
            linkedList2.addLast(tmp1);//先拿出第一个元素
            for (int i = 1; i < m; i++) {
                if(i==m-1){//最后一个元素特殊处理
                    int[] tmp2=linkedList.pollFirst();
                    if(tmp1[1]<tmp2[1]){
                        linkedList2.addLast(tmp2);
                    }
                }else {
                    int[] tmp2 = linkedList.pollFirst();
                    int[] tmp3 = linkedList.pollFirst();
                    int x1 = tmp1[0];
                    int y1 = tmp1[1];
                    int x2 = tmp2[0];
                    int y2 = tmp2[1];
                    int x3 = tmp3[0];
                    int y3 = tmp3[1];
                    boolean isFugai = false;
                    if (y1 >= y2) {//1全覆盖2
                        isFugai = true;
                    }
                    if (x3 == x2 && y2 <= y3) {//3全覆盖2
                        isFugai = true;
                    }
                    if (y1 >= x3) {//1和3的集合全覆盖2
                        isFugai = true;
                    }
                    if (!isFugai) {//如果不能覆盖，那么更新tmp1的值，更新后要入栈
                        tmp1 = tmp2;
                        linkedList2.addLast(tmp1);
                    }
                    linkedList.addLast(tmp3);//将tmp3的值加回元素队列
                }
            }

            System.out.println(linkedList2.size());
        }
    }

}
