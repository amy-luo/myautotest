package com.mytest.ptbase.api.niuke;

import java.util.*;

//寻找符合要求的最长字串，https://renjie.blog.csdn.net/article/details/130318463
//滑动窗口，用HashMap<Character,HashSet<Integer>>来存储字符出现过的位置，set保证同一个位置的字符不会重复存储
public class HuaChuangZuiChangZiChuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String s = in.nextLine();
        StringBuilder stb=new StringBuilder();
        int maxLength=1;
        HashMap<Character,HashSet<Integer>> map=new HashMap<>();//存储相同字符的位置
        int i=0,j=0;
        while(i<s.length()&&j<s.length()){
                HashSet<Integer> index=map.getOrDefault(s.charAt(j),new HashSet<>());
                if(s.charAt(j)==a.charAt(0)){
                    maxLength= Math.max(maxLength,stb.length());
                    System.out.println(stb.toString());
                    stb.setLength(0);
                    map.remove(map);
                    i=j++;
                    continue;}
                else if(index.size()==0){
                    stb.append(s.charAt(j));
                    index.add(j);
                    map.put(s.charAt(j),index);
                    j++;
                    if(j==s.length()){
                        maxLength= Math.max(maxLength,stb.length());
                        System.out.println(stb.toString());
                        stb.setLength(0);
                    }
                    continue;
                }else if(index.size()!=0){
                    int count=0;
                    ArrayList<Integer> removeList=new ArrayList();
                    for(Integer o:index){
                        if(o>=i&&o<j&&o!=j){
                            count++;
                            }else{removeList.add(o);}//去掉i和j范围外的索引
                    }
                    index.remove(removeList);
                    if(count<2) {
                        stb.append(s.charAt(j));
                        index.add(j);
                        map.put(s.charAt(j), index);
                        j++;
                        if(j==s.length()){
                            maxLength= Math.max(maxLength,stb.length());
                            System.out.println(stb.toString());
                            stb.setLength(0);
                        }
                        continue;
                    }else{
                        maxLength= Math.max(maxLength,stb.length());
                        System.out.println(stb.toString());
                        stb.setLength(0);
                        i=Collections.min(index);//i取值于i到j范围内较小的索引
                        index.remove(i);//移除这个重复值，左侧指针i移到下一个位置
                        i++;
                        j=i;
                        continue;
                    }
                }
            }
        System.out.println(maxLength);
    }

    public static Integer[] transfer(String[] a){
        Integer b[]=new Integer[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.valueOf(a[i]);
        }
        return b;
    }
}
