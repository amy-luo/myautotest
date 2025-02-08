package com.mytest.ptbase.api.niuke;

import java.util.*;

//找出两个数组的中位数，先合并，再sort排序，奇数偶数分类处理中位数
public class ZhongWeiShu {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            ArrayList<Integer> list=new ArrayList<>();
            Integer[] n1=new Integer[nums1.length];
            Integer[] n2=new Integer[nums2.length];
            for(int o=0;o<nums1.length;o++){
                n1[o]=nums1[o];
            }
            for(int o=0;o<nums2.length;o++){
                n2[o]=nums2[o];
            }
            list.addAll(Arrays.asList(n1));
            list.addAll(Arrays.asList(n2));
            Collections.sort(list);
            int n=list.size();
            double res=0;
            if(n%2==0){res=((double)list.get(n/2-1)+(double)list.get(n/2))/2;}
            if(n%2==1){res=list.get(n/2);}
            return res;
    }
}
