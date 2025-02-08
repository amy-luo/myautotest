package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//算法题 - 求数组的子集合，遍历每个元素，加上这个元素后子集和的个数应该是前面那个数组元素为止的所有子集和的2倍+1（子集单独组成一个子集和）
//当前元素子集和=前一个元素所有子集和与当前元素组成新的数组+子集单独组成一个数组
public class ZiJiHeArray {
    public ArrayList<ArrayList<Integer>> getZijiHe(int[] a){
        ArrayList<ArrayList<Integer>> list =new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(!list.isEmpty()){
                ArrayList<ArrayList<Integer>> list4=new ArrayList<>();
                for(ArrayList list2:list){
                    ArrayList<Integer> list3=new ArrayList<>();
                    list3.addAll(list2);
                    list3.add(a[i]);
                    list4.add(list3);
                }
                list.addAll(list4);
            }
            list.add(new ArrayList(Arrays.asList(a[i])));
        }
        HashSet<ArrayList<Integer>> set=new HashSet();
        set.addAll(list);
//        System.out.println(JSONObject.toJSONString(set));
        ArrayList<ArrayList<Integer>> listres =new ArrayList<>();
        for(ArrayList<Integer> o:set){
            listres.add(o);
        }
        return listres;

    }

    public static void main(String[] args){
        ZiJiHeArray z=new ZiJiHeArray();
        int[] a={1,1,2,2,4};
        ArrayList<ArrayList<Integer>> list =z.getZijiHe(a);
        ArrayList<ArrayList<Integer>> list3=new ArrayList<>();//存放子集和为6的子集
        System.out.println(JSONObject.toJSONString(list));
        for(ArrayList<Integer> list2:list){
            int sum=list2.stream().mapToInt(Integer::intValue).sum();//list求和的方法
            if(sum==6){
                list3.add(list2);
            }
        }
        System.out.println(JSONObject.toJSONString(list3));
    }
}
