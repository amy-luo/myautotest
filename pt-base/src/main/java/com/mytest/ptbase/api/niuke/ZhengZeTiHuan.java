package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

//正则表达式替换,"_"替换成"(^|$|[,+])"，[]内不替换，count计数[]，遇到[时count++，遇到]时count--
public class ZhengZeTiHuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] s= in.nextLine().toCharArray();
        StringBuilder stb=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length;i++) {
            if(s[i]=='['){count++;}
            if(s[i]==']'){count--;}
            if(count==0) {
                if (s[i] == '_' && (i == 0 || s[i - 1] != '\\')) {
                    stb.append("(^|$|[,+])");
                } else {
                    stb.append(s[i]);
                }
            }else{ stb.append(s[i]);}
        }

        System.out.println(stb.toString());
    }

}
