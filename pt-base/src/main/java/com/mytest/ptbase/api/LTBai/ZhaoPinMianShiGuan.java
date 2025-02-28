package com.mytest.ptbase.api.LTBai;

import java.util.*;

//最少面试官数，https://renjie.blog.csdn.net/article/details/130785760
//按面试起始时间排序，维护每位面试官的面试次数和当前面试结束时间。然后当一个i虚拟的时间安排出现的时候，只需要判断一下是否需要新的一个面试官；
public class ZhaoPinMianShiGuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer,int[]> map=new HashMap<>();//面试官序号，[面试官面试次数，面试官结束时间]


        int m = Integer.valueOf(in.nextLine());
        int n = Integer.valueOf(in.nextLine());
        ArrayList<int[]> mian=new ArrayList<>();
        for(int i=0;i<n;i++){
                String[] s=in.nextLine().split(" ");
                int[] b=new int[]{Integer.valueOf(s[0]),Integer.valueOf(s[1])};
                mian.add(b);
        }
        Collections.sort(mian,(Comparator.comparingInt(o -> o[0])));//按面试起始时间排序，维护每位面试官的面试次数和当前面试结束时间。
//        Collections.sort(mian,((o1, o2) -> {return o1[0]-o2[0];}));
        int count=0;//面试官数量
        for(int i=0;i<n;i++){
            if(mian.size()==0){
                count++;
                int[] guan=map.getOrDefault(count,new int[]{1,mian.get(i)[1]});
                map.put(count,guan);
            }else{
                boolean yiyou=false;
                for(Map.Entry<Integer,int[]> o:map.entrySet()){
                    if(o.getValue()[0]<m&&o.getValue()[1]<=mian.get(i)[0]){
                        int[] guan=new int[]{o.getValue()[0]+1,mian.get(i)[1]};
                        map.put(o.getKey(),guan);
                        yiyou=true;
                        break;
                    }
                }
                if(!yiyou){
                    count++;
                    int[] guan=map.getOrDefault(count,new int[]{1,mian.get(i)[1]});
                    map.put(count,map.getOrDefault(count,guan));
                }
            }
        }
        System.out.println(count);

    }

    public static Integer[] transfer(String[] a){
        Integer b[]=new Integer[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.valueOf(a[i]);
        }
        return b;
    }
}
