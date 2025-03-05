package com.mytest.ptbase.api.oBai;

import javafx.beans.binding.StringBinding;

import java.util.Scanner;
//TLV解析，信元解码，16进制小端序
//https://renjie.blog.csdn.net/article/details/128132577
public class TLVjieMaXinYuanJieMa {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String K = in.nextLine();
        String[] s=in.nextLine().split(" ");

        for(int i=0;i<s.length;i++){
            int length=Integer.parseInt(s[i+2]+s[i+1],16);
            if(s[i].equals(K)){
                StringBuilder stb=new StringBuilder();
                for(int j=i+3;j<i+3+length;j++){
                    stb.append(s[j].toUpperCase()).append(" ");
                }
                System.out.println(stb.toString());
                break;
            }
            i=i+2+length;
        }
    }
}
