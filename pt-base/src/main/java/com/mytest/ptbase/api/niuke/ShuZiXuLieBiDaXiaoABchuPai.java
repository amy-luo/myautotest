package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//AB出牌，求A赢得B的最大点数https://renjie.blog.csdn.net/article/details/131380684
public class ShuZiXuLieBiDaXiaoABchuPai {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        String[] a = in.nextLine().split(" ");

        int m = Integer.valueOf(a[0]);//row
        String[] b = in.nextLine().split(" ");
        String[] c = in.nextLine().split(" ");
        Integer[] pa=transfer(b);
        Integer[] pb=transfer(c);
        Arrays.sort(pa,(o1,o2)->o2-o1);
        Arrays.sort(pb,(o1,o2)->o2-o1);
        ArrayList<Integer> lista=new ArrayList<>();
        ArrayList<Integer> listb=new ArrayList<>();
        int count=0;
        boolean flag=false;
        for(int i=0;i<m;i++){
            if(lista.contains(i)){continue;}
            int[] deng=new int []{-1,-1};//记录相等的i，j
            int[] xiao=new int []{-1,-1};//记录小于时的最大if
            for(int j=0;j<m;j++){
                if(listb.contains(j)){continue;}
                if(pa[i]>pb[j]){
                    count++;
                    lista.add(i);
                    listb.add(j);
                    flag=true;
                    break;
                }else if(pa[i]==pb[j]) {
                    if(deng[0]==-1&deng[1]==-1) {
                        deng[0] = (i);
                        deng[1] = (j);
                        continue;
                    }
                }
                else if(pa[i]<pb[j]) {
                    if(xiao[0]==-1&xiao[1]==-1) {
                        xiao[0] = (i);
                        xiao[1] = (j);
                        continue;
                    }
                }
            }
            if(!flag) {
                lista.add(i);
                if(deng[0]!=-1&deng[1]!=-1) {
                    listb.add(deng[1]);
                }else{
                    listb.add(xiao[1]);
                    count--;}
            }
            flag=false;
        }
        System.out.println(count);
    }

    public static Integer[] transfer(String[] a){
        Integer b[]=new Integer[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.valueOf(a[i]);
        }
        return b;
    }
}
