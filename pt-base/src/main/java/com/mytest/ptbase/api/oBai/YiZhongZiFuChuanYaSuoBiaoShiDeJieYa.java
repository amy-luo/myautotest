package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//一种字符串压缩表示的解压,https://renjie.blog.csdn.net/article/details/131677963
//枚举所有不合法场景，检测出来。如果合法，根据数字来对后面的字符进行拼接。主要要替换掉数字，多位数字，前面几位为空，保留最后一位替换成重复的字母-1
public class YiZhongZiFuChuanYaSuoBiaoShiDeJieYa {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            char[] input2 = s.toCharArray();
            String[] input =new String[s.length()];
            for(int i=0;i<input2.length;i++){
                input[i] = String.valueOf(input2[i]);
            }
            if (isPass(input2)) {
                String num = "";
                for (int i = 0; i < input.length; i++) {
                    if (Character.isDigit(input[i].charAt(0))) {
                        num += input[i];
                        if(Character.isLowerCase(input[i+1].charAt(0))){
                            String tihuan = "";
                           for(int j=0;j<Integer.valueOf(num)-1;j++){
                               tihuan+=input[i+1];
                           }
                           input[i]=tihuan;
                            num = "";
                        }else if(Character.isDigit(input[i+1].charAt(0))){
                            input[i] = "";
                        }
                    }
                }
                for(int i=0;i<input.length;i++){
                    System.out.print(input[i]);
                }
            }else{System.out.print("!error");}

        }
    }

    private static boolean isPass(char[] input) {
        int m = input.length;
        if (Character.isDigit(input[m - 1])) { //最后一个字符是数字，数字后无字符，asd5
            return false;
        }
        for (int i = 0; i < input.length; i++) {
            char ch = input[i];
            if (!Character.isDigit(ch) && !Character.isLowerCase(ch)) {//非小写，非数字
                return false;
            }
            if (Character.isDigit(ch)) {//如果是数字，继续
                continue;
            }
            if (i >= 2) {
                if (ch == input[i - 1] && ch == input[i - 2]) {//有3个或以上连续的字母，aaa
                    return false;
                }
            }
            if (i >= 2) {
                if (ch == input[i - 1] && Character.isDigit(input[i - 2])) {//未压缩完全，如5aa
                    return false;
                }
            }
            if (i == 1 && '2' == input[i - 1]) {//2a3d，2个a被压缩了
                return false;
            }
            if (i >= 2 && '2' == input[i - 1] && Character.isLowerCase(input[i - 2])) {//d2a3d，2个a被压缩了
                return false;
            }
        }
        return true;
    }

}
