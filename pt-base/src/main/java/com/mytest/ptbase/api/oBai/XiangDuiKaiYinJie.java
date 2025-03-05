package com.mytest.ptbase.api.oBai;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
//相对开音节,https://renjie.blog.csdn.net/article/details/128499096
//正则匹配
public class XiangDuiKaiYinJie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] words = in.nextLine().split(" ");
            int count = 0;

            Pattern nonLetter = Pattern.compile("[^a-z]");
            Pattern reg1 = Pattern.compile("[^aeiou][aeiou][^aeiour]e");
            Pattern reg2 = Pattern.compile("e[^aeiour][aeiou][^aeiou]");

            for (String word : words) {
                Pattern reg = nonLetter.matcher(word).find() ? reg1 : reg2;

                for (int i = 0; i <= word.length() - 4; i++) {
                    String seg = word.substring(i, i + 4);

                    if (nonLetter.matcher(seg).find()) {continue;}

                    if (reg.matcher(seg).find()){count++;}
                }
            }

            System.out.println(count);
            return;
        }
    }
}