package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//幼儿园篮球游戏，https://renjie.blog.csdn.net/article/details/135480833
//用LinkedList双向队列,模拟小朋友取球，老师放球的场景
public class LanQiuYouXi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] seconHang = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int m = firstHang.length;//row
            int n = seconHang.length;
            LinkedList<Integer> deque=new LinkedList();
            String res = "";
            int index=0;
            StringBuilder stb=new StringBuilder();
            for (int i = 0; i < n; i++) {
                //如果左右都无匹配，则增加编号，加到匹配为止，遍历完都没匹配，输出NO
                if(deque.size()==0||(deque.size()!=0&&deque.peekLast()!=seconHang[i]&&deque.peekFirst()!=seconHang[i])){
                    boolean flag=false;//如果遍历所有编号都无匹配，那就返回NO
                    for(int j=index;j<m;j++) {
                        deque.addLast(firstHang[j]);
                        if(firstHang[j]==seconHang[i]) {
                            index=j+1;//记住下一个指针，下次从这个为止开始增加编号，
                            flag=true;//找到编号，打个标记
                            break;
                        }
                    }
                    if(!flag){
                        res = "NO";//遍历完都没匹配，输出NO
                        break;
                    }
                }
                if(deque.peekFirst()==seconHang[i]){
                    deque.pollFirst();
                    stb.append("L").append(" ");
                    continue;
                }
                if(deque.peekLast()==seconHang[i]){
                    deque.pollLast();
                    stb.append("R").append(" ");
                }
            }
            System.out.println(res.equals("NO")?"NO":stb.toString());
        }
    }
}
