package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//发广播，服务器广播，遍历元素，记录发的次数，并记录互发广播后的状态，对于已收到广播的站点不需要再发广播了。
//https://renjie.blog.csdn.net/article/details/128497040
//A和B直接连接，B和C直接连接，则A和C间接连接。直接连接和间接连接都可以发送广播。
public class FaGuangBo {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        ArrayList<int[]> dataList = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.equals("")) {
                break;
            }
            int[] firstHang = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            dataList.add(firstHang);
        }
        int m = dataList.size();
        boolean[] isVisited = new boolean[m];
        int count=0;
        for(int i=0;i<m;i++){
            if(isVisited[i]==false){
                count++;
                isVisited[i]=true;
            }
            for(int j=i+1;j<m;j++){
                if(dataList.get(i)[j]==1){
                    isVisited[j]=true;
                }
            }
        }
        System.out.println(count);

        }
    }

