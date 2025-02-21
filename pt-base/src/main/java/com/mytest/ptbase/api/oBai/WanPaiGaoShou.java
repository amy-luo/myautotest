package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;
//玩牌高手,https://renjie.blog.csdn.net/article/details/128153814
public class WanPaiGaoShou {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int m = dataArray.length;//row
            int[] sum=new int[m];
            sum[0] = dataArray[0];
            for (int i = 1; i < m; i++) {
                if(i==1||i==2){sum[i] = Math.max(0, sum[i - 1] + dataArray[i]);}
                if(i>=3) {
                    sum[i] = Math.max(sum[i - 3], sum[i - 1] + dataArray[i]);
                }
            }
            System.out.println(sum[m-1]);
        }
    }
}
