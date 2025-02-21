package com.mytest.ptbase.api.oBai;

import java.util.*;

//AI面板识别，https://renjie.blog.csdn.net/article/details/130935787
//优先队列，队列1对y从小到大排序（y越小越高），队列2在y相等（或偏差小于半径算同一行）的x进行从小到大排序
public class AIMianBanShiBie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            Comparator comparator1=new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];//y从小到大排序
                }
            };
            Comparator comparator2=new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];//x从小到大排序
                }
            };
            int m = Integer.valueOf(in.nextLine());
            PriorityQueue<int[]> deque1 = new PriorityQueue<>(comparator1);//存放元素
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                deque1.add(dataArray);//按y从小到大排序
            }
            ArrayList<int[]> res = new ArrayList<>();//存放排好序的元素
            while (!deque1.isEmpty()) {
                int[] jichu=deque1.poll();
                PriorityQueue<int[]> deque2 = new PriorityQueue<>(comparator2);//存放符合要求的元素，按x从小到大排序
                ArrayList<int[]> list = new ArrayList<>();//存放不符合要求的元素
                deque2.add(jichu);
                while(!deque1.isEmpty()){
                    int[] yuansu = deque1.poll();
                    if (Math.abs(yuansu[2] - jichu[2]) <= (Math.abs(jichu[2] - jichu[4]))/2) {
                        deque2.add(yuansu);
                    } else {
                        list.add(yuansu);
                    }
                }
                deque1.addAll(list);
                res.addAll(deque2);
            }
            for (int[] o:res) {
                System.out.print(o[0] + " ");
            }
        }
    }

}
