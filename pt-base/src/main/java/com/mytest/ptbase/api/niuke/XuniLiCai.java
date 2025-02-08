package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class XuniLiCai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] a=in.nextLine().split(" ");

        int n=Integer.valueOf(a[0]);//总产品数
        int qian=Integer.valueOf(a[1]);//总投资额
        int fengxianZ=Integer.valueOf(a[2]);//总风险
        System.out.println(n+" "+qian+" "+fengxianZ);
        Integer maxE=0;
        ArrayList<Integer> list=new ArrayList<>();
        String[] chanpin=new String[n];
        String[] fengxian=new String[n];
        String[] touzie=new String[n];
        int count=0;
        while(in.hasNextLine()&&count<3) {
            if(count==0){chanpin = in.nextLine().split(" ");}
            if(count==1){fengxian = in.nextLine().split(" ");}
            if(count==2){touzie = in.nextLine().split(" ");}
            count++;
        }
        Integer[] touzihuibao=new Integer[n];
        for(int i=0;i<n;i++){
            touzihuibao[i]=Integer.valueOf(chanpin[i])*Integer.valueOf(touzie[i]);
        }
        //选一个产品的情况
        for(int i=0;i<n;i++){
            if(Integer.valueOf(fengxian[i])<=Integer.valueOf(fengxianZ)&&Integer.valueOf(touzie[i])<=qian) {
                if (touzihuibao[i] > maxE) {
                    list.removeAll(list);
                    list.add(i);
                    maxE = touzihuibao[i];
                }
            }
        }
        //选两个产品的情况
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int fx=Integer.valueOf(fengxian[i])+Integer.valueOf(fengxian[j]);
                int tzhb=touzihuibao[i]+touzihuibao[j];
                int toue=Integer.valueOf(touzie[i])+Integer.valueOf(touzie[j]);
                if(fx<=Integer.valueOf(fengxianZ)&&toue<=qian) {
                    if(tzhb>maxE){
                        list.removeAll(list);
                        list.add(i);
                        list.add(j);
                        maxE = tzhb;
                    }
                }
            }
        }
        StringBuilder stb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(list.contains(i)){
                stb.append(touzie[i]+" ");
            }else stb.append("0 ");
        }
        System.out.println(stb.toString());
    }
}
