package com.mytest.ptbase.api.niuke;

import java.util.*;

//第K个大的连续字母长度,数据结构基本功
public class LianXuZiMuLength {
    public static HashMap<Character,Integer> map;
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        int k = Integer.valueOf(in.nextLine());
        map =new HashMap<>();
        StringBuilder stb=new StringBuilder();
        stb.append(s[0]);
        for(int i=1;i<s.length;i++){
            if((s[i]==s[i-1])){
                stb.append(s[i]);
            }else{
                map.put(s[i-1],Math.max(map.getOrDefault(s[i-1],0),stb.length()));
                stb.setLength(0);
                stb.append(s[i]);
            }
            if(i==s.length-1){map.put(s[i],Math.max(map.getOrDefault(s[i],0),stb.length()));}
        }
        ArrayList list=new ArrayList(map.values());
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(i==list.size()-k) {
                System.out.println(list.get(i));
            }
        }
    }

}
