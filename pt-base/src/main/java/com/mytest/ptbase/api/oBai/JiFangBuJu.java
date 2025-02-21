package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//机房布局,https://renjie.blog.csdn.net/article/details/128502872
//M两边至少有一个I能放置电箱。
public class JiFangBuJu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = s.length();
            int res = 0;
            for (int i = 0; i < m; ) {
                if (s.charAt(i) == 'M') {
                    if (i + 1 < m && s.charAt(i + 1) == 'I') {
                        res++;
                        i = i + 3;
                    } else if (i > 0 && s.charAt(i - 1) == 'I') {
                        res++;
                        i++;
                    } else {
                        res = -1;
                        break;
                    }
                }else{i++;}
            }
            System.out.println(res);
        }
    }

}
