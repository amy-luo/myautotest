package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Scanner;

//【羊、狼、农夫过河】https://renjie.blog.csdn.net/article/details/128052100
public class LangYangGuoHe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String[] a=in.nextLine().split(" ");
            Integer[] b = transfer(a);
            int M = b[0];
            int N = b[1];
            int X = b[2];
            int sum=0;
            if(M>N-X&&M+N<=2*X){sum=2;}//先过去X只狼，剩下的M>N-X,且M+N-X要小于船的容量X
            if(M+N<=X){sum=1;}//羊+狼总数小于船的容量
            if(M<=X&&N<=X&M+N>X){sum=2;}//羊小于船容量，狼小于船容量，
            if(M>N+1&&M+N-1<=3*X){sum=3;}//先过X-1只狼，再过X只羊，再一起过
            for(int i=0;i<9999999;i++){
                if(X%2==0&&(M-i*X/2)>(N-i*(X/2-1))&&(M+N-i*X+i)<=X){sum=i+1;break;}//每次船上的羊的数量=狼的数量+1，船容量区分奇偶数，过河后剩下的羊的数量要大于狼的数量
                else if(X%2==1&&(M-i*(X+1)/2)>(N-i*(X-1)/2)&&(M+N-i*X)<=X){sum=i+1;break;}//同上，奇数
            }
            System.out.println(sum);
        }
    }

    public static Integer[] transfer(String[] a){
        Integer b[]=new Integer[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.valueOf(a[i]);
        }
        return b;
    }
}
