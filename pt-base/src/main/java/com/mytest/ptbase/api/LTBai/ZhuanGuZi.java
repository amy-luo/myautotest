package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//转骰子，https://renjie.blog.csdn.net/article/details/130786769
public class ZhuanGuZi {
    public static int[][] fangwei;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            fangwei=new int[][]{{1,2},{3,4},{5,6}};//左右，前后，上下
            String shuru = in.nextLine();

            for (int i = 0; i <shuru.length(); i++) {
                zhuanGuZi(shuru.charAt(i));
            }
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i <3; i++) {
                for (int j = 0; j <2; j++) {
                    stb.append(fangwei[i][j]);
                }
            }
            System.out.println(stb.toString());
        }
    }
//    fangwei=new int[][]{{1,2},{3,4},{5,6}};//左右，前后，上下
    private static void zhuanGuZi(char type){//'L','R','F','B','A','C'
        if(type=='L'){
            int[] zuoyou=fangwei[2];
            int[] shangxia=new int[]{fangwei[0][1],fangwei[0][0]};
            fangwei[0]=zuoyou;
            fangwei[2]=shangxia;
        }
        if(type=='R'){
            int[] zuoyou=new int[]{fangwei[2][1],fangwei[2][0]};
            int[] shangxia=fangwei[0];
            fangwei[0]=zuoyou;
            fangwei[2]=shangxia;
        }
        if(type=='F'){
            int[] qianhou=fangwei[2];
            int[] shangxia=new int[]{fangwei[1][1],fangwei[1][0]};
            fangwei[1]=qianhou;
            fangwei[2]=shangxia;
        }
        if(type=='B'){
            int[] qianhou=new int[]{fangwei[2][1],fangwei[2][0]};
            int[] shangxia=fangwei[1];
            fangwei[1]=qianhou;
            fangwei[2]=shangxia;
        }
        if(type=='A'){
            int[] qianhou=fangwei[0];
            int[] zuoyou=new int[]{fangwei[1][1],fangwei[1][0]};
            fangwei[0]=zuoyou;
            fangwei[1]=qianhou;
        }
        if(type=='C'){
            int[] qianhou=new int[]{fangwei[0][1],fangwei[0][0]};
            int[] zuoyou=fangwei[1];
            fangwei[0]=zuoyou;
            fangwei[1]=qianhou;
        }
    }

}
