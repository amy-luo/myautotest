package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//恢复数字序列，https://renjie.blog.csdn.net/article/details/130956437
//滑动窗口，滑动窗口起始值分情况设置，也可以不分情况，字符串排序
public class HuiFuShuZiXuLie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int k = Integer.valueOf(s[1]);
            char[] chs = s[0].toCharArray();
            Arrays.sort(chs);
            String new_s = new String(chs);//输入的字符串排序后的结果
            int start = 0;
            if(s[0].length()>k&&s.length<2*k){start=10-k;}
            if(s[0].length()==2*k){start=10;}
            if(s[0].length()>2*k&&s.length<3*k){start=100-k;}
            if(s[0].length()==3*k){start=100;}
            LinkedList<Integer> deque = new LinkedList<>();//滑动窗口
            for (int i = start; i < start + k; i++) {
                deque.addLast(i);
            }
            int count = start + k;//滑动窗口起始值
            while (true) {
                //新的滑动窗口值组成字符串排序
                StringBuilder stb = new StringBuilder();
                for (int i = 0; i < k; i++) {
                    stb.append(deque.get(i));
                }
                char[] xin = stb.toString().toCharArray();
                Arrays.sort(xin);
                String xin2 = new String(xin);

                if (new_s.equals(xin2)) {
                    System.out.println(deque.peekFirst());
                    break;
                } else {
                    deque.pollFirst();
                    deque.addLast(count++);
                }
            }
        }
    }

}
