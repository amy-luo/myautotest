package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

//字母K距离重排，优先队列按照重复字母个数的优先级存储字符，普通队列（size为k）是存放取出去排列的字符的剩余个数，并在个数不为0时放回优先队列，为0时丢弃。
//当最终得到的字符串不等于原始字符串长度时，说明普通队列不满k，且普通队列空了，普通队列的值无法放回普通队列，所以拼接的字符串会缺少这些字符，无法按规则排上了。
public class KJvLiChongPai {
    public String reArrangeString(String s,int k){
        if(k==0){return s;}
        if(s.length()<k){return "";}
      PriorityQueue<int[]> q1=new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);
      Deque<int[]> q2=new ArrayDeque();
      StringBuilder srb=new StringBuilder();
      char[] ch=s.toCharArray();
      int[] count=new int[128];
      for(char c:ch){count[c]++;}
      for(char c='a';c<'z';c++){
          if(count[c]>0){q1.offer(new int[]{c,count[c]});};
      }
      System.out.println("q1 "+JSONObject.toJSONString(q1));
      while(!q1.isEmpty()){
          int[]o=q1.poll();
          srb.append((char)o[0]);
          System.out.println(srb.toString());
          o[1]--;
          q2.offer(o);
          System.out.println("q2 "+JSONObject.toJSONString(q2));
          if(q2.size()==k){
              int[] lin=q2.poll();
              if(lin[1]!=0) {
                  q1.offer(lin);
              }
          }
      }
      return s.length()==srb.length()?srb.toString():"";
    }

    public static void main(String[] args){
        KJvLiChongPai z=new KJvLiChongPai();
        System.out.println("res: "+z.reArrangeString("aaadbbcc",2));
    }
}
