package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//数大雁,较难，
//https://renjie.blog.csdn.net/article/details/130728233
//https://leetcode.cn/problems/minimum-number-of-frogs-croaking/solutions/2257845/bie-xiang-tai-fu-za-mo-ni-ti-ba-liao-pyt-9t87/
public class ShuDaYan {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            char[] ch = s.toCharArray();
            char[] preZiMu = new char[128];
            String str = "quackq";
            for (int i = 1; i < 6; i++) {// 每个字母在 "quack" 中的上一个字母
                preZiMu[str.charAt(i)] = str.charAt(i - 1);
            }
            int[] ziMuCount = new int[128];
            int res = 0;
            for (int i = 0; i < ch.length; i++) {
                char per = preZiMu[ch[i]];// pre 为 ch 在 "quack" 中的上一个字母
                if (ziMuCount[per] > 0) {// 如果有青蛙发出了 pre 的声音
                    ziMuCount[per]--;// 复用一只
                } else if (ziMuCount[per] <= 0 && ch[i] != 'q') {// 否则青蛙必须从 'q' 开始蛙鸣
                    res = -1;
                    break;
                }
                ziMuCount[ch[i]]++;// 发出了 ch 的声音
            }
            if (ziMuCount['q'] > 0 || ziMuCount['u'] > 0 || ziMuCount['a'] > 0 || ziMuCount['c'] > 0) {
                res = -1;// 最后有发出其它声音的青蛙，而不是K,不符合要求
            }
            System.out.println(res == -1 ? -1 : ziMuCount['k']);// 最后大雁们都发出了 'k' 的声音
        }
    }

}
