package com.mytest.ptbase.api.LTBai;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//字符串化繁为简，正则匹配，并查集，有很多细节需要判断处理。特别是大小字母关联情况下的判断处理
//https://renjie.blog.csdn.net/article/details/130794909
public class ZiFuChuanHuaFanWeiJian {
    public static int[] bingchaji;

    private static int find(int x) {//在并查集中找到根节点
        if (x != bingchaji[x]) {
            x=find(bingchaji[x]);//方法不能错，反参要写对。
        }
        return x;
    }

    private static void merge(char[] ar) {//将数组char元素的根节点在并查集中更新
        int x = find(bingchaji[ar[0]]);
        for (int i = 0; i < ar.length; i++) {
            int y = find(bingchaji[ar[i]]);
            bingchaji[y] = x;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        bingchaji = new int[128];
        for (char i = 'a'; i <= 'z'; i++) {//初始化并查集更节点
            bingchaji[i] = i;
        }
        for (char i = 'A'; i <= 'Z'; i++) {//初始化并查集更节点
            bingchaji[i] = i;
        }
        while (in.hasNextLine()) {
            String inputStr = in.nextLine();
//            inputStr = inputStr.toLowerCase();

            Pattern pattern = Pattern.compile("(\\([a-zA-Z]*\\))");
            Matcher matcher = pattern.matcher(inputStr);
            HashSet<Character> set = new HashSet<>();//放置所有括号里的元素

            while (matcher.find()) {
                String matcherString = matcher.group();
                if (matcherString.length() > 2) {
                    String ms = matcherString.substring(1, matcherString.length() - 1);
                    char[] ar = ms.toCharArray();
                    char[] ar2 = new char[2*ar.length];
                    for(int i=0;i<ar.length;i++){
                        set.add(ar[i]);//添加所有括号里的元素
                        ar2[i]=ar[i];
                        ar2[i+ar.length]='A'<=ar[i]&&ar[i]<='Z'?Character.toLowerCase(ar[i]):Character.toUpperCase(ar[i]);
                    }
                    Arrays.sort(ar2);
                    if (ar2.length >= 2) {
                        merge(ar2);//将字母以及个自己的大小写同时都关联到同一个根节点
                    }
                }
                inputStr = inputStr.replace(matcherString, "");
                matcher = pattern.matcher(inputStr);
            }
//            System.out.println(JSONObject.toJSONString(bingchaji));//打印并查集

            StringBuilder stb = new StringBuilder();
            for (char ch : inputStr.toCharArray()) {
                if(set.contains(ch)) {//判断是否是括号里的元素
                    int root = find(ch);//如果是就要找根节点，无论是大小写字母最终找到的都是它对应大写字母的根节点。
                    if(set.contains((char) root)) {//找到的根节点，如果括号中包含这个根节点,直接拼接
                        stb.append((char) root);
                    }else{stb.append(Character.toLowerCase((char) root));}//找到的根节点，如果括号中不包含这个根节点，那么它就是有小写字母自动关联过来的，要将其改成小写字母，再进行拼接。
                }else{stb.append(ch);}
            }
            System.out.println(stb.toString());
        }

    }
}
