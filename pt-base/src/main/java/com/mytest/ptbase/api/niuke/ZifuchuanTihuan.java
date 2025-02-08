package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//敏感字段加密，字符串处理
public class ZifuchuanTihuan {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int b=Integer.valueOf(in.nextLine());
        String a = in.nextLine();
        StringBuilder stb=new StringBuilder();
        char[] ch=a.toCharArray();
        ArrayList<Integer> yinhaoIndexList=new ArrayList<>();
        ArrayList<String> resList=new ArrayList<>();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='"'){
                yinhaoIndexList.add(i);//存储引号的索引
            }
        }
        for(int i=0;i<=yinhaoIndexList.size()-2;i++){//遍历偶数引号索引
            String s1="";
            if(i==0){
                s1= a.substring(0,yinhaoIndexList.get(i));
            }else{
                s1= a.substring(yinhaoIndexList.get(i-1)+2,yinhaoIndexList.get(i));
            }

            String[] s=s1.indexOf("_")!=-1?s1.split("_"):new String[]{s1};
            ArrayList<String> list=new ArrayList(Arrays.asList(s));
            resList.addAll(list);//处理偶数引号左侧的字符串
            String s2=a.substring(yinhaoIndexList.get(i),yinhaoIndexList.get(i+1)+1);
            resList.add(s2);//处理引号中间的字符串
            i++;
        }
        if(yinhaoIndexList.get(yinhaoIndexList.size()-1)+2<a.length()) {//如果有还有的话，处理引号右边的字符串
            String s3=a.substring(yinhaoIndexList.get(yinhaoIndexList.size()-1)+2);
            String[] s4 = s3.indexOf("_")!=-1?s3.split("_"):new String[]{s3};
            ArrayList<String> list2 = new ArrayList(Arrays.asList(s4));
            resList.addAll(list2);
        }
        boolean flag=false;
        for(int i=0;i<resList.size();i++){
            if(i==0){stb.append(resList.get(i));
            continue;}
            if(i==b) {
                flag=true;
                stb.append("_").append("******");
                continue;
            }
            stb.append("_").append(resList.get(i).equals("")?"\"\"":resList.get(i));
        }

        System.out.println(flag?stb.toString():"ERROR");
    }
}
