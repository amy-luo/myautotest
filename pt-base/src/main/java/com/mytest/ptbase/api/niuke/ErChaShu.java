package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;

//二叉数最大路径和
public class ErChaShu {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum=root.val;
        if(root==null){return 0;}
        maxNode(root);
        return maxSum;
    }

    public int maxNode(TreeNode root){
        if (root == null) {return 0;}
        int l=maxNode(root.left);//递归找到左节点的最大值
        int r=maxNode(root.right);//递归找到右节点的最大值
        int maxLeft=Math.max(0,root.left!=null?l:0);//如果左节点最大值为负数，不加左节点，设置为0
        System.out.println("maxLeft:"+maxLeft);
        int maxRight=Math.max(0,root.right!=null?r:0);//如果右节点最大值为负数，不加右节点，设置为0
        //root.val+maxLeft+maxRight表示，只要根节点，或只要根+左，或只要根+右，表示带根节点时候的最大值。
        System.out.println("maxRight:"+maxRight);
        int a=root.left!=null?Math.max(root.val+maxLeft+maxRight,l):root.val+maxLeft+maxRight;//比较左节点，与带根节点时候的最大值，选最大值。如果左节点不存在，最大值就是带根节点的情况。
        System.out.println("a:"+a);
        int b=root.right!=null?Math.max(root.val+maxLeft+maxRight,r):root.val+maxLeft+maxRight;////比较右节点，与带根节点时候的最大值，选最大值。如果右节点不存在，最大值就是带根节点的情况。
        System.out.println("b:"+b);
        maxSum=Math.max(maxSum,Math.max(a,b));//存储最大值
        System.out.println("maxSum:"+maxSum);
        return root.val+Math.max(maxLeft,maxRight);//返回子节点的路径和的最大值
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
}
