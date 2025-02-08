package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//杨辉三角，动态数组用ArrayList，数组需要固定长度不太合适（踩坑）
public class YangHuiSanJiao {
    public ArrayList<ArrayList<Integer>> matrix(int n){
        ArrayList<ArrayList<Integer>> list3=new ArrayList<>();//整体数组
        ArrayList<Integer> list5=new ArrayList<>();//用来制造整体数组的第一个元素，第一行的初始化
        list5.add(0,1);//用来制造整体数组的第一个元素，第一行的初始化
        list3.add(0,list5);//用来制造整体数组的第一个元素，第一行的初始化
        for(int i=1;i<n;i++){
            ArrayList<Integer> list4=new ArrayList<>();//每一行所使用的数组
            list4.add(0,list3.get(i-1).get(0));//每行第一个数跟上一行第一个数相同
            for(int j=1;j<i;j++) {
                list4.add(j,list3.get(i-1).get(j-1)+list3.get(i-1).get(j));
            }
            list4.add(i,list3.get(i-1).get(i-1));//每行最后一个数跟上一行最后一个数相同
            list3.add(i,list4);
        }
        return list3;
    }


    public static void main(String[] args){
        YangHuiSanJiao z=new YangHuiSanJiao();
        ArrayList<ArrayList<Integer>> list =z.matrix(8);
        System.out.println(JSONObject.toJSONString(list));
    }
}
