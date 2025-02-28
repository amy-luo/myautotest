package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//Wonderland游乐园,一维动态规划，https://renjie.blog.csdn.net/article/details/135497003
public class WonderlandYouLeYuan {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int[] piaoJia = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] riQi = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] dp=new int[366];
            Arrays.fill(dp,Integer.MAX_VALUE);//给dp填充最大值，因为后面要取dp的最小值
            dp[0]=0;
            int j=0;
          Integer[] newRiQi = new Integer[riQi.length];
            for(int i=0;i<riQi.length;i++){
                newRiQi[i]=riQi[i];
            }
            ArrayList<Integer> list= new ArrayList<>(Arrays.asList(newRiQi)) ;
            for (int i = 1; i <= 365; i++) {
//            for (int j=0;j<riQi.length;j++) {//不能用循环
//                if(j<riQi.length&&riQi[j]==(i)){
                if(list.contains(i)){
                    dp[i]=Math.min(dp[i],dp[Math.max(0,i-1)]+piaoJia[0]);
                    dp[i]=Math.min(dp[i],dp[Math.max(0,i-3)]+piaoJia[1]);
                    dp[i]=Math.min(dp[i],dp[Math.max(0,i-7)]+piaoJia[2]);
                    dp[i]=Math.min(dp[i],dp[Math.max(0,i-30)]+piaoJia[3]);
                    j++;
                }else{dp[i]=dp[i-1];}
//            }
            }

        System.out.println(dp[365]);
//
        }
    }
}
