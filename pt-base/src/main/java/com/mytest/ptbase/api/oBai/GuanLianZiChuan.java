package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;


//关联子串，https://renjie.blog.csdn.net/article/details/131594006
//滑动窗口
public class GuanLianZiChuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            char[] ch1 = s[0].toCharArray();
            Arrays.sort(ch1);
            String str1 = new String(ch1);
            String str2 = s[1];
            int res = -1;
            for (int i = 0, j = i + str1.length() - 1; j < str2.length(); i++, j++) {//i,j同时加1，滑动窗口移动，同一行
                String str2_sub = str2.substring(i, j + 1);
                char[] ch2 = str2_sub.toCharArray();
                Arrays.sort(ch2);
                str2_sub = new String(ch2);
                if (str2_sub.equals(str1)){
                    res=i;
                    break;
                }
            }
            System.out.println(res);
        }
    }

}
