package com.mytest.ptbase.api.niuke;

import java.util.*;

//计算boss的最大收入，从低级向高级计算，数组排序，本题没用到Arrays.sort(matrix,(a, b)->b[1]-a[1]);
public class BossShouRu {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int N = Integer.valueOf(in.nextLine());
        HashMap<Integer,Integer> map=new HashMap<>();;
        int[][] data=new int[5][N];
        for(int i=0;i<N;i++){
            String[] s=in.nextLine().split(" ");
            for(int j=0;j<3;j++){
                data[i][j]=Integer.valueOf(s[j]);
            }
            map.put(Integer.valueOf(s[0]),data[i][2]);
            }

        int count=0;
        for(int i=0;i<N;i++){
            if(map.keySet().contains(data[i][1])){
                int newdata=map.get(data[i][1]) + 15 * (data[i][2] / 100);
                map.put(data[i][1],newdata);
            }
        }
        int bossId=-1;
        for(int i=0;i<N;i++){
            if(!map.keySet().contains(data[i][1])){
                bossId=data[i][1];
                count+=15*(data[i][2]/100);
            }
        }
//        int sum=map.values().stream().mapToInt(Integer::intValue).sum();//不对，值没有除以100乘以15

        System.out.println(bossId+" "+count);
    }
}
