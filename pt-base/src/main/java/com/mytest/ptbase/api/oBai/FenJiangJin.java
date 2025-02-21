package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//分奖金,https://renjie.blog.csdn.net/article/details/128420175
//过程模拟，两层for循环
public class FenJiangJin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                boolean flag=false;
                for (int j = i+1; j < m; j++) {
                    if(dataArray[i]<dataArray[j]){
                        flag=true;
                        list.add((dataArray[j]-dataArray[i])*(j-i));
                        break;
                    }
                }
                if(!flag){list.add(dataArray[i]);}
            }
            for(Integer o:list){
                System.out.print(o+" ");
            }
        }
    }

}
