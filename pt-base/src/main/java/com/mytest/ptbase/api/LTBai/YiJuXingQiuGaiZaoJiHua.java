package com.mytest.ptbase.api.LTBai;

import java.util.*;

//宜居星球改造计划,https://renjie.blog.csdn.net/article/details/130756210
//bfs，用队列放置初始任务和下一个任务，hashSet放置下一个任务并去重，等队列任务执行完了，hashset就将下次要执行的任务给队列
public class YiJuXingQiuGaiZaoJiHua {
    public static int[] direct;
    public static int m;
    public static int n;
    public static int res;
    public static ArrayList<String[]>  list;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        list = new ArrayList<>();
        LinkedList<int[]> deque = new LinkedList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.equals("")) {
                break;
            }
            list.add(s.split(" "));
        }
        m = list.size();
        n = list.get(0).length;
        res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (list.get(i)[j].equals("YES")) {
                    deque.addLast(new int[]{i, j});
                }
            }
        }
        if(deque.isEmpty()){res=-1;}
        direct = new int[]{0, 1, 0, -1, 0};
        if(res!=-1) {
            bfsFind(deque);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (list.get(i)[j].equals("NO")) {
                    res=-1;
                    break;
                }
            }
        }
        System.out.println(res);
    }


    private static void bfsFind(LinkedList<int[]> deque) {
        HashSet<int[]> set = new HashSet<>();
        while (deque.size() != 0) {
            int[] position = deque.poll();
            for (int k = 0; k < 4; k++) {
                int x = position[0] + direct[k];
                int y = position[1] + direct[k + 1];
                if (0 <= x && x < m && 0 <= y && y < n && list.get(x)[y].equals("NO")) {
                    String[] sar=list.get(x);
                    sar[y]="YES";
                    list.set(x,sar);//修改list里某个位置的value值，不能用add不然会多出一行
                    set.add(new int[]{x, y});
                }
            }
            if (deque.isEmpty() && !set.isEmpty()) {
                res++;
                deque.addAll(set);
                set.removeAll(set);
            }

        }

    }
}
