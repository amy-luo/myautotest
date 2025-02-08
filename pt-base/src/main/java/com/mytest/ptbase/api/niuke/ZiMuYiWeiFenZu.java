package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Array;
import java.util.*;

//字母异位分组，排序后为key，value为字符与key相同的数组
public class ZiMuYiWeiFenZu {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] o1=strs[i].toCharArray();
            Arrays.sort(o1);
            String key=new String(o1);
            ArrayList<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(strs[i]);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
