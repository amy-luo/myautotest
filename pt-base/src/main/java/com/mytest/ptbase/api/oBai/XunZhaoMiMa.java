package com.mytest.ptbase.api.oBai;

import java.util.*;

//寻找密码，https://renjie.blog.csdn.net/article/details/128227432
//HashMap<Character, HashSet<String>> map存放密码本的密码，方便查找。再按字符串长度从大到小排序，从最长的开始找。
public class XunZhaoMiMa {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            HashMap<Character, HashSet<String>> map = new HashMap<>();
            for (int i = 0; i < s.length; i++) {
                HashSet<String> set;
                if (map.get(s[i].charAt(0)) == null) {
                    set = new HashSet<>();
                } else {
                    set = map.get(s[i].charAt(0));
                }
                set.add(s[i]);
                map.put(s[i].charAt(0), set);
            }
            Arrays.sort(s, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length() - o1.length();
                }
            });
            int length = 0;
            ArrayList<String> mima =new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                if(s[i].length()<length){break;}
                String new_s = s[i];
                boolean flag=true;
                while (new_s.length() > 0) {
                    new_s = new_s.substring(0, new_s.length() - 1);
                    HashSet<String> set=map.get(s[i].charAt(0));
                    if (!new_s.equals("")&&!set.contains(new_s)) {
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    if(s[i].length()>length){
                        length = s[i].length();
                        mima.removeAll(mima);
                        mima.add(s[i]);
                    }else if(s[i].length()==length) {
                        mima.add(s[i]);
                    }
                }
            }
            Collections.sort(mima, Comparator.reverseOrder());
//            StringBuilder stb = new StringBuilder();
            System.out.println(mima.get(0));
        }
    }

}
