package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//计算最接近的数,https://renjie.blog.csdn.net/article/details/131213852
//注意x+k-1超出了数组长度的情况，注意如果有多组要返回最大的i，所以要用<=;
public class JiSuanZuiJieJinDeShu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
              String s=in.nextLine();
            int k = Integer.valueOf(s.substring(s.length()-1));
            int[] dataArray = Arrays.stream(s.substring(1, s.length() - 3).split(",")).mapToInt(Integer::parseInt).toArray();
            int[] dataArray2 = Arrays.copyOf(dataArray,dataArray.length);
            Arrays.sort(dataArray2);
            int zhong=dataArray2[dataArray2.length/2];
            int jiejin=Integer.MAX_VALUE;
            int sum = dataArray[0];
            int index=0;
            for (int j = 1; j < k; j++) {
                sum-=dataArray[j];
            }
            for (int i = 1; i < dataArray.length; i++) {
                if(i+k-1<dataArray.length) {
                    sum += 2 * dataArray[i] - dataArray[i - 1] - dataArray[i + k - 1];
                }else{
                    sum += 2 * dataArray[i] - dataArray[i - 1];//如果x+k-1超出了数组长度，要考虑进来。
                }
                if(Math.abs(sum-zhong)<=jiejin) {//如果有多组要返回最大的i，所以要用<=;
                    jiejin = Math.abs(sum - zhong);
                    index=i;
                }
            }
            System.out.println(index);
        }
    }

}
