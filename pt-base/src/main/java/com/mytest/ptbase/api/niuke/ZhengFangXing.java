package com.mytest.ptbase.api.niuke;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Math.pow;

//数组排序，
//给一串非负整数，重新排序后，返回一个最大数
public class ZhengFangXing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        if(n<4){System.out.println(0);}
        int[][] points = new int[n][2];
        for (int i = 0; in.hasNextLine() && i < n; i++) {
            String[] a = in.nextLine().split(" ");
            points[i][0] = Integer.valueOf(a[0]);
            points[i][1] = Integer.valueOf(a[1]);
        }
        int count=0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int m = k + 1; m < n; m++) {
                        int[][] lin=new int[4][2];
                        lin[0]=points[i];
                        lin[1]=points[j];
                        lin[2]=points[k];
                        lin[3]=points[m];
                        boolean b=isZheng(lin);
                        if(b){
                            count++;
                        }
                    }

                }

            }

        }

        System.out.println(count);
    }

    public static boolean isZheng(int[][] points){
        int len=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<4;i++){
            for(int j=i+1;j<4;j++) {
                int x= points[i][0]-points[j][0];
                int y= points[i][1]-points[j][1];
                int chang =(int)Math.pow(x,2) + (int)Math.pow(y,2) ;
                len = chang;
                map.put(chang, map.getOrDefault(chang, 0) + 1);
            }
        }
        return map.size()==2&&(map.get(len)==2||map.get(len)==4);
    }
}
