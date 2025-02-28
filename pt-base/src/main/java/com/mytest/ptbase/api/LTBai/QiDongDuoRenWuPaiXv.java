package com.mytest.ptbase.api.LTBai;

import java.util.*;

//启动多任务排序,https://renjie.blog.csdn.net/article/details/135484839
//递归hashMap,从每个根节点开始递归，记录路径上的节点是否访问，记录路径上访问的元素和对应的层级，最深曾为0级，再往上反，层级增大。
public class QiDongDuoRenWuPaiXv {
    public static List<HashSet<String>> res;
    public static HashMap<String, ArrayList<String>> map;


    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            String[] firstHang = in.nextLine().split(" ");
            HashMap<String, HashSet<String>> map = new HashMap<>();

            for (String o : firstHang) {
                String[] s = o.split("->");
                HashSet<String> li = map.getOrDefault(s[0], new HashSet<>());
                li.add(s[1]);
                map.put(s[0], li);
            }

            res = new ArrayList<>();
            for (String o : map.keySet()) {
                HashMap<String, Boolean> isVisited = new HashMap<>();//每次从根节点递归，要分路径记录访问记录，避免无限循环
                dfsMap(o, 0, map, isVisited);
            }
            StringBuilder stb = new StringBuilder();
            for (HashSet<String> list : res) {
                ArrayList<String> list2 = new ArrayList<>(list);
                Collections.sort(list2);
                for (String s : list2) {
                    stb.append(s + " ");
                }
            }
            System.out.println(stb.toString());
        }
    }

    private static int dfsMap(String str, int count, HashMap<String, HashSet<String>> map, HashMap<String, Boolean> isVisited) {
        if(isVisited.get(str)!=null&&isVisited.get(str)){return count;}
        if (map.get(str) != null) {
            isVisited.put(str, true);
            int count1=count;//同一个for循环，每次递归的count层级不要变
            for (String str1 : map.get(str)) {
                count = dfsMap(str1, count1, map, isVisited);//最深层的层级为count=0，返回上一层级时需要count++，同一个for循环，每次递归的count层级不要变
            }
            HashSet<String> list;//递归最深层级加完元素后，就返回上一层级加元素
            if (res.size() > count && res.get(count) != null) {
                list = res.get(count);
                list.add(str);
                res.set(count, list);
            } else {
                list = new HashSet<>();
                list.add(str);
                res.add(count, list);
            }
            count++;
        } else {
            HashSet<String> list;
            if (res.size() > count && res.get(count) != null) {
                list = res.get(count);
                list.add(str);
                res.set(count, list);
            } else {
                list = new HashSet<>();
                list.add(str);
                res.add(count, list);
            }
            count++;
        }
        return count;
    }
}
