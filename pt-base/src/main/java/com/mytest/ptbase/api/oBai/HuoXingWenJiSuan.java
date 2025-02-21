package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//火星文计算,https://renjie.blog.csdn.net/article/details/130897934
//正则匹配，字符串替换
public class HuoXingWenJiSuan {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            Pattern pattern=Pattern.compile("\\d+\\$\\d+");
            Matcher matcher = pattern.matcher(s);
            while(matcher.find()){
                String str=matcher.group();
                int x=Integer.valueOf(str.substring(0,str.indexOf("$")));
                int y=Integer.valueOf(str.substring(str.indexOf("$")+1));
                String resStr=String.valueOf(3*x+y+2);
                s=s.replace(str, resStr);
                matcher = pattern.matcher(s);
            }
            Pattern pattern2=Pattern.compile("\\d+#\\d+");
            Matcher matcher2 = pattern2.matcher(s);
            while(matcher2.find()){
                String str=matcher2.group();
                int x=Integer.valueOf(str.substring(0,str.indexOf("#")));
                int y=Integer.valueOf(str.substring(str.indexOf("#")+1));
                String resStr=String.valueOf(2*x+3*y+4);
                s=s.replace(str, resStr);
                matcher2 = pattern2.matcher(s);
            }
            System.out.println(s);
        }
    }

}
