package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;

//求数组的最大连续子序合；
public class MaxZiShuZuHe {
    public int maxSubArray(int[] nums) {
        int m=nums.length+1;
        int[][] dp=new int[m][m];
        for(int i=1;i<m;i++){
            for(int j=1;j<=i;j++){
                int max=presentMax(nums,i-1,j);
                dp[i][1]=nums[i-1];
                dp[i][0]=nums[0];
                dp[0][j]=nums[0];
                dp[0][0]=nums[0];
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i][j-1]);
                dp[i][j]=Math.max(dp[i][j],max);
                if(j<=i-1){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
            }
        }
        return dp[m-1][m-1];

    }

    public static int presentMax(int[] nums,int index,int j){
        int sum=0;
        int max=nums[index];
        for(int row=1;row<=j;row++){
            sum=sum+nums[index-row+1];
            if(max<sum){
                max=sum;}
        }
//        System.out.println(max);
        return max;
    }

    public static void main(String[] args){
        MaxZiShuZuHe z=new MaxZiShuZuHe();
        int [] nums = {-57,9,-72,-69,-48,1,87,48};
        int sum=z.maxSubArray(nums);
        System.out.println(sum);
    }

    //最大子序合，算法太强了，看半天才理解
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
