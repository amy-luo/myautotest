package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//最佳升级时间窗,https://renjie.blog.csdn.net/article/details/143975268
//找用户量的最小值，但要大于容忍值，在此基础上再找跨度最长的时间窗口。
//滑动窗口。
//6
//1 2 3 4 5 6 7 8 9 10 12 3 5 2 1 4 33 1 2 1 2 1 3 2 1 2 43 5 3 2 3 76 3 2 1 1 1 2 1 11
//34 38
//6
//1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 11 12 12
//22 25
public class ZuiJiaShiJianChuang {
    public static int[] dataArray;
    public static int k;
    public static int m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            k =Integer.valueOf(in.nextLine());
            dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = dataArray.length;
            int minYongHu=Integer.MAX_VALUE;
            int sum=0;
            int[] index=new int[]{0,0};
            //滑动窗口，i是左指针，j是右指针。j先滑，>=k时停下，i右滑，<k时，i停下，j右滑。
            for (int i = 0,j = 0; i <m&&j < m;) {
                sum += dataArray[j];
                if(j-i+1>7*24){
                    i++;
                    sum = sum - dataArray[i]-dataArray[j];
                    continue;
                }
                if(sum>=k){
                    if(sum<minYongHu){//尽量求得最小的用户数
                        minYongHu=sum;
                        index[0]=i;
                        index[1]=j;
                    }else if(sum==minYongHu){
                        if(j-i>index[1]-index[0]){//保证用户数最小的时候，求得最大的持续小时数
                            index[0]=i;
                            index[1]=j;
                        }
                    }
                    sum = sum - dataArray[i]-dataArray[j];//准备i++，先减去i元素的值。
                    i++;//sum更新完后再i++，注意，不然i++后，i元素的值已经变了，减去的不是原来那个了。
                    continue;
                }else{j++;}
            }
            System.out.println(index[0]+" "+index[1]);
        }
    }

}
