package com.mytest.ptbase.api.oBai;

import java.util.*;

//第K个大的连续字母长度,数据结构基本功
//https://renjie.blog.csdn.net/article/details/128499527
public class LianXuZiMuChangDu {
    public static HashMap<Character,Integer> map;
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            char[] s = in.nextLine().toCharArray();
            int k = Integer.valueOf(in.nextLine());
            int res = 0;
            if (k > s.length) {
                res = -1;
            }
            if (res != -1) {
                map = new HashMap<>();
                StringBuilder stb = new StringBuilder();
                stb.append(s[0]);
                for (int i = 1; i < s.length; i++) {
                    if ((s[i] == s[i - 1])) {
                        stb.append(s[i]);
                    } else {
                        map.put(s[i - 1], Math.max(map.getOrDefault(s[i - 1], 0), stb.length()));
                        stb.setLength(0);
                        stb.append(s[i]);
                    }
                    if (i == s.length - 1) {
                        map.put(s[i], Math.max(map.getOrDefault(s[i], 0), stb.length()));
                    }
                }
                ArrayList list = new ArrayList(map.values());
                Collections.sort(list);
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - k) {
                        System.out.println(list.get(i));
                    }
                }
            }else{System.out.println(res);}
        }
    }

}
