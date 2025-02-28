package com.mytest.ptbase.api.oBai;

import java.util.*;

//数据分类，https://renjie.blog.csdn.net/article/details/130936554
//4个字节，位数太长，需要使用长整型Long，先将数字a转换成16进制后，从右往左每两位计算出十进制，最后将4个十进制相加，取余。
public class ShuJuFenLei {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            long[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long c=dataArray[0];
            long b = dataArray[1];
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 2; i < dataArray.length; i++) {
                String s16=Long.toString(dataArray[i],16);
                int count=0;
                for(int j=s16.length();j>0;j=j-2){
                    String str = "";
                    if(j>=2) {
                        str = s16.substring(j - 2, j);
                    }else{
                        str = s16.substring(0, j);
                    }
                    count+=Integer.parseInt(str, 16);
                }
                if(count%b<c){
                    map.put(count % b, map.getOrDefault(count % b, 0) + 1);
                }
            }
            ArrayList<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list);
            System.out.println(list.get(list.size()-1));
        }
    }

}
