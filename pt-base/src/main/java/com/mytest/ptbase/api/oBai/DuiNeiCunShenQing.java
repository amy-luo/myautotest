package com.mytest.ptbase.api.oBai;

import java.util.*;

//堆内存申请,https://renjie.blog.csdn.net/article/details/135324732
//循环遍历，找到内存匹配的最小值，将其靠近左侧已使用内存的索引输出。
public class DuiNeiCunShenQing {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.valueOf(in.nextLine());//row
        ArrayList<int[]> list = new ArrayList<>();
        while (in.hasNextLine()) {
            String s1=in.nextLine();
            if(s1.equals("")){break;}
            String[] s=s1.split(" ");
            list.add(new int[]{Integer.valueOf(s[0]), Integer.valueOf(s[0]) + Integer.valueOf(s[1])});
        }
        Collections.sort(list, Comparator.comparingInt(o->o[0]));
        int lastIndex=0;
        int resultIndex=-1;
        int minNeiCun=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            if((list.get(i)[0]-lastIndex)>=k) {
                if (list.get(i)[0] - lastIndex < minNeiCun) {
                    minNeiCun = list.get(i)[0] - lastIndex;
                    resultIndex = lastIndex;
                }
            }
            lastIndex=list.get(i)[1];
        }
        if(100-lastIndex>=k&&100-lastIndex<minNeiCun){
            minNeiCun = 100 - lastIndex;
            resultIndex=lastIndex;}
        System.out.println(resultIndex);
    }

}
