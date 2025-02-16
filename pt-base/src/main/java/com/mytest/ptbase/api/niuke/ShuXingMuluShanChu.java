package com.mytest.ptbase.api.niuke;

import java.util.*;

//树形目录删除,https://renjie.blog.csdn.net/article/details/128498078
//树形结构HashMap，HashMap<Integer, ArrayList<Integer>>递归查找
public class ShuXingMuluShanChu {
    public static TreeMap<Integer, ArrayList<Integer>> map;
    public static HashMap<Integer, Boolean> visited;
    public static HashSet<Integer> delSet;

    //    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            map = new TreeMap<>();
            visited = new HashMap<>();
            int m = Integer.valueOf(in.nextLine());
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                ArrayList<Integer> list = map.getOrDefault(dataArray[1], new ArrayList<>());
                ArrayList<Integer> list2 = map.getOrDefault(dataArray[0], new ArrayList<>());
                list.add(dataArray[0]);
                map.put(dataArray[1], list);
                map.put(dataArray[0], list2);
                visited.put(dataArray[1], false);
                visited.put(dataArray[0], false);
            }
            visited = new HashMap<>();
            delSet = new HashSet<>();
            delDir(Integer.valueOf(in.nextLine()));
            Set<Integer> set = map.keySet();
            set.removeAll(delSet);//从set中去掉要删除的目录id
            set.remove(0);//去掉根目录id:0
            ArrayList<Integer> outList = new ArrayList<>(set);
            Collections.sort(outList);
            for (Integer o : outList) {
                System.out.print(o + " ");
            }

        }
    }

    private static void delDir(int id) {//递归查找要删除的所有目录id，并放到删除set中。
        ArrayList<Integer> list = map.getOrDefault(id, new ArrayList<>());
        visited.put(id, true);
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (visited.get(list.get(i)) == null || !visited.get(list.get(i))) {
                    delDir(list.get(i));
                }
            }
        }
        delSet.add(id);
    }
////处理输出，将map中所有的id都放入set里面。
//    private static HashSet<Integer> outputMap() {
//        HashSet<Integer> set = new HashSet();
//        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
//            set.add(entry.getKey());
//            if (!entry.getValue().isEmpty()) {
//                for (int i = 0; i < entry.getValue().size(); i++) {
//                    set.add(entry.getValue().get(i));
//                }
//            }
//        }
//        return set;
//
//    }

}
