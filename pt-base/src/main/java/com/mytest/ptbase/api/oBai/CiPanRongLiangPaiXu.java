package com.mytest.ptbase.api.oBai;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//磁盘容量排序，https://renjie.blog.csdn.net/article/details/128153550
//正则匹配，排序,switch
public class CiPanRongLiangPaiXu {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            int n = Integer.valueOf(s);
            ArrayList<String[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                String yuanshi=in.nextLine();
                String cipan=yuanshi;
                Pattern pattern=Pattern.compile("\\d+[MGT]");
                Matcher matcher = pattern.matcher(cipan);
                int res=0;
                while(matcher.find()){
                    String subCipan=matcher.group();
                    Character type = subCipan.charAt(subCipan.length() - 1);
                    int num = Integer.valueOf(subCipan.substring(0, subCipan.length() - 1));
                    int count=calCipan(num, type);
                    cipan = cipan.replace(subCipan, "");
                    matcher=pattern.matcher(cipan);
                    res+=count;
                }
                String[] array=new String[]{yuanshi,String.valueOf(res)};
                list.add(array);
            }
            Collections.sort(list, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.valueOf(o1[1])-Integer.valueOf(o2[1]);
                }
            });
           for(String[] o:list){
                System.out.println(o[0]);
            }
        }
    }
    private static int calCipan(int num,Character type){
        switch (type){
            case 'M':
                return num;
            case 'G':
                return 1024*num;
            case 'T':
                return 1024*1024*num;
        }
        return 0;
    }

}
