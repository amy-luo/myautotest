package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//箱子之字形摆放，https://renjie.blog.csdn.net/article/details/128245208
//遍历，反向遍历，队列，双向队列
public class XiangZiZhiZiXingBaiFang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int n = Integer.valueOf(s[1]);
            char[] ch = s[0].toCharArray();
            LinkedList<Character> deque = new LinkedList<>();
            for (char o : ch) {
                deque.addLast(o);
            }
            ArrayList<ArrayList<Character>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i, new ArrayList<Character>());
            }
            boolean flag=false;
            while (!deque.isEmpty()) {
                if(!flag) {
                    for (int i = 0; i < n; i++) {
                        ArrayList<Character> list2 = list.get(i);
                        list2.add(deque.pollFirst());
                        if (deque.isEmpty()) {
                            break;
                        }
                        list.set(i, list2);
                    }
                    flag = !flag;
                }else {
                    for (int i = n - 1; i >= 0; i--) {
                        ArrayList<Character> list2 = list.get(i);
                        list2.add(deque.pollFirst());
                        if (deque.isEmpty()) {
                            break;
                        }
                        list.set(i, list2);
                    }
                    flag = !flag;
                }
            }

        for (int i = 0; i < list.size(); i++) {
            StringBuilder stb = new StringBuilder();
            for (int j = 0; j < list.get(i).size(); j++) {
                stb.append(list.get(i).get(j));
            }
            System.out.println(stb.toString());
        }
    }
    }
}