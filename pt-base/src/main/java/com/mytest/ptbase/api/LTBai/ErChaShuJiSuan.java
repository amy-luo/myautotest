package com.mytest.ptbase.api.LTBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//二叉树，根据中序遍历和前序遍历构建二叉树，再写二叉树求和计算方法，再重新修改二叉树结果。
//非常难
public class ErChaShuJiSuan {

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            int[] order_zhong = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] order_qian = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = order_qian.length;
            TreeNode treeNode_root = dfsCreate(order_zhong, order_qian, 0, 0, m - 1);//根据中序遍历和前序遍历递归构建二叉树
            treeNode_root = dfsTree(treeNode_root);//通过递归求和方法，递归修改二叉树，从上往下修改。
            String output = dfsOutPut(treeNode_root);//递归打印二叉树
            while (output.indexOf("  ") != -1) {
                output = output.replaceAll("\\s+", " ");
            }
            if (output.charAt(0) == ' ') {
                output = output.substring(1);
            }
            System.out.println(output);
        }
    }

    private static TreeNode dfsCreate(int[] order_zhong, int[] order_qian, int root_qian, int zhong_left, int zhong_right) {
        int root_value = order_qian[root_qian];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = zhong_left; i <= zhong_right; i++) {
            if (root_value == order_zhong[i]) {
                list.add(i);
            }
        }
        int zhong_root = list.isEmpty() ? -1 : list.get(0);
        TreeNode treeNode_root = new TreeNode(root_value);
        if (zhong_root - 1 >= zhong_left) {
            treeNode_root.left = dfsCreate(order_zhong, order_qian, root_qian + 1, zhong_left, zhong_root - 1);
        }
        if (zhong_right >= zhong_root + 1) {
            treeNode_root.right = dfsCreate(order_zhong, order_qian, root_qian + zhong_root - zhong_left + 1, zhong_root + 1, zhong_right);
        }
        return treeNode_root;

    }

    private static int dfsSum(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int sum_root = treeNode.root + dfsSum(treeNode.left) + dfsSum(treeNode.right);
        return sum_root;
    }

    private static TreeNode dfsTree(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        treeNode.root = dfsSum(treeNode.left) + dfsSum(treeNode.right);
        if (treeNode.left != null) {
            treeNode.left = dfsTree(treeNode.left);
        }
        if (treeNode.right != null) {
            treeNode.right = dfsTree(treeNode.right);
        }
        return treeNode;
    }

    private static String dfsOutPut(TreeNode treeNode) {
        if (treeNode == null) {
            return "";
        }
        return dfsOutPut(treeNode.left) + " " + treeNode.root + " " + dfsOutPut(treeNode.right) + " ";
    }

    private static class TreeNode {
        public int root;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int root) {
            this.root = root;
            this.left = null;
            this.right = null;
        }
    }

    //暂时不检查
    private static boolean qianEqualZhong(int[] order_zhong, int[] order_qian, int qian_left, int qian_right, int zhong_left, int zhong_right) {
        Arrays.sort(order_qian);
        Arrays.sort(order_zhong);
        for (int i = qian_left; i <= qian_right; i++) {
            boolean flag = false;
            for (int j = zhong_left; j <= zhong_right; j++) {
                if (order_qian[i] == order_zhong[j]) {
                    flag = true;
                }
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }
}
