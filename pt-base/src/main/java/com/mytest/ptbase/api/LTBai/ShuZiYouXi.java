package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;

//数字游戏，https://renjie.blog.csdn.net/article/details/130957621
//对和求余，并存储在数组中，如果后续求和出现和前面求和相同的余数，那说明只要减去前面的求和余数，剩下的连续求和就能被m整除
public class ShuZiYouXi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(" ");
            int n = Integer.valueOf(s[0]);//row
            int m =  Integer.valueOf(s[1]);//col
            int[] s2=Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] yuAr=new int[m];//m被整除有m个余数
            int sumYu=0;
            int res=0;
            for (int i = 0; i < n; i++) {
                sumYu=(sumYu+s2[i])%m;
                if(sumYu==0||yuAr[sumYu]!=0){
                    res=1;
                    break;
                }
                yuAr[sumYu]++;
            }
            System.out.println(res);
        }
    }
}
