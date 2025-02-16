package com.mytest.ptbase.api.niuke;

import java.util.*;

//树状结构查询，https://renjie.blog.csdn.net/article/details/131378108
//HashMap存放树状结构关系，递归查找,防止有环，初始元素的底层元素找到是自己时不能添加，不要继续递归自己，continue递归其它元素。
//好像不能改成用并查集来做。
public class ShuZhuangJieGouChaXun {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());//row
            HashMap<Character, ArrayList<Character>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                String[] dataArray = in.nextLine().split(" ");
                ArrayList<Character> list = map.getOrDefault(dataArray[1].charAt(0), new ArrayList<Character>());
                list.add(dataArray[0].charAt(0));
                map.put(dataArray[1].charAt(0), list);
            }
            char ch = in.nextLine().charAt(0);
            ArrayList<Character> result = dfsFind(ch, ch,map, new ArrayList<Character>());
            Collections.sort(result);
            for (Character o : result) {
                System.out.println(o);
            }
        }
    }

    private static ArrayList<Character> dfsFind(Character startCh, Character ch, HashMap<Character, ArrayList<Character>> map, ArrayList<Character> result) {
        ArrayList<Character> list = map.get(ch);
        for (Character o : list) {
            if(o!=startCh) {//放置形成环，下面的元素不能为自己(初始查找元素)
                result.add(o);
                if (map.get(o) != null) {
                    result = dfsFind(startCh, o, map, result);
                }
            }
        }
        return result;
    }
}
