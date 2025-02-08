package com.mytest.ptbase.api.niuke;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
//滑窗：可获得的最大点数，逆向思维，求滑动数组的最小和。
//几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
//
//        每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
//
//        你的点数就是你拿到手中的所有卡牌的点数之和。
//
//        给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
//
//
//
//        示例 1：
//
//        输入：cardPoints = [1,2,3,4,5,6,1], k = 3
//        输出：12
//        解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
public class GetKaPaiPointsMax {
    public int maxScore(int[] cardPoints, int k) {
        int sumMax=0;
        int he=Arrays.stream(cardPoints).sum();
        int sumMin=0;
        int sumHua=0;
        if(k==0){sumMax=0;return sumMax;}
        if(k==cardPoints.length){sumMax=he;return sumMax;}
        if(k>cardPoints.length){return 0;}
        if(k==1){sumMax=Math.max(cardPoints[0],cardPoints[cardPoints.length-1]);return sumMax;}
        for(int i=0;i<=cardPoints.length-k-1;i++){
            sumMin+=cardPoints[i];
        }
        sumHua=sumMin;
        System.out.println(sumMin);
        for(int i=1;i<=k;i++){  //数组前面取i个数，后面取k-i个数；
            sumHua=sumHua+cardPoints[cardPoints.length-k+i-1]-cardPoints[i-1];
            sumMin=Math.min(sumMin,sumHua);
            System.out.println("滑动和: "+sumHua);
            System.out.println("最小和: "+sumMin);
        }
        return he-sumMin;
    }

}
