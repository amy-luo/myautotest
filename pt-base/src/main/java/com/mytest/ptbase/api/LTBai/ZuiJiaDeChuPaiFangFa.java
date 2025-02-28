package com.mytest.ptbase.api.LTBai;

import java.util.*;

//最佳的出牌方法，https://renjie.blog.csdn.net/article/details/131948426
//较难，一个顺子比不加这个顺子能带来多少增值(核心方法)，一个顺子或两个顺子又总共能带来多少增值。比较0个顺子，带1个顺子，带2个顺子的得分大小。
public class ZuiJiaDeChuPaiFangFa {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s=in.nextLine();
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch=='0'){map.put(10, map.getOrDefault(10, 0) + 1);}
                else if(ch=='1'&&((i<s.length()-1&&s.charAt(i+1)!='0')
                        ||i==s.length()-1)){map.put(1, map.getOrDefault(1, 0) + 1);}
                else if(ch=='J'){map.put(11, map.getOrDefault(11, 0) + 1);}
                else if(ch=='Q'){map.put(12, map.getOrDefault(12, 0) + 1);}
                else if(ch=='K'){map.put(13, map.getOrDefault(13, 0) + 1);}
                else if(ch!='1'){map.put(ch-'0', map.getOrDefault(ch-'0', 0) + 1);}//存放2-9
            }
            int res=0;
            //求不取顺子时的总和
            for(Integer o:map.keySet()){
                if(map.get(o)==1){res+=o;}
                if(map.get(o)==2||map.get(o)==3){res+=2*map.get(o)*o;}
                if(map.get(o)==4){res+=3*map.get(o)*o;}
            }
            int sum=res;
            int maxShunzi_global=0;//取多个顺子时，与不取顺子时，增加了多少（可能正，可能负）
            while(true){
                boolean flag=false;
                int maxShunzi=Integer.MIN_VALUE;
                int index=0;
                for(int i=1;i<=9;i++) {
                   int tmp=findAndCalShunZi(map,i);
                   if(tmp>maxShunzi){
                       flag=true;
                       maxShunzi=tmp;//找到最大的顺子，可能小于0，但也许后续还有顺子
                       index=i;
                   }
                }
                maxShunzi_global+=maxShunzi;//试图找到所有顺子，看这些顺子总共能带来多少增值，包括1个顺子，2个顺子，3顺子，等所有顺子
                if(!flag){break;}//没有顺子
                for (int i = index; i <= index + 4; i++) {//更新map，减去顺子占用的数量，在此基础上再循环查找更大的顺子。
                    map.put(i, map.get(i) - 1);
                }
                res=Math.max(res,sum+maxShunzi_global);//依次比较不取顺子，取一个顺子，取两个顺子时的结果大小
            }
            System.out.println(res);
            }
    }
    //找顺子，而且取计算能获取更大值的顺子,核心。
    private static int findAndCalShunZi(HashMap<Integer,Integer> map,int index){
        int cal=0;
        for(int i=index;i<=index+4;i++){
            if(map.get(i)==null||map.get(i)==0){return Integer.MIN_VALUE;}//没有包含这个元素的顺子，返回最小值
            else if(map.get(i)==1){cal+=i;}//单张，加i
            else if(map.get(i)==2){cal-=i;}//成对，减i
            else if(map.get(i)==4){cal-=4*i;}//炸，减4*i
        }
        return cal;
    }
}
