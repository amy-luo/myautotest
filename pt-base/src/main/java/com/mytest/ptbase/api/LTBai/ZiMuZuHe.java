package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//过滤组合字符串,字符串组合+过滤，https://renjie.blog.csdn.net/article/details/128025836
//递归回溯
public class ZiMuZuHe {
    public static HashMap<Integer,String> map;
    public static ArrayList<String> list;
    public static String firstHang;
    public static String pingbi;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        map=new HashMap<>();
        map.put(0, "abc");
        map.put(1, "def");
        map.put(2, "ghi");
        map.put(3, "jkl");
        map.put(4, "mno");
        map.put(5, "pqr");
        map.put(6, "st");
        map.put(7, "uv");
        map.put(8, "wx");
        map.put(9, "yz");

        while (in.hasNextLine()) {
             firstHang=in.nextLine();
             pingbi=in.nextLine();
            StringBuilder stb=new StringBuilder();
            list=new ArrayList<>();
            diguihuifu(0,stb);
            for(String o:list){
                for(char c:pingbi.toCharArray()){
                    if(!o.contains(String.valueOf(c))){
                        stb.append(o).append(",");
                        break;
                    }
                }

            }
            System.out.println(stb.toString());
        }
    }

    private static void diguihuifu(int count,StringBuilder stb){
        if(count==firstHang.length()){
            list.add(stb.toString());
            return;}
        String dangqianS=map.get(Character.getNumericValue(firstHang.charAt(count)));
        for(int i=0;i<dangqianS.length();i++){
                stb.append(dangqianS.charAt(i));
                diguihuifu(count + 1, stb);
                stb.deleteCharAt(count);
        }
    }
}
