package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//喊七的次数重排,https://renjie.blog.csdn.net/article/details/130794502
//不用管输入顺序，输入数组表示：总计喊多少次7，输入数组长度表示总共多少人。推算分别由编号多少喊出来的。存入以序号为索引的数组中，值是喊7的次数。
public class Han7deCiShuChongPai {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m=Arrays.stream(dataArray).sum();
            int n=dataArray.length;
            int[] res = new int[n+1];
            int count=0;
            for (int i = 1;; i++) {
                if(i%7==0||String.valueOf(i).contains("7")){
                    res[i%n]++;
                    count++;
                }
                if(count==m){break;}
            }
            StringBuilder stb = new StringBuilder();
            for(int i=1;i<=n;i++){
                stb.append(res[i] + " ");
            }
            System.out.println(stb.toString());
        }
    }

}
