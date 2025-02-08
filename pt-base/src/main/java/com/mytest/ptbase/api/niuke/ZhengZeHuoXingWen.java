package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//火星文计算，正则匹配
public class ZhengZeHuoXingWen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a=in.nextLine();
        Pattern p=Pattern.compile("(\\d+)#(\\d+)");
        Matcher m;
        while((m=p.matcher(a)).find()){
            int x=Integer.valueOf(m.group(1));
            int y=Integer.valueOf(m.group(2));
            a=a.replaceFirst(p.pattern(),Integer.toString(4*x+3*y+2));
        }
        Pattern p2=Pattern.compile("(\\d+)\\$(\\d+)");//（\\$）加括号group会包含$,不加括号，group不包含$,$是特殊字符要加转义"\\$"
        Matcher m2;
        while((m2=p2.matcher(a)).find()){
//            System.out.println(m2.group(1));
//            System.out.println(m2.group(2));
            int x=Integer.valueOf(m2.group(1));
            int y=Integer.valueOf(m2.group(2));
            a=a.replaceFirst(p2.pattern(),Integer.toString(2*x+y+3));
        }

        System.out.println(a);

    }
}
