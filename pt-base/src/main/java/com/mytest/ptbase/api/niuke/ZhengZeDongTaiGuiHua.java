package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

//字符正则匹配设计和动态规划
public class ZhengZeDongTaiGuiHua {
    public boolean isMatch(String s, String p) {
        if(s.length()==p.length()){
            char[] cs=s.toCharArray();
            char[] ps=p.toCharArray();
            for(int i=0;i<s.length();i++){
                if(cs[i]!=ps[i]&&cs[i]!='.'&&ps[i]!='.'&&cs[i]!='*'&&ps[i]!='*'){
                    return false;
                }
                if(ps[i]=='*'&&ps[i-1]!=cs[i]&ps[i-1]!='.'){
                    return false;
                }
            }
            return true;
        }
        if(s.length()>p.length()){return false;}
        if(s.length()<p.length()){
            int m=s.length()+1;
            int n=p.length()+1;
            boolean[][] dp=new boolean[m][n];
            dp[0][0]=true;
            dp[0][1]=false;
            for(int i=1;i<m;i++){
                for(int j=2;j<n;j++){
                    dp[0][j]=true;
                    dp[1][1]=s.charAt(0)==p.charAt(0)||p.charAt(0)=='.';
                    if(i>1){dp[i][1]=false;}
                    dp[i][j]=p.charAt(j-1)=='*'?dp[i][j-1]||(dp[i-1][j-1]&&p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'):(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.')&&dp[i-1][j-1]||dp[i][j-1];
//                    System.out.println(s.charAt(i-1)+" "+p.charAt(j-1)+" "+dp[i][j]);
                }
            }
            return dp[m-1][n-1];
        }
        return true;
    }
    public static void main(String[] args){
        ZhengZeDongTaiGuiHua z=new ZhengZeDongTaiGuiHua();
        String s="aaa";
        String p="bca*";
        System.out.println(z.isMatch(s,p));
    }
}
