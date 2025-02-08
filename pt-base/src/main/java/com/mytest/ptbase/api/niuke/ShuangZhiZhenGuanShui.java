package com.mytest.ptbase.api.niuke;

public class ShuangZhiZhenGuanShui {
    public int maxArea(int[] height) {
        int n=height.length;
        int sum=0;
        int i=0;
        int j=n-1;
        while(i<j){
            int s=(j-i)*Math.min(height[j],height[i]);
            sum=Math.max(sum,s);
            if(height[i]<=height[j]){
                i++;
            }else{j--;}
        }
        return sum;

    }
}
