package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//获得完美走位，https://renjie.blog.csdn.net/article/details/128051684，
//思维方式较难，去除使得个数超过n/4的最短字符串。
//从小到大枚举「待替换子串」的左端点left，为了使得替换的长度最小，
// 我们要找到最近的右端点 r，使得去除 [l,r) 之后的剩余部分满足上述条件。找到后记录，再右移left
// 不难发现，随着 l 的递增，r 也是递增的。

//https://leetcode.cn/problems/replace-the-substring-for-balanced-string/solutions/2107520/ti-huan-zi-chuan-de-dao-ping-heng-zi-fu-f8fk8/
public class HuoDeWanMeiZouWei {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'A']++;
            }
            int count = s.length() / 4;
            int res=s.length();
            if (isCheck(cnt, count)) {
                res=0;
            }else {
                for (int left = 0, right = 0; right < s.length(); ) {
                    while (right < s.length() && !isCheck(cnt, count)) {
                        cnt[s.charAt(right)-'A']--;//如果超出了，从左往右开始减掉1个再检查，一直减到都不超出或结束
                        right++;
                    }
                    if (!isCheck(cnt, count)) {
                        break;
                    }
                    res = Math.min(right - left,res);
                    cnt[s.charAt(left)-'A']++;
                    left++;
                }
            }
            System.out.println(res);
        }
    }

    private static boolean isCheck(int[] cnt, int count) {
        if (cnt['A'-'A'] > count || cnt['D'-'A'] > count || cnt['S'-'A'] > count || cnt['W'-'A'] > count) {
            return false;
        }
        return true;
    }
}
