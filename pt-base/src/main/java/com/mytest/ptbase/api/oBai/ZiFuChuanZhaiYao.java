package com.mytest.ptbase.api.oBai;

import java.util.*;

//字符串摘要,https://renjie.blog.csdn.net/article/details/130956858
//字符串，变小写，去除非字母符号，字符计数，拼接，排序
public class ZiFuChuanZhaiYao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            int m=s.length();
            StringBuilder stb = new StringBuilder();
            int[] tmp = new int[]{0,0};
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < m; i++) {
                if('a'<=s.charAt(i)&&s.charAt(i)<='z'||'A'<=s.charAt(i)&&s.charAt(i)<='Z') {
                    stb.append(Character.toLowerCase(s.charAt(i)));
                    map.put(Character.toLowerCase(s.charAt(i)), map.getOrDefault(Character.toLowerCase(s.charAt(i)), 0) + 1);
                }
            }
            String str=stb.toString();
            stb.setLength(0);
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if(i<m-1&&str.charAt(i)==str.charAt(i+1)){
                    tmp[0] = str.charAt(i);
                    tmp[1]+=1;
                }else{
                    if(tmp[1]==0){
                        list.add(str.charAt(i)+String.valueOf(map.get(str.charAt(i))-1));
                        map.put(str.charAt(i),map.get(str.charAt(i)-1));
                    }else{
                        list.add(str.charAt(i)+String.valueOf(tmp[1]+1));
                        map.put(str.charAt(i),map.get(str.charAt(i)-tmp[1]-1));
                        tmp[1]=0;
                    }
                }
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.charAt(1)==o2.charAt(1)){
                        return o1.charAt(0) - o2.charAt(0);
                    }
                    return o2.charAt(1)-o1.charAt(1);
                }
            });
            for(String o:list) {
                System.out.print(o);
            }
        }
    }

}
