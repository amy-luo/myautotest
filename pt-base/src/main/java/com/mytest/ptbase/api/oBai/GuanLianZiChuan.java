package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;


//关联子串，https://renjie.blog.csdn.net/article/details/131594006
//滑动窗口,用两个数组记录两个字符串中比对的字符的数量，增加比对性能。
public class GuanLianZiChuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            char[] ch1 = s[0].toCharArray();
            int[] ch1Count = new int[128];
            for (int i = 0; i < ch1.length; i++) {
                ch1Count[ch1[i]]++;
            }
            Arrays.sort(ch1);
            String str1 = new String(ch1);
            String str2 = s[1];
            int res = -1;
            int[] ch2Count = new int[128];
            for (int i = 0; i < ch1.length; i++) {
                ch2Count[str2.charAt(i)]++;
            }
            for (int i = 0, j = i + str1.length() - 1; j < str2.length(); i++, j++) {//i,j同时加1，滑动窗口移动，同一行
                if (ch2Count[str2.charAt(j)] == ch1Count[str2.charAt(j)]
                        && (i == 0 || (i > 0 && ch2Count[str2.charAt(i - 1)] == ch1Count[str2.charAt(i - 1)]))) {
                    for (int k = 0; k < ch1Count.length; k++) {
                        if (ch2Count[str1.charAt(k)] == ch1Count[str1.charAt(k)]) {
                            res = i;
                            break;
                        }
                    }
                }
                if(j<str2.length()-1){ch2Count[str2.charAt(j + 1)]++;}
                ch2Count[str2.charAt(i)]--;
            }
//                String str2_sub = str2.substring(i, j + 1);
//                char[] ch2 = str2_sub.toCharArray();
//                Arrays.sort(ch2);
//                str2_sub = new String(ch2);
//                if (str2_sub.equals(str1)) {
//                    res = i;
//                    break;
//                }
            System.out.println(res);
        }
    }
}
