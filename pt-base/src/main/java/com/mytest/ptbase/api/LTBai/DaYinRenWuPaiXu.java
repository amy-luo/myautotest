package com.mytest.ptbase.api.LTBai;

import java.util.*;

//打印任务排序,https://renjie.blog.csdn.net/article/details/130785659
//使用linkedList双向队列，模拟场景进行排序，使用优先队列将元素的最大值顶到头部，用来比较，辅助排序。细节处理打印顺序。
public class DaYinRenWuPaiXu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] firstHang = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int m = firstHang.length;//row
            LinkedList<Integer[]> linkedList = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue=new PriorityQueue(new Comparator<Integer>() {//从大到小排序
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            for(int i=0;i<m;i++){
                linkedList.addLast(new Integer[]{firstHang[i],i});
                priorityQueue.add(firstHang[i]);
            }
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;priorityQueue.size()!=0;i++){
                if(i>=m){i=i-m;}
                Integer[] ar= linkedList.pollFirst();
                if(ar[0]<priorityQueue.peek()){
                    linkedList.addLast(ar);
                    continue;
                }else {
                    priorityQueue.poll();
                    list.add(ar[1]);
                };
            }
            //记录打印顺序
            int[] print=new int[m];
            for(int i=0;i<m;i++){
                print[list.get(i)]=i;
            }
            StringBuilder stb = new StringBuilder();
            for(int i=0;i<m;i++){
                stb.append(print[i]+" ");
            }
            System.out.println(stb.toString());
        }
    }

}
