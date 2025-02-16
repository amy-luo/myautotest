package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//多线段数据压缩，https://renjie.blog.csdn.net/article/details/134955491
//判断是否是一条直接，注意斜率，x相减为0的情况，求斜率要用double
public class DuoXianDuanShuJuYaSuo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> list = new ArrayList<>();
            double xielu=0;
            if(firstHang[2]!=firstHang[0]){//假定x相等，为-无穷，y相等时为0
                xielu=(double)(firstHang[3]-firstHang[1])/(double)(firstHang[2]-firstHang[0]);
            }else{
                xielu=Integer.MIN_VALUE;
            }
            list.add(firstHang[0]);
            list.add(firstHang[1]);
            for (int i = 2; i <=firstHang.length-4; i=i+2) {
                double nextXielu=0;
                if(firstHang[i+2]-firstHang[i]!=0){
                    //除法时要强制转换类型为double，不然int相除依然是int
                    nextXielu =(double)(firstHang[i + 3] - firstHang[i + 1]) / (double)(firstHang[i + 2] - firstHang[i]);
                }else{nextXielu=Integer.MIN_VALUE;}
                if(xielu!=nextXielu){
                  list.add(firstHang[i]);
                  list.add(firstHang[i+1]);
                  xielu=nextXielu;
                }
            }
            list.add(firstHang[firstHang.length-2]);
            list.add(firstHang[firstHang.length-1]);
            StringBuilder stb = new StringBuilder();
            for(Integer o:list){
                stb.append(o).append(" ");
            }
            System.out.println(stb.toString());


        }
    }

}
