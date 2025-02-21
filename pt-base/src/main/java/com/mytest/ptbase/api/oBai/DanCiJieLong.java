package com.mytest.ptbase.api.oBai;

import java.util.*;

//单词接龙,https://renjie.blog.csdn.net/article/details/128499617
//过程模拟，list自定义排序，元素的删除
public class DanCiJieLong {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            Comparator<String> comparator=new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length()==o2.length()){return o1.compareTo(o2);}
                    return o2.length()-o1.length();
                }
            };
            int start =Integer.valueOf(in.nextLine());
            int m =Integer.valueOf(in.nextLine());
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(in.nextLine());
            }
            String startS=list.get(start);
            list.remove(start);
            res.add(startS);
            char a = startS.charAt(startS.length() - 1);
            Collections.sort(list, comparator);
            while(true) {
                String resS = "";
                boolean flag=false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).charAt(0) == a) {
                        resS=list.get(i);
                        res.add(resS);
                        a=resS.charAt(resS.length()-1);
                        list.remove(i);
                        flag=true;
                        break;
                    }
                }
                if(!flag){break;}
            }
            StringBuilder stb = new StringBuilder();
            for(String s:res){
                stb.append(s);
            }
            System.out.println(stb.toString());
        }
    }

}
