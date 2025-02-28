package com.mytest.ptbase.api.LTBai;

import java.util.*;

//服务失效判断，https://renjie.blog.csdn.net/article/details/130785873
//https://hydro.ac/d/HWOD2023/p/OD077
public class FuWuShiXiaoPanDuan {
    public static HashMap<String, ArrayList<String>> map;
    public static HashMap<String, Boolean> isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s0=in.nextLine();
            String[] s = s0.split(",");
            int m = Integer.valueOf(s.length);
            map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                String[] s1 = s[i].split("-");
                ArrayList<String> list = map.getOrDefault(s1[1], new ArrayList<>());
                list.add(s1[0]);
                map.put(s1[1],list);
            }
            String[] s2 = in.nextLine().split(",");
            HashSet<String> removeSet = new HashSet<>();
            for(String o:s2) {
                isVisited = new HashMap<>();
                dfsFind(o, isVisited,removeSet);
            }
            for(String o:removeSet){//删除部分元素，但list中的还没删
                map.remove(o);
            }
            HashSet<String> outSet= new HashSet<>(map.keySet());
            for(String o:map.keySet()){
                for(String o2:map.get(o)){
                    if(!removeSet.contains(o2)){//不添加要被删除的元素
                        outSet.add(o2);
                    }
                }
            }
            ArrayList<String[]> outlist2 = new ArrayList<>();
            for(String o:outSet){
                String xuhao=String.valueOf(s0.indexOf(o));//获初始字符串中排序的序号，作为依据来排序
                outlist2.add(new String[]{o, xuhao});
            }
            Collections.sort(outlist2,(Comparator.comparingInt(o -> Integer.valueOf(o[1]))));//排序
            StringBuilder stb = new StringBuilder();
            for(String[] o: outlist2){
                stb.append(o[0]+",");
            }
            if(stb.length()==0){System.out.println(",");}else {
                System.out.println(stb.substring(0, stb.length() - 1));
            }
        }
    }
    private static void dfsFind(String str,HashMap<String, Boolean> isVisited,HashSet<String> removeSet){
        ArrayList<String> list = map.getOrDefault(str, new ArrayList<>());
        removeSet.add(str);
        isVisited.put(str,true);
        if(list.size()!=0){
            ArrayList<String> list2 = map.getOrDefault(str, new ArrayList<>());
            if(list.size()!=0) {
                for (String str2:list2){
                    if (isVisited.get(str2)==null||!isVisited.get(str2)){
                        dfsFind(str2, isVisited, removeSet);
                    }
                }
            }
        }
    }
}
