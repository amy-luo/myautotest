package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//计算三叉搜索树的高度，https://renjie.blog.csdn.net/article/details/134767211
//较难，需要构建三叉树，每次新元素都从根节点开始判断放置位置，如果有了就再往下一层放。
public class JiSuanSanChaSouSuoShuDeGaoDu {
    public static int[] dataArray;

        public static int maxdepth;
    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            int m = Integer.valueOf(s);
//            int n = Integer.valueOf(s[1]);
            dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.addLast(dataArray[0]);
            int count = 1;
            TreeNode treeNode=new TreeNode(dataArray[0]);
            maxdepth=1;
            for(int i=1;i<dataArray.length;i++){
                dfsCreate(treeNode,dataArray[i],1);
            }
            System.out.println(maxdepth);
        }
    }
    private static void dfsCreate(TreeNode node,int value,int count){
        if(value<node.value-500){
            if(node.left!=null){
                dfsCreate(node.left,value,count+1);
            }else{
                node.left = new TreeNode(value);
                if(count+1>maxdepth){
                    maxdepth=count+1;
                }
                return;
            }
        }
        if(value>node.value+500){
            if(node.right!=null){
                dfsCreate(node.right,value,count+1);
            }else{
                node.right = new TreeNode(value);
                if(count+1>maxdepth){
                    maxdepth=count+1;
                }
                return;
            }
        }
        if(value>=node.value-500&&value<=node.value+500){
            if(node.mid!=null){
                dfsCreate(node.mid,value,count+1);
            }else{
                node.mid = new TreeNode(value);
                if(count+1>maxdepth){
                    maxdepth=count+1;
                }
                return;
            }
        }

    }
    private static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode mid;
        TreeNode(int value){
            this.value=value;
        }

    }

}

