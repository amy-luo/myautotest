package com.mytest.ptbase.api.oBai;

import java.util.*;

//猜字谜，https://renjie.blog.csdn.net/article/details/128427589
//字符串去重排序
public class CaiZiMi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    private static String changeSort(String s){
        char[] ar=s.toCharArray();
        HashSet<Character> set = new HashSet();
        for(char o:ar){
            set.add(o);
        }
        Character[] res = set.toArray(new Character[set.size()]);
        Arrays.sort(res);
        StringBuilder stb = new StringBuilder();
        for(Character o:res){
            stb.append(o);
        }
        return stb.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
        String s1 = in.nextLine();
        String[] ss1 = s1.indexOf(",") == -1 ? new String[]{s1} : s1.split(",");
        String s2 = in.nextLine();
        String[] ss2 = s2.indexOf(",") == -1 ? new String[]{s2} : s2.split(",");

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < ss1.length; i++) {
            boolean flag=false;
            for (int j = 0; j < ss2.length; j++) {
                String inputStr=changeSort(ss1[i]);
                String zidianStr=changeSort(ss2[j]);
                if(inputStr.equals(zidianStr)){
                    list.add(ss2[j]);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                list.add("not found");}
            }
            StringBuilder stb = new StringBuilder();
            for(String o:list){
                stb.append(o+",");
            }
            System.out.println(stb.toString().substring(0,stb.length()-1));
        }

    }

}
