package com.mytest.ptbase.api.LTBai;

import java.util.*;

//电脑病毒感染,https://renjie.blog.csdn.net/article/details/135139842
//dfs递归查找，计算到达每个节点的最小时间，记录到list，那么list中的最大值就是感染完所有节点的最短时间。
//hashMap存储节点关联关系和感染时间，递归查找。记录节点是否被访问。
public class DianNaoBingDuGanRan {
    public static HashMap<Integer, ArrayList<int[]>> map;//存储下一个节点关联关系和时间
    public static Boolean[] isVisited;//节点是否被访问
    public static Integer[] jiedianTimeMin;//存储到达每个节点的最短时间。
    public static int m;
    public static int n;
    public static int k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            n = Integer.valueOf(in.nextLine());
            m = Integer.valueOf(in.nextLine());
            isVisited = new Boolean[n];
            Arrays.fill(isVisited, false);
            map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                ArrayList<int[]> list = map.getOrDefault(dataArray[0], new ArrayList<int[]>());
                list.add(new int[]{dataArray[1], dataArray[2]});
                map.put(dataArray[0], list);
            }
            k = Integer.valueOf(in.nextLine());
            isVisited[k - 1] = true;
            jiedianTimeMin = new Integer[n];
            jiedianTimeMin[k-1]=0;
            Arrays.fill(jiedianTimeMin,-1);
            dfsFind(k, 0, isVisited);
            List<Boolean> blist = Arrays.asList(isVisited);
            List<Integer> blist2 = Arrays.asList(jiedianTimeMin);
            if (!blist.contains(false)) {
                System.out.println(Collections.max(blist2));
            } else {
                System.out.println(-1);
            }
        }
    }

    private static void dfsFind(int i, int count, Boolean[] isVisited) {
        ArrayList<int[]> list = map.getOrDefault(i, new ArrayList<>());
        if (!list.isEmpty()) {//有子节点
//            Collections.sort(list, Comparator.comparingInt(o -> o[1]));
            for (int[] o : list) {
                if (!isVisited[o[0] - 1]) {//未被访问过的节点直接递归。
                    jiedianTimeMin[o[0] - 1] = count+o[1];//到达该节点的时间，时间累积计算
                    isVisited[o[0] - 1] = true;//感染了更新状态
                    dfsFind(o[0], jiedianTimeMin[o[0] - 1], isVisited);//递归查找
                } else if (jiedianTimeMin[o[0] - 1] > count + o[1]) {//虽然以前访问过该节点，但出现了一个到达该节点更短的时间。
                    jiedianTimeMin[o[0] - 1] = count + o[1];//达到该节点的时间有更短的话，需要更新，再重新递归后面的节点进行更新
                    dfsFind(o[0], jiedianTimeMin[o[0] - 1], isVisited);//该节点出现更短的时间被感染，重新递归查找
                }
            }
        }
    }
}
