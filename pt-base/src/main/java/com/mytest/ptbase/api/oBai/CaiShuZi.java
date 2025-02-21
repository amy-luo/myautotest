package com.mytest.ptbase.api.oBai;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//猜数字，https://hydro.ac/d/HWOD2023/p/OD081
//比较难，遍历到10000，对比字符串时使用的方法，将不同的值当做数组的key存入数组，值是他的个数。跟使用hashmap时一样。
public class CaiShuZi {
    public static String[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = Integer.valueOf(s);
            ArrayList<String> list = new ArrayList<>();
            matrix = new String[m][2];
            for (int i = 0; i < m; i++) {
                String[] dataArray = in.nextLine().split(" ");
                matrix[i] = dataArray;
            }
            List<Character> chList = Arrays.asList(new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'});
            for (Character c1 : chList) {
                for (Character c2 : chList) {
                    for (Character c3 : chList) {
                        for (Character c4 : chList) {
                            String tmp = new String(new char[]{c1, c2, c3, c4});
//                            String tmp = "3585";
                            boolean flag = true;
                            for (String[] data : matrix) {
                                int countA = 0;
                                int countB = 0;
                                String bijiao=data[0];
                                int[] bijiaoAr = new int[10];
                                int[] tmpAr = new int[10];
                                for(int i=0;i<4;i++){
                                    if(bijiao.charAt(i)==tmp.charAt(i)){
                                        countA++;
                                    }else{
                                        bijiaoAr[bijiao.charAt(i)-'0']++;//将不同的值当做数组的key存入数组，值是他的个数。
                                        tmpAr[tmp.charAt(i)-'0']++;
                                    }
                                }
                                for(int i=0;i<10;i++) {
                                    countB += Math.min(bijiaoAr[i],tmpAr[i]);//如果有值且相等，取小的个数
                                }
                                if(!data[1].equals(countA+"A"+countB+"B")){
                                    flag=false;
                                    break;
                                }
                              }

                            if (flag) {
                                list.add(tmp);
                            }
                        }
                    }
                }
            }
            if(list.size()==1){System.out.println(list.get(0));}else{
                System.out.println("NA");
            }
        }
    }
}
