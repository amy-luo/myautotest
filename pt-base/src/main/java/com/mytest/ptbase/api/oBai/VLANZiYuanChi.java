package com.mytest.ptbase.api.oBai;

import java.util.*;

//VLAN资源池，https://renjie.blog.csdn.net/article/details/128105607
//字符串分类处理，排序
public class VLANZiYuanChi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(",");
            String str = in.nextLine();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                boolean flag = false;
                if (s[i].indexOf("-") != -1) {
                    String[] s3 = s[i].split("-");
                    int a = Integer.valueOf(s3[0]);
                    int b = Integer.valueOf(str);
                    int c = Integer.valueOf(s3[1]);
                    if (b < a || b > c) {
                        list.add(s[i]);
                        continue;
                    }
                    String new_s3 = "";
                    if (a + 1 < b && b < c - 1) {
                        new_s3 = a + "-" + (b - 1) + "," + (b + 1) + "-" + c;
                        s[i] = new_s3;
                    }
                    if (a + 1 == b && b == c) {
                        new_s3 = a+"";
                        s[i] = new_s3;
                    }
                    if (a == b && b == c-1) {
                        new_s3 = c+"";
                        s[i] = new_s3;
                    }
                    if (a + 1 == b && b < c - 1) {
                        new_s3 = a + "," + (b + 1) + "-" + c;
                        s[i] = new_s3;
                    }
                    if (a + 1 < b && b == c - 1) {
                        new_s3 = a + "-" + (b - 1) + "," + c;
                        s[i] = new_s3;
                    }
                    if (a + 1 == b && b == c - 1) {
                        new_s3 = a + "," + c;
                        s[i] = new_s3;
                    }
                    if (a == b&& b <c-1) {
                        new_s3 = (a + 1) + "-" + c;
                        s[i] = new_s3;
                    }
                    if (a +1< b&&c == b) {
                        new_s3 = a + "-" + (c - 1);
                        s[i] = new_s3;
                    }
                    if (s[i].indexOf(",") != -1) {
                        List<String> list1 = Arrays.asList(s[i].split(","));
                        list.addAll(list1);
                    } else {
                        list.add(s[i]);
                    }
                    continue;
                } else {
                    if (s[i].equals(str)) {
                        s[i] = "";
                        continue;
                    } else {
                        list.add(s[i]);
                    }
                }

            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {//字符串特殊排序
                    o1 = o1.indexOf("-") == -1 ? o1 : o1.split("-")[0];
                    o2 = o2.indexOf("-") == -1 ? o2 : o2.split("-")[0];
//                    if(o1.equals("")||o2.equals("")){return -1;}
                    return Integer.valueOf(o1) - Integer.valueOf(o2);
                }
            });
            StringBuilder stb = new StringBuilder();
            for (String o : list) {
                if (!o.equals("")) {
                    stb.append(o + ",");

                }
            }
            System.out.println(stb.toString().substring(0, stb.length() - 1));
        }
    }
}
