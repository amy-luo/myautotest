package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//实力差距最小总和，https://renjie.blog.csdn.net/article/details/128807485
//（不可取）笨办法,先排序，在差值大于d进行切割，分成前后两个list，那么每个list都不包含大于d的实力差距了。将前后差距都大于d的元素丢弃。
// 针对每个list进行差距求和并获取最小值（元素个数奇偶情况不同,奇数要去掉一个数再求差值和）。最终将所有最小值相加即可。
//上面这种方法放弃，还是用动态规划吧.用动态规划最简单。
//动态规划，在取得最大对的时候，取得物理差值最小和。能取最大对时，武力值和一定要基于最大对。
public class ShiLiChaJvZuiXiaoZongHe {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] dataArray1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = dataArray1[0];//row
            int d = dataArray1[1];//col
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(dataArray);//排序
            int[] dpDuiMax=new int[m+1];
            int[] dpHeMin=new int[m+1];
            dpDuiMax[0]=0;
            dpHeMin[0]=0;
            dpDuiMax[1]=0;
            dpHeMin[1]=0;
            for (int i = 2; i < m+1; i++) {
                boolean flag=false;
                if(dataArray[i-1]-dataArray[i-2]<=d){
                    flag = true;//满足差距d时
                }
                if(flag) {//满足差距d时，可取第i个元素
                    dpDuiMax[i] = Math.max(dpDuiMax[i - 1], dpDuiMax[i - 2] + 1);
                    if(dpDuiMax[i - 2] + 1>dpDuiMax[i - 1]){//新的元素能多增加一个武力对
                        dpHeMin[i]=dpHeMin[i-2]+dataArray[i-1]-dataArray[i-2];//能取最大武力对时，武力值和一定要基于最大武力对。
                    }else{//新的元素不能多增加一个武力对
                        dpHeMin[i]=Math.min(dpHeMin[i-1],dpHeMin[i-2]+dataArray[i-1]-dataArray[i-2]);
                    }
                }else{//不满足差距d时，不取第i个元素
                    dpDuiMax[i] = dpDuiMax[i - 1];
                    dpHeMin[i] = dpHeMin[i - 1];
                }
            }
        System.out.println(dpHeMin[m]==0?-1:dpHeMin[m]);
        }
    }
}
