package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//比赛，https://renjie.blog.csdn.net/article/details/130855540
//数组排序，统计每个参赛者每个分数的个数，总分，编号，放到一个数组进行自定义排序
public class BiSai {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(",");
            int m = Integer.valueOf(s[0]);
            int n = Integer.valueOf(s[1]);
            matrix=new int[m][n];
            isVisited=new boolean[m][n];
            int[] sum = new int[n];
            int[][] fenshu = new int[n][12];
            int res=-1;
            for (int i = 0; i < m; i++) {
                String str=in.nextLine();
                if(str.equals("")){System.out.println(-1);return;}
                int[] dataArray = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
                if(dataArray.length<n){System.out.println(-1);return;}
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=dataArray[j];
                    sum[j] += matrix[i][j];
                    fenshu[j][0]=sum[j];
                    fenshu[j][matrix[i][j]]++;
                    fenshu[j][11]=j+1;

                    if(matrix[i][j]<0||matrix[i][j]>10){
                        {System.out.println(-1);return;}
                    }
                }
            }

                Arrays.sort(fenshu, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o2[0]==o1[0]) {
                            for (int i = 10; i >= 1; i--) {
                                if (o2[i] == o1[i]) {
                                    i--;
                                } else {
                                    return o2[i] - o1[i];
                                }
                            }
                        }
                        return o2[0]-o1[0];
                    }
                });
            StringBuilder stb = new StringBuilder();
            for(int i=0;i<3;i++){
                stb.append(fenshu[i][11] + ",");
            }
            System.out.println(stb.substring(0,stb.length()-1));
        }
    }

}
