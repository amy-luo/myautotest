package com.mytest.ptbase.api.LTBai;

import java.util.*;

//任务最优调度，https://renjie.blog.csdn.net/article/details/130731537
//优先队列，任务次数最多的优先执行
public class RenWuZuiYouDiaoDu {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] renwu = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            Integer K = Integer.valueOf(in.nextLine());

            PriorityQueue<Integer[]> queue = new PriorityQueue((Comparator<Integer[]>) (o1, o2) -> o2[1]-o1[1]);//优先队列
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < renwu.length; i++) {
                map.put(renwu[i], map.getOrDefault(renwu[i], 0) + 1);
            }
            for(Integer o:map.keySet()){
                queue.offer(new Integer[]{o, map.get(o)});
            }
            int time=0;
            LinkedList<Integer[]> deque = new LinkedList();//辅助队列
            while(!queue.isEmpty()){
                Integer[] tmp=queue.poll();
                tmp[1]--;
                deque.add(tmp);
                time++;
                if(deque.size()==K+1){//辅助队列满了K+1,放回主队列
                    while(!deque.isEmpty()) {
                        if (deque.peek()[1] != 0) {
                            queue.offer(deque.poll());
                        }else{deque.poll();}
                    }
                }
                if(queue.isEmpty()&&!deque.isEmpty()&&deque.size()<K+1){//主队列空了，辅助队列不为空，也没满
                    int size = deque.size();
                    boolean flag=false;
                    while(!deque.isEmpty()) {
                        if (deque.peek()[1] != 0) {
                            flag=true;//当deque辅助队列中的数字个数不为0时，需要再回到主队列中
                            queue.offer(deque.poll());
                        }else{deque.poll();}
                    }
                    if(flag){time+=K+1-size;}//计算需要等待的时间。如果没有任务要放回就不需要计算这个等待时间了。
                }
            }
            System.out.println(time);
        }
    }

}
