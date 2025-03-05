package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//数组连续和,https://renjie.blog.csdn.net/article/details/130753142
//前缀和的方法
public class ShuZuLianXuHeZu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int m = Integer.valueOf(s[0]);
            int x = Integer.valueOf(s[1]);
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] preSum = new int[m];
            preSum[0] = dataArray[0];
            int count = 0;
            if(preSum[0]>=x){count++;}
            for (int i = 1; i < m; i++) {
                preSum[i] = preSum[i - 1] + dataArray[i];
                if (preSum[i] >= x) {
                    count++;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = i; j < m; j++) {
                    int sum = preSum[j] - preSum[i - 1];
                    if (sum >= x) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
