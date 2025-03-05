package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//最大括号深度，https://renjie.blog.csdn.net/article/details/128139341
//用Stack<Character> stack来实现，存放括号左侧的深度，右侧括号要正确匹配，若没有正确匹配则输出0
public class ZuiDaKuoHaoShenDu {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String sinput = in.nextLine();
            Stack<Character> stack = new Stack<>();
            int maxDepth = 0;
            int i=0;
            for (i = 0; i < sinput.length(); i++) {
                if (sinput.charAt(i) == '(' || sinput.charAt(i) == '{' || sinput.charAt(i) == '[') {
                    stack.push(sinput.charAt(i));
                    maxDepth = Math.max(maxDepth, stack.size());
                } else {
                    if (stack.size() == 0) {
                        break;
                    }
                    if ((sinput.charAt(i) == ')' && stack.pop() == '(')
                            || (sinput.charAt(i) == '}' && stack.pop() == '{')
                            || (sinput.charAt(i) == ']' && stack.pop() == '[')) continue;
                    break;
                }
            }
            if(i==sinput.length()&&stack.size()==0) {
                System.out.println(maxDepth);
            }else{System.out.println(0);}
        }
    }
}
