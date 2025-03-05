package com.mytest.ptbase.api.oBai;

import java.util.*;

//比赛的冠亚季军,https://blog.csdn.net/misayaaaaa/article/details/130957810
public class BiSaiDeGuanYaJiJun {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            LinkedList<Integer[]> deque = new LinkedList<>();
            for(int i=0;i<s.length;i++){
                deque.addLast(new Integer[]{Integer.valueOf(s[i]),i});
            }
            LinkedList<Integer[]> deque2 = new LinkedList<>();
            if(deque.size()>4) {
                while (deque.size()!= 0) {
                    Integer[] tmp1 = deque.poll();
                    if (deque.peek() != null) {
                        Integer[] tmp2 = deque.poll();
                        if (tmp1[0] >= tmp2[0]) {
                            deque2.addLast(tmp1);
                        }
                    } else {
                        deque2.addLast(tmp1);
                    }
                    if (deque.size()==0&&deque2.size() > 4) {
                        deque.addAll(deque2);
                        deque2.clear();
                    }
                }
                deque.addAll(deque2);
            }

            ArrayList<Integer[]> win = new ArrayList<>();
            ArrayList<Integer[]> lose = new ArrayList<>();
            if(deque.size()==4){
                Integer[] d1=deque.poll();
                Integer[] d2=deque.poll();
                Integer[] d3=deque.poll();
                Integer[] d4=deque.poll();
                if(d1[0]>=d2[0]){
                    win.add(d1);
                    lose.add(d2);
                }else{
                    win.add(d2);
                    lose.add(d1);}
                if(d3[0]>=d4[0]){
                    win.add(d3);
                    lose.add(d4);
                }else{
                    win.add(d4);
                    lose.add(d3);}
            }
            if(deque2.size()==3){
                Integer[] d1=deque.poll();
                Integer[] d2=deque.poll();
                Integer[] d3=deque.poll();
                if(d1[0]>=d2[0]){
                    win.add(d1);
                    lose.add(d2);
                }else{
                    win.add(d2);
                    lose.add(d1);
                }
                    win.add(d3);
            }
            Collections.sort(win, (o1, o2) -> {
                if(o2[0]==o1[0]){
                    return o1[1] - o1[2];
                }
                return o2[0]-o1[0];
            });
            Collections.sort(lose, (o1, o2) -> {
                if(o2[0]==o1[0]){
                    return o1[1] - o1[2];
                }
                return o2[0]-o1[0];
            });
            System.out.println(win.get(0)[1]+" "+win.get(1)[1]+" "+lose.get(0)[1]);
        }
    }

}
