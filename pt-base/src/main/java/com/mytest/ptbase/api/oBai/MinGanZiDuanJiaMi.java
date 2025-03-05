package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//敏感字段加密，https://hydro.ac/d/HWOD2023/p/OD146
//遇到"就切换flag
public class MinGanZiDuanJiaMi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int k = Integer.valueOf(in.nextLine());
            String s = in.nextLine();
           boolean flag=true;
            ArrayList<String> list = new ArrayList<>();
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='\"'){
                    flag = !flag;}//遇到"就切换flag
                if(flag&&s.charAt(i)=='_'){
                    if(stb.length()!=0) {
                        list.add(stb.toString());
                        stb.setLength(0);
                    }
                }else{
                    stb.append(s.charAt(i));
                }
            }
            if(stb.length()!=0){list.add(stb.toString());}//记得加上最后一个字符串
            StringBuilder stb2 = new StringBuilder();
            for(int i=0;i<list.size();i++){
                String tmp=list.get(i);
                if(i==k){
                    tmp="******";
                }
                stb2.append(tmp+"_");
            }

            System.out.println(stb2.substring(0,stb2.length()-1));
        }
    }
}
