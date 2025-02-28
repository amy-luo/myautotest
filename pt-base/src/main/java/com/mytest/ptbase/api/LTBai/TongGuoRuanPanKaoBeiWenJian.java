package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;

//通过软盘拷贝文件，https://renjie.blog.csdn.net/article/details/130921622
//动态规划
public class TongGuoRuanPanKaoBeiWenJian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int kuai=1474560/512;//总容量时多少块
        while (in.hasNextLine()) {
            int n=in.nextInt();
            int[] wenjian = new int[n];
            for (int i = 0; i < n; i++) {
                wenjian[i]=in.nextInt();
            }

            int[][] dp = new int[kuai+1][n+1];//容量为i块时，包含j或不包含j时候的，存储的最大字节数
            dp[0][0]=0;
            dp[1][0]=0;
            dp[0][1]=0;
            for(int i=1;i<kuai+1;i++) {
                for (int j = 1; j < n + 1; j++) {
                    int zhankuai =(int)Math.ceil(wenjian[j-1]/512.0);//当前j文件所占用的块数，向上取整。
                    if(i >=zhankuai) {
                        dp[i][j] = Math.max(dp[i - zhankuai][j - 1] + wenjian[j-1], dp[i][j - 1]);
                    }else{dp[i][j] = dp[i][j - 1];}
                }
            }
            System.out.println(dp[kuai][n]);
        }
    }
}
