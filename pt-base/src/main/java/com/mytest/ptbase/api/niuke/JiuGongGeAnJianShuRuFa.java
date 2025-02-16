package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//九宫格按键输入法，https://renjie.blog.csdn.net/article/details/130786565
//需要记录相等的字符和字符个数，判断当前字符和前后字符是否相等
public class JiuGongGeAnJianShuRuFa {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('1',",.");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            String input=in.nextLine();
            boolean isEnghlish=false;//false-数字，true-英文
            int[] chCount=new int[]{0,0};//数字，重复的次数
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i)=='/'){Arrays.fill(chCount,0);continue;}
                if(input.charAt(i)=='0'){stb.append(" ");continue;}
                if(input.charAt(i)=='#'){isEnghlish=!isEnghlish;continue;}
                if(!isEnghlish){
                    stb.append(input.charAt(i));
                    continue;
                }else{
                    boolean pre=chCount[0]==Character.getNumericValue(input.charAt(i));
                    boolean after=(i!=input.length()-1&&input.charAt(i)==input.charAt(i+1));
                    if(pre){//是否和前面字符相等
                        chCount[1]++;
                    }else{
                        chCount[0]=Character.getNumericValue(input.charAt(i));
                        chCount[1]=1;
                    }
                    if(after){//是否和后面字符相等
                        continue;
                    }else{
                        int yu=chCount[1]%(map.get(input.charAt(i)).length());
                        if(yu==0) {
                            yu=map.get(input.charAt(i)).length();//取最后一个字符
                        }
                        char ch=map.get(input.charAt(i)).charAt((yu) - 1);
                        stb.append(ch);
                        Arrays.fill(chCount,0);
                    }
                }
            }

        System.out.println(stb.toString());
        }
    }

}
