package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//生成哈夫曼树
//较难，https://renjie.blog.csdn.net/article/details/135609956
public class ShengChengHaFuManShu {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static ArrayList<Integer> list = new ArrayList<>();

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            in.nextLine();
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(dataArray);
            //初始化
            TreeNode treeNode = new TreeNode(dataArray[0], 0);//用个最小元素初始化
            TreeNode treeNode2;
            for (int i = 1; i < dataArray.length; i++) {//从下往上构建二叉树
                treeNode2 = new TreeNode(dataArray[i] + treeNode.value, i);//构成的新的上层节点
                TreeNode treeNode3 = new TreeNode(dataArray[i], 0);//当前元素构成的数
                if (dataArray[i] > treeNode.value) {
                    treeNode2.right = treeNode3;
                    treeNode2.left = treeNode;
                } else if (dataArray[i] < treeNode.value) {
                    treeNode2.left = treeNode3;
                    treeNode2.right = treeNode;
                } else if (dataArray[i] == treeNode.value) {
                   treeNode2.left = treeNode3;
                  treeNode2.right = treeNode;
                }
                treeNode = treeNode2;
            }
            String output=dfsOut(treeNode);
            output= output.replaceAll("\\s+"," ");//将所有多个空字符替换成1个空字符
            if(output.charAt(0)==' '){
                output = output.substring(1);//处理开头的空字符
            }
            System.out.println(output);
        }
    }

    private static String dfsOut(TreeNode treeNode) {
        String res="";
        if(treeNode.left!=null){ res+=" "+dfsOut(treeNode.left);}
        res+=" "+treeNode.value;
        if(treeNode.left!=null){res+=" "+dfsOut(treeNode.right);}
        return res;
    }

    private static class TreeNode {
        int value;
        int high;
        TreeNode left;
        TreeNode right;

        TreeNode(int value, int high) {
            this.value = value;
            this.high = high;
        }
    }

}
