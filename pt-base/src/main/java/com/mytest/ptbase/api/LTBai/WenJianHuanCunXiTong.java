package com.mytest.ptbase.api.LTBai;

import java.util.*;

//文件缓存系统,https://renjie.blog.csdn.net/article/details/135560275
//过程模拟，主要判断缓存满了之后去排序删除掉再放入
public class WenJianHuanCunXiTong {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int M = Integer.valueOf(in.nextLine());
            int n = Integer.valueOf(in.nextLine());
            int time = 0;
            HashMap<String, Integer[]> map = new HashMap<>();//key名称，value依次是：访问次数，time，大小
            String res = "";
            int sumCount = 0;
            for (int i = 0; i < n; i++) {
                String[] dataArray = in.nextLine().split(" ");
                String op = dataArray[0];
                String name = dataArray[1];
                if (op.equals("put")) {
                    Integer size = Integer.valueOf(dataArray[2]);
                    if (map.get(name) == null) {
                        Integer[] ar = new Integer[3];
                        ar[0] = 0;
                        ar[1] = time++;
                        ar[2] = size;
                        sumCount += size;
                        if (sumCount > M) {//判断缓存满了之后去排序删除掉再放入
                            ArrayList<Map.Entry<String, Integer[]>> tmpList = new ArrayList<>(map.entrySet());
                            Collections.sort(tmpList, (o1, o2) -> {
                                if (o1.getValue()[0] == o2.getValue()[0]) {
                                    return o1.getValue()[1] - o2.getValue()[1];
                                }
                                return o1.getValue()[0] - o2.getValue()[0];
                            });
                            ArrayList<String> removeList = new ArrayList<>();
                            for (int j = 0; j < tmpList.size(); j++) {
                                sumCount -= tmpList.get(j).getValue()[2];
                                removeList.add(tmpList.get(j).getKey());
                                if (sumCount <= M) {
                                    break;
                                }
                            }
                            for (int j = 0; j < removeList.size(); j++) {
                                map.remove(removeList.get(j));
                            }
                        }
                        map.put(name, ar);
                    }
                }
                if (op.equals("get")) {
                    if (map.get(name) != null) {
                        Integer[] ar = map.get(name);
                        ar[0]++;
                        ar[1] = time++;
                        map.put(name, ar);
                    }
                }
            }
            StringBuilder stb = new StringBuilder();
            ArrayList<String> outList = new ArrayList<>(map.keySet());
            Collections.sort(outList);
            for (String o : outList) {
                stb.append(o + ",");
            }
            if (stb.length() == 0) {
                System.out.println("NONE");
            } else {
                System.out.println(stb.substring(0, stb.length() - 1));
            }
        }
    }

}
