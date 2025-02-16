package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//实力差距最小总和，https://renjie.blog.csdn.net/article/details/128807485
//笨办法,先排序，在差值大于d进行切割，分成前后两个list，那么每个list都不包含大于d的实力差距了。将前后差距都大于d的元素丢弃。
// 针对每个list进行差距求和并获取最小值（元素个数奇偶情况不同,奇数要去掉一个数再求差值和）。最终将所有最小值相加即可。
//上面这种方法放弃，还是用动态规划吧
public class ShiLiChaJvZuiXiaoZongHe2 {
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
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < m; i++) {//切割数组
                int preCha = i > 0 ? dataArray[i] - dataArray[i - 1] : d + 1;
                int afterCha = i < m - 1 ? dataArray[i + 1] - dataArray[i] : d + 1;
                if (preCha > d) {
                    if (!list2.isEmpty()) {
                        list.add(new ArrayList(list2));
                        list2.removeAll(list2);
                    }
                    if (afterCha > d) {
                        continue;//丢弃该元素
                    } else {
                        list2.add(dataArray[i]);//将该元素分到后面的list
                    }
                } else if (preCha <= d&&afterCha > d) {
                    list2.add(dataArray[i]);
                    if (!list2.isEmpty()) {
                        list.add(new ArrayList(list2));
                        list2.removeAll(list2);
                    }
                } else if (preCha <= d&&afterCha <= d) {
                    list2.add(dataArray[i]);
                }
            }
            int maxSum=0;
            for(ArrayList<Integer> list1:list){//分奇偶数求差值和。
                int sum=0;
                if(list1.size()%2==0){
                    for(int i=1;i<list1.size();i=i+2){
                        sum=sum+list1.get(i)-list1.get(i-1);
                    }
                }

                if(list1.size()%2==1){
                    for(int k=0;k<list1.size();k=k+2) {
                        ArrayList<Integer> list3 = new ArrayList<>(list1);
                        list3.remove(k);
                        int sum1=0;
                        for (int i = 1; i < list3.size(); i = i + 2) {
                                sum1 = sum1 + list3.get(i) - list3.get(i - 1);
                        }
                        if(sum==0){sum=sum1;}
                        sum = Math.min(sum1, sum);
                    }
                }
                maxSum+=sum;
            }
        System.out.println(maxSum==0?-1:maxSum);
        }
    }
}
