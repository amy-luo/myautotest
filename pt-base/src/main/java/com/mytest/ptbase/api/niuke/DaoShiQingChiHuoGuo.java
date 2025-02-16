package com.mytest.ptbase.api.niuke;

import java.util.*;

//导师请吃火锅,火锅，https://renjie.blog.csdn.net/article/details/130755834
//排序后，按手速时间取t=t+m
public class DaoShiQingChiHuoGuo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(" ");
            int n = Integer.valueOf(s[0]);//菜
            int m = Integer.valueOf(s[1]);//手速
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.add(firstHang[0] + firstHang[1]);
            }
            Collections.sort(list);
            int count=0;
            for(int t=list.get(0);t<=list.get(list.size()-1);t=t+m){
                for(int i=0;i<n;i++){
                    if(t==list.get(i)){
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
