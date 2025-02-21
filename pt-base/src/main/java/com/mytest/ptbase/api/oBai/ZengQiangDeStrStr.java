package com.mytest.ptbase.api.oBai;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//增强的strstr,https://renjie.blog.csdn.net/article/details/131555130
//字符串正则匹配
public class ZengQiangDeStrStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {

            String origin_str = in.nextLine();
//            String target_str = in.nextLine();
            String target_str = in.nextLine().replaceAll("\\[(.*?)\\]", "[$1]");

            Pattern pattern = Pattern.compile(target_str);
            Matcher matcher = pattern.matcher(origin_str);
            System.out.println(matcher.find() ? matcher.start() : -1);
        }
    }
}
