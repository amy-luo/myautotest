package com.mytest.ptbase.api.LTBai;

import java.util.*;

//可以处理的最大任务，任务处理
//策略：尽早开始做，如果起始时间相同，选择结束时间最靠前的。选择完之后，要重新定义剩下任务的起始时间t+1，因为这个时间已经被已排任务占据了。
//用TreeMap将起始时间相同是一个key，同一个起始时间对应多个结束时间，是value，从小到大排序 ，先做小的（结束时间早的），
// 剩下的修改起始时间推到t+1天，TreeMap移除t天的key，将t+1天的key插入TreeMap（已有t+1要进行合并），t+1对应的value结束实际要重新排序。
//然后每次都取TreeMap第一个元素，重复，直至TreeMap为空。
public class RenWuChuLi {
    //要记得在代码中将TreeMap初始化
    public static TreeMap<Integer,ArrayList<Integer>> map;//存放起始时间，结束时间数组。
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
           int m=Integer.valueOf(in.nextLine());
            map = new TreeMap<>();//TreeMap初始化
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                ArrayList<Integer> list=map.getOrDefault(dataArray[0],new ArrayList<>());
                list.add(dataArray[1]);
                if(dataArray[1]>=dataArray[0]) {
                    map.put(dataArray[0], list);
                }
            }
            for(ArrayList<Integer> list:map.values()){
                Collections.sort(list);
            }

            int count=diguiFind();
            System.out.println(count);

        }
    }
    private static int diguiFind(){
        int count=0;
        while(map.size()!=0) {
            int t = map.firstKey();
            ArrayList<Integer> list = map.get(t);
                list.remove(0);//做结束时间最近的任务，剩下的任务修改启动时间，放入treemap重新排序
                count++;
                ArrayList<Integer> removeList = new ArrayList<>();
                for (Integer t1 : list) {
                    if (t1 == t) {
                        removeList.add(t1);
                    }
                }
                list.removeAll(removeList);
                map.remove(t);
            if(list.size()!=0){
                ArrayList<Integer> list2=map.getOrDefault(t+1,new ArrayList<>());
                list2.addAll(list);
                Collections.sort(list2);
                map.put(t+1,list2);
            }
        }
        return count;
    }
}
