package com.mytest.ptbase.api.LTBai;

import java.util.*;

//跳格子2，https://renjie.blog.csdn.net/article/details/131007459
//动态规划
public class TiaoGeZi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] geZi = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m=geZi.length;

            ArrayList<Integer> list = new ArrayList<>();//存放不同跳法的得分
            int res1 = getMaxCount(geZi, 0, geZi.length - 2);
            int res2 = getMaxCount(geZi, 1, geZi.length - 1);

            System.out.println(Math.max(res1,res2));//输出最大得分
        }

    }
    private static int getMaxCount(int[] geZi,int start,int end){
        int prepre = geZi[start];
        int pre = Math.max(geZi[start],geZi[start+1]);
        for (int i = start+2; i <= end; i++) {
            int present=Math.max(prepre+geZi[i],pre);
            prepre=pre;
            pre=present;
        }
        return pre;
    }
}
