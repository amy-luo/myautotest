package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
//文本统计分析，统计文本数量，https://renjie.blog.csdn.net/article/details/130898004
public class WenBenTongJiFenXi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Character> deque = new LinkedList<>();
        int count=0;
        while (in.hasNextLine()) {
            String input = in.nextLine();
            if(input.equals("")){break;}
            for(int i=0;i<input.length();i++){
                if(input.charAt(i)==';'){
                    if(!deque.isEmpty()&&deque.peekLast()!='\\'){
                        count++;
                        deque.clear();
                    }
                }else if(i>0&&input.charAt(i)=='-'&&input.charAt(i-1)=='-'&&input.charAt(i-1)!='\''&&input.charAt(i-1)!='\"'){//将评论排除是文本
                    deque.pollLast();
                    break;
                }else if(input.charAt(i)!=' '){
                    deque.addLast(input.charAt(i));
                }
            }
        }
        if(!deque.isEmpty()){count++;}
        System.out.println(count);
    }
}
