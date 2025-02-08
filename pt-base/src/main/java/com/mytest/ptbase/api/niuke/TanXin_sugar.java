package com.mytest.ptbase.api.niuke;

import java.util.Arrays;

public class TanXin_sugar {
        public int candy(int[] ratings) {
            int sum=0;
            int[] sugar=new int[ratings.length];

//从右往左遍历；
            sugar[ratings.length-1]=1;
            sugar[0]=1;
            for(int i=ratings.length-1;i>=1;i--){
                if(ratings[i-1]>ratings[i]){
                    sugar[i-1]=sugar[i]+1;
                }else{sugar[i-1]=1;}

            }
//   从左往右遍历
            int x=1;
            for(int i=0;i<ratings.length-1;i++){
                if(ratings[i+1]>ratings[i]){
                    x++;
                }else{x=1;}
                sugar[i+1]=Math.max(sugar[i+1],x);
                sum+=sugar[i+1];
            }
            sum+=sugar[0];

            int sum2= Arrays.stream(sugar).sum();//数组求和
            int min=Arrays.stream(sugar).min().getAsInt();//数组求最大值
            return sum;
        }
}
