package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
//字符串子序列最大值
public class ZiXuLie {
    public int longestCommonSubsequence(String text1, String text2) {
            int m=text1.length()+1;//考虑0的情况，所以长度加1
            int n=text2.length()+1;
            int[][] dp=new int[m][n];//存储在i,j位置的字符串相等的最大值，记得画dp表，细细体会
            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);}
                }
            }
            return dp[m-1][n-1];
    }

    public static void main(String[] args){

        ZiXuLie z=new ZiXuLie();
        String text1="adsdfd";
        String text2="asdfd";
        System.out.println(z.longestCommonSubsequence(text1,text2));
    }


}
