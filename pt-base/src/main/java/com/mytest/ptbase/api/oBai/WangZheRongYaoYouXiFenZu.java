package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//王者荣耀游戏分组，https://renjie.blog.csdn.net/article/details/134767643
//从最小偏差起，逐渐拉大偏差，总和减去偏差需要能除2余0，不然就不存在这种偏差。递归回溯看是否满足条件
public class WangZheRongYaoYouXiFenZu {
    public static int[] dataArray;
    public static boolean[] isVisited;
    public static int m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = dataArray.length;//row
            int sum=Arrays.stream(dataArray).sum();
            for (int cha = 0; cha < sum; cha++) {//差值cha
                if((sum-cha)%2==0){
                    isVisited = new boolean[m];
                    if(checkXing((sum-cha)/2,0,0,isVisited)){
                        System.out.println(cha);
                        break;
                    }
                }
            }
        }
    }
    private static boolean checkXing(int he,int count,int index,boolean[] isVisited){
        if(index>m/2||count>he){//索引大于m/2，和超过了he，就返回false，没必要再递归了。
            return false;
        }
        if(index==m/2){
            if(count==he) {
                return true;
            }
        }{
            for(int i=0;i<m;i++){
                if(!isVisited[i]) {
                    count += dataArray[i];
                    isVisited[i] = true;
                    if(checkXing(he, count, index + 1, isVisited)){
                        return true;//找到了第一个true，就立即返回结果，没必要再继续递归查找了
                    }
                    count -= dataArray[i];
                    isVisited[i] = false;
                }
            }
        }
        return false;
    }
}
