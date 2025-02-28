package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//最左侧冗余覆盖子串，https://renjie.blog.csdn.net/article/details/128258957
//利用数组存放元素作为下标，个数作为值。来进行冗余字符串的对比。
// 使用s1.length+k长度的滑动窗口向右移动，每移动一次都需要进行对比，返回对比成功最小的下标。
public class ZuiZuoCeRongYuFuGaiZiChuan {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            Integer K = Integer.valueOf(in.nextLine());
            int res=0;
            if(s1.length()+K>s2.length()){System.out.println(-1);;}else {
                int[] s1ar = new int[128];//存放s1的字符个数
                int[] s2ar = new int[128];//存放滑动窗口的字符个数
                for (int i = 0; i < s1.length(); i++) {
                    s1ar[s1.charAt(i)]++;
                }
                for (int i = 0; i < s1.length() + K; i++) {
                    s2ar[s2.charAt(i)]++;
                }
                boolean flag = true;
                for (int i = 0, j = s1.length() + K - 1; j < s2.length(); i++, j++) {
                    flag = true;
                    s2ar[s2.charAt(j)]++;
                    if (s1ar[s2.charAt(i)] <= s2ar[s2.charAt(i)]
                            &&s1ar[s2.charAt(j)] <= s2ar[s2.charAt(j)]) {
                        for (int k = 0; k < s1.length(); k++) {
                            if (s1ar[s1.charAt(k)] > s2ar[s1.charAt(k)]) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.println(i);
                            break;
                        }
                    }
                    s2ar[s2.charAt(i)]--;
                }
                if (!flag) {
                    System.out.println(-1);
                }
            }
        }
    }
}
