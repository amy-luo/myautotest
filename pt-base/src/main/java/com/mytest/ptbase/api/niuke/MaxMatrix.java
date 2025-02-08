package com.mytest.ptbase.api.niuke;


//最大矩阵，遍历每个点，求以这个点为矩阵【右下角】的所有矩阵面积。遍历左右的右下角。并求出每个右下角所对应的最大的连续1的长度；再增加高度，row->uprow
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//        示例 1：
//        输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//        输出：6
//        解释：最大矩形如上图所示。
public class MaxMatrix {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){return 0;}
        int[][] widthRow=new int[matrix.length][matrix[0].length];
        int maxA=0;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                // System.out.println("row col:"+row+" "+col);
                if(matrix[row][col]=='1'){
                    if(col==0){
                        widthRow[row][0]=1;
                    }else{widthRow[row][col]=widthRow[row][col-1]+1;
                        // System.out.println("widthRow: "+widthRow[row][col]);
                    }
                }else{
                    widthRow[row][col]=0;
                }

                int minWidthRow=widthRow[row][col];
                for(int uprow=row;uprow>=0;uprow--){
                    minWidthRow=Math.min(minWidthRow,widthRow[uprow][col]);
                    int height=row-uprow+1;
                    // System.out.println("minWidthRow*height: "+minWidthRow*height);
                    maxA=Math.max(maxA,minWidthRow*height);
                }
            }
        }
        return maxA;
    }
}
