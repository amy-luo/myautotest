package com.mytest.ptbase.api.niuke;
import java.util.*;

public class BeiBaoDongTaiGuiHua {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N=in.nextInt();//总价限制
        int m=in.nextInt();//商品总数
        // System.out.println(N+" "+m);
        Goods[] goods=new Goods[m];
        for(int i=0;i<m;i++){
            goods[i]=new Goods();
        }
        for(int i=0;i<m;i++){
            int v = in.nextInt();
            int p = in.nextInt();
            int q=in.nextInt();
            goods[i].v = v;
            goods[i].p = p*v;
            goods[i].q = q;
            // System.out.println(goods[i].v+" "+goods[i].p+" "+goods[i].q);
            if(q==0){goods[i].main=true;}else{
                if(goods[q-1].a1==-1){
                    goods[q-1].a1=i;
                }else if(goods[q-1].a2==-1){
                    goods[q-1].a2=i;
                }
            }
        }
        int[][] dp=new int[m+1][N+1];
        for(int i=1;i<=m;i++){
            for(int j=0;j<=N;j++){
                dp[0][j]=0;
                dp[i][0]=0;
                dp[i][j]=dp[i-1][j];
                if(goods[i-1].main==false){
                    continue;
                }
                if(goods[i-1].v<=j){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-goods[i-1].v]+goods[i-1].p);
                }
                if(goods[i-1].a1!=-1&&(goods[i-1].v+goods[goods[i-1].a1].v)<=j){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-goods[i-1].v-goods[goods[i-1].a1].v]+goods[i-1].p+goods[goods[i-1].a1].p);
                }
                if(goods[i-1].a2!=-1&&(goods[i-1].v+goods[goods[i-1].a2].v)<=j){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-goods[i-1].v-goods[goods[i-1].a2].v]+goods[i-1].p+goods[goods[i-1].a2].p);
                }
                if(goods[i-1].a1!=-1&&goods[i-1].a2!=-1&&(goods[i-1].v+goods[goods[i-1].a1].v+goods[goods[i-1].a2].v)<=j){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-goods[i-1].v-goods[goods[i-1].a1].v-goods[goods[i-1].a2].v]+goods[i-1].p+goods[goods[i-1].a1].p+goods[goods[i-1].a2].p);
                }
            }
        }
        System.out.println(dp[m][N]);
    }
}
class Goods{
    int v;//价格
    int p;//满意度=v*商品重要度
    int q;//是否主件
    boolean main=false;
    int a1=-1; //定义附件1的编号
    int a2=-1; //定义附件2的编号
}
