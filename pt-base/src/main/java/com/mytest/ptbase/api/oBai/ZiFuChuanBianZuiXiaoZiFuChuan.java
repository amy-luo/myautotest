package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//字符串变换最小字符串,https://renjie.blog.csdn.net/article/details/128498260
//将字符串变成char[],从小到大排序后，对照原来的字符串s。
public class ZiFuChuanBianZuiXiaoZiFuChuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            char[] sinputduizhao = s.toCharArray();
            Arrays.sort(sinputduizhao);
            int index1 = -1;
            int index2 = -1;
            char index2Value = '-';
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > sinputduizhao[i]) {
                    index1 = i;
                    index2Value = sinputduizhao[i];
                    break;//找到了记得break哦
                }
            }
            index2 = index2Value!='-'?s.indexOf(index2Value):-1;
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i == index1) {
                    stb.append(index2Value);
                } else if (i == index2) {
                    stb.append(s.charAt(index1));
                }else{
                    stb.append(s.charAt(i));
                }
            }
            System.out.println(stb.toString());
        }
    }
}

