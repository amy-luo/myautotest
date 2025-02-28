package com.mytest.ptbase.api.LTBai;

import java.util.*;

//查找一个有向网络的头节点和尾节点，https://renjie.blog.csdn.net/article/details/135583907
//用HashMap存放首尾节点的关系，一个头结点对应多个尾节点
//递归回溯，获取最终子节点，递归时记录被访问过的节点，回溯时记得恢复节点的访问状态，不能存在环
public class ChaZhaoYiGeYouXiangWangLuoTouJieDian {
    public static int[][] matrix;
    public static ArrayList<Integer> list;

    public static int m;
    public static int res;
    public static HashMap<Integer,ArrayList<Integer>> map;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int N = Integer.valueOf(in.nextLine());
            int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = firstHang.length;//row
            map = new HashMap<>();
            for (int i = 0; i < m; i = i + 2) {
                    ArrayList<Integer> list = map.getOrDefault(firstHang[i], new ArrayList<>());
                    list.add(firstHang[i + 1]);
                    map.put(firstHang[i], list);
            }

            list = new ArrayList<>();
             ArrayList<Integer> list2 = map.get(firstHang[0]);
             HashMap<Integer,Boolean> isVisited=new HashMap<>();//记录这个key是否已被访问过，不能成环
            isVisited.put(firstHang[0],true);//将首节点记录为访问过
            diguiFind(list2,isVisited);//递归获取子节点
            Collections.sort(list,((o1, o2) -> o2-o1));//从大到小排序
            StringBuilder stb=new StringBuilder();
                for(Integer o:list) {
                    if (!stb.toString().contains(o.toString())) {
                        stb.append(o + " ");
                    }
                }
            if(res!=-1){
               System.out.println(firstHang[0]+" "+stb.toString());
                }
            else{System.out.println(res);}
        }

    }
    private static void diguiFind(ArrayList<Integer> list2,HashMap<Integer,Boolean> isVisited){
        for(int j=0;j<list2.size();j++) {
            int index=list2.get(j);//获取下一个索引
            if (!isVisited.getOrDefault(index,false)) {
                if (map.get(index) == null) {//索引如果没有子节点的元素就是尾节点
                    list.add(index);
                    continue;
                } else {
                    ArrayList<Integer> list3 = map.get(index);//获取当前节点指向的下个节点的列表
                    isVisited.put(index,true);//更新节点访问状态
                    diguiFind(list3, isVisited);//递归下个节点列表，把已访问状态也传过去
                    isVisited.put(index,false);//恢复节点的访问状态
                }
            }else{
                res= -1;//如果节点指向的值，等于之前访问过的节点key。那么就是存在环，返回-1；
                break;
            }
        }
    }
}
