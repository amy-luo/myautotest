package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//最长连续方波信号，https://renjie.blog.csdn.net/article/details/128105063
//正则匹配，头尾加0巧妙匹配。
public class ZuiChangLianXuFangBoXinHao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String xinhao = "0" + in.nextLine() + "0";//两个信号之间一般包含00，除了第一个信号和最后一个信号，给头尾加0，再来正则匹配
            int m = xinhao.length();//row
            int maxCount = 0;
            Pattern pattern = Pattern.compile("0(01)+00");//两个信号之间一般包含00，除了第一个信号和最后一个信号，给头尾加0，再来正则匹配
            Matcher matcher = pattern.matcher(xinhao);
            String result = "";
            while (matcher.find()) {
                String s = matcher.group();
                String s2 = s.substring(1,s.length()-1);//减去头尾多余的2个0
                if (s2.length() > maxCount) {
                    maxCount=s2.length();
                    result = s2;
                }
                xinhao = xinhao.replace(s, "00");//将匹配上的字符串替换成00，以保证接下来的两个信号还是相隔成两个信号
                matcher = pattern.matcher(xinhao);
            }
            System.out.println(result.equals("")?-1:result);
        }
    }
}
