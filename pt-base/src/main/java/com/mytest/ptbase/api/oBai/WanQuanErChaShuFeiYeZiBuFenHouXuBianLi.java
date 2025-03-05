package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//完全二叉树非叶子部分后序遍历,https://renjie.blog.csdn.net/article/details/128154245
//递归2 * index + 1和 2 * index + 2 找出待删除叶子节点和个数，从数组中删除最后一个元素，有多少个叶子节点就删除最后一个元素多少次。
//后续遍历递归放到list中，再String.join(" ", res)
public class WanQuanErChaShuFeiYeZiBuFenHouXuBianLi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            List<Integer> tree = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> removeList = new ArrayList<>();
            dfsFind(tree, 0, removeList);//找出待删除叶子节点
            int size = removeList.size();
            for(int i=0;i<size;i++) {
                tree.remove(removeList.size()-1);
            }
            List<String> res = new ArrayList<>();
            outPut(tree, 0, res);
            System.out.println(String.join(" ", res));
        }
    }

    private static void dfsFind(List<Integer> tree, int index, List<Integer> removeList) {
        if(index>=tree.size()){return;}
        if (2 * index + 1 >= tree.size() && 2 * index + 2 >= tree.size()) {
            removeList.add(tree.get(index));
        } else {
            dfsFind(tree, 2 * index + 1, removeList);
            dfsFind(tree, 2 * index + 2, removeList);
        }
    }

    private static void outPut(List<Integer> tree, int index, List<String> res) {
        if (index >= tree.size()) {
            return;
        }
        outPut(tree, 2 * index + 1, res);
        outPut(tree, 2 * index + 2, res);
        res.add(String.valueOf(tree.get(index)));
    }

}
